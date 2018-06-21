package com.metron.metrontestpj.database;

import android.content.Context;
import com.metron.metrontestpj.model.Employee;

import java.util.List;

public interface EmployeeInterface {

    void InsertEmployeeDetailsList(Employee myEmplyoee, Context context);
    List<Employee> FetchEmployeeDetailsList(Context context);
    void DeleteEmployeeDetailsID(Context context, String id);


}
