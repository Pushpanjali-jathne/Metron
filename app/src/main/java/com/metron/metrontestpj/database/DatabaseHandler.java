package com.metron.metrontestpj.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    /*
     * Variables for the Database Handler
     */
    private static final int DATABASE_VERSION = 1;
    public static String DBPATHMAIN = null;
    private static DatabaseHandler _dbHelper;
    private static String DB_PATH = "";
    public static String DB_NAME = "MetronTest";
    private SQLiteDatabase database;
    private final Context _context;

    /*
     * Declare the tables here
     */

    public static String TABLE_EMPLOYEE = "TABLE_EMPLOYEE";

    //    adding column details
    public static String ID = "ID";
    public static String NAME = "NAME";
    public static String AGE = "AGE";
    public static String ADDRESS = "ADDRESS";

    public static DatabaseHandler getInstance(Context context) {
        if (_dbHelper == null) {
            _dbHelper = new DatabaseHandler(context);
        }
        return _dbHelper;
    }

    public static DatabaseHandler getInstance() {
        return _dbHelper;
    }

    @SuppressLint("SdCardPath")
    DatabaseHandler(Context context) {
        super(context, DB_NAME, null, 1);

        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        DBPATHMAIN = DB_PATH + DB_NAME;
        getWritableDatabase();
        this._context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        DBPATHMAIN = DB_PATH + DB_NAME;
        database = db;
        getEmployeeDetails();
    }

    private void getEmployeeDetails() {
        String query = ("CREATE TABLE " + TABLE_EMPLOYEE + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " STRING NOT NULL , "
                + ADDRESS + " STRING NOT NULL , "
                + AGE + " STRING NOT NULL ) "
        );
        database.execSQL(query);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);

        onCreate(db);
    }


}
