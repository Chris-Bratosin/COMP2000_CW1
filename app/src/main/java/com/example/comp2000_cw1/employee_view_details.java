package com.example.comp2000_cw1;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class employee_view_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.employee_details);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //code to find the button to navigate to edit details page
        Button editDetailsBtn = findViewById(R.id.editDetailsBtn);

        //setting the onClickListener so that navigation to employee_edit_details is possible
        editDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_view_details.this, employee_edit_details.class);
                startActivity(intent);
            }
        });

        //code to find the button to navigate to the holidays page
        Button employeeHolidaysBtn = findViewById(R.id.employeeHolidaysBtn);

        //setting the onClickListener so that navigation to employee_holidays is possible
        employeeHolidaysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_view_details.this, employee_holidays.class);
                startActivity(intent);
            }
        });

        //code to find the button to navigate to the settings page
        Button settingsBtn = findViewById(R.id.settingsBtn);

        //setting the onClickListener so that navigation to settings page is possible
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_view_details.this, settings_page.class);
                startActivity(intent);
            }
        });

        //code to find the button to navigate to the settings page
        Button NotificationsBtn = findViewById(R.id.NotificationsBtn);

        //setting the onClickListener so that navigation to settings page is possible
        NotificationsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_view_details.this, employee_notifications.class);
                startActivity(intent);
            }
        });



    }
}

