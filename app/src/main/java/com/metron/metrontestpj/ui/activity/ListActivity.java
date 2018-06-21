package com.metron.metrontestpj.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.metron.metrontestpj.R;
import com.metron.metrontestpj.database.EmployeeAccess;
import com.metron.metrontestpj.model.Employee;
import com.metron.metrontestpj.ui.adapter.EmployeeListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ListView listEmployee;
    private Button btnBack;
    private EmployeeAccess employeeAccess = new EmployeeAccess();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employee);
        initViews();
        eventListners();
        setAdapter();
    }

    private void setAdapter() {

        ArrayList<Employee> employeesList = new ArrayList<>();
        employeesList.clear();
        employeesList = (ArrayList<Employee>) employeeAccess.FetchEmployeeDetailsList(this);
        EmployeeListAdapter adapter = new EmployeeListAdapter(this, employeesList);
        listEmployee.setAdapter(adapter);
    }

    private void eventListners() {




        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initViews() {

        listEmployee = (ListView) findViewById(R.id.listEmployee);
        btnBack=findViewById(R.id.btnBack);

    }


}
