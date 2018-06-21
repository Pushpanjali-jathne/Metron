package com.metron.metrontestpj.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;

import com.metron.metrontestpj.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAccess implements EmployeeInterface {



    @Override
    public void InsertEmployeeDetailsList(Employee myEmplyoee, Context context) {
        SQLiteDatabase db = DatabaseHandler.getInstance(context).getWritableDatabase();
        try {
            ContentValues values;
            values = new ContentValues();
            values.put(DatabaseHandler.ID, myEmplyoee.getId());
            values.put(DatabaseHandler.NAME, myEmplyoee.getName());
            values.put(DatabaseHandler.ADDRESS, myEmplyoee.getAddress());
            values.put(DatabaseHandler.AGE, myEmplyoee.getAge());

            long value = db.insert(DatabaseHandler.TABLE_EMPLOYEE, null, values);
            Log.d("EmployeeLength", "EmployeeLength" + value);

        } catch (Exception e) {
            Log.d("Exception", "Exception" + e.getMessage());
        } finally {
            db.close();
        }
    }

    @Override
    public List<Employee> FetchEmployeeDetailsList(Context context) {
        List<Employee> userInfoData = new ArrayList<Employee>();
        Employee userInfo;
        SQLiteDatabase db = DatabaseHandler.getInstance(context).getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseHandler.TABLE_EMPLOYEE;
        try {
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                do {

                    userInfo = new Employee();
                    userInfo.setId(cursor.getString(cursor.getColumnIndex(DatabaseHandler.ID)));
                    userInfo.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseHandler.ADDRESS)));
                    userInfo.setAge(cursor.getString(cursor.getColumnIndex(DatabaseHandler.AGE)));
                    userInfo.setName(cursor.getString(cursor.getColumnIndex(DatabaseHandler.NAME)));
                    userInfoData.add(userInfo);

                } while (cursor.moveToNext());


            }
            cursor.close();

        } catch (Exception e) {
            Log.d("Exception", "Exception" + e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            db.close();
        }

        Log.d("ACtiveLength", "inside length" + userInfoData.size());
        return userInfoData;
    }

    @Override
    public void DeleteEmployeeDetailsID(Context context, String id) {
        SQLiteDatabase db = DatabaseHandler.getInstance(context).getWritableDatabase();

        try {
            int i = db.delete(DatabaseHandler.TABLE_EMPLOYEE, DatabaseHandler.ID + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception e) {

            Log.d("Exception", "Exception" + e.getMessage());

        } finally {
            db.close();
        }
    }

    public void deleteAll(Context context) {
        SQLiteDatabase db = DatabaseHandler.getInstance(context).getWritableDatabase();
        try {
            db.execSQL("delete from " + DatabaseHandler.TABLE_EMPLOYEE);
            db.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Log.d("Exception", "Exception" + e.getMessage());
        } finally {
            db.close();
        }
    }
}
