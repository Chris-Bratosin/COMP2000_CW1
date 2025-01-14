package com.example.comp2000_cw1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class admin_view_employees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_view_employees);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //code to find the button to navigate to the settings page
        Button viewEmployees_ReturnBtn = findViewById(R.id.viewEmployees_ReturnBtn);

        //setting the onClickListener so that navigation to settings page is possible
        viewEmployees_ReturnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_view_employees.this, admin_main_hub.class);
                startActivity(intent);
            }
        });


        Button addEmployeeBtn = findViewById(R.id.addEmployeeBtn);


        addEmployeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_view_employees.this, admin_create_new_employee.class);
                startActivity(intent);
            }
        });


        Button DeletingEmployees_button = findViewById(R.id.DeletingEmployees_button);


        DeletingEmployees_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_view_employees.this, admin_delete_employee.class);
                startActivity(intent);
            }
        });
    }
}