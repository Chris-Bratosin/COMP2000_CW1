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

public class employee_holidays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.employee_holidays);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //code to find the button to navigate to the request holidays page
        Button reqeuestHolidayBtn = findViewById(R.id.reqeuestHolidayBtn);

        //setting the onClickListener so that navigation to request holidays page is possible
        reqeuestHolidayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_holidays.this, employee_request_holiday.class);
                startActivity(intent);
            }
        });

        //code to find the button to navigate to the manage holidays page
        Button manageHolidayBtn = findViewById(R.id.manageHolidayBtn);

        //setting the onClickListener so that navigation to manage holidays page is possible
        manageHolidayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_holidays.this, employee_manage_holiday.class);
                startActivity(intent);
            }
        });

        //code to find the button to navigate to the manage holidays page
        Button holidaysHomeButton = findViewById(R.id.holidaysHomeButton);

        //setting the onClickListener so that navigation to manage holidays page is possible
        holidaysHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_holidays.this, employee_view_details.class);
                startActivity(intent);
            }
        });
    }
}