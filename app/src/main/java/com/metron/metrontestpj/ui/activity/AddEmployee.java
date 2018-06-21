package com.metron.metrontestpj.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.metron.metrontestpj.R;
import com.metron.metrontestpj.database.EmployeeAccess;
import com.metron.metrontestpj.model.Employee;

public class AddEmployee extends AppCompatActivity {
    private Button btnAdd;
    private EditText etName, etAddress, etAge;
    EmployeeAccess employeeAccess = new EmployeeAccess();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initViews();
        eventListners();
    }

    private void eventListners() {

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employee = new Employee();
                employee.setAddress(etAddress.getText().toString());
                employee.setName(etName.getText().toString());
                employee.setAge(etAge.getText().toString());
                employeeAccess.InsertEmployeeDetailsList(employee, AddEmployee.this);
                Toast.makeText(getApplicationContext(),"employee added",Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }

    private void initViews() {

        btnAdd = (Button) findViewById(R.id.btnAdd);
        etName = (EditText) findViewById(R.id.etName);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etAge = (EditText) findViewById(R.id.etAge);
    }


}
