package com.metron.metrontestpj.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.metron.metrontestpj.R;
import com.metron.metrontestpj.database.EmployeeAccess;

import java.util.List;

public class Home extends AppCompatActivity {
    private Button btnAdd, btnList, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        eventListners();
    }

    private void eventListners() {

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,AddEmployee.class);
                startActivity(intent);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View v) {

                Intent intent = new Intent(Home.this,ListActivity.class);
                startActivity(intent);

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmployeeAccess employeeAccess = new EmployeeAccess();
                employeeAccess.deleteAll(Home.this);
                Toast.makeText(getApplicationContext(),"All employees are cleared",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initViews() {

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnList = (Button) findViewById(R.id.btnList);
        btnClear = (Button) findViewById(R.id.btnClear);

    }



}
