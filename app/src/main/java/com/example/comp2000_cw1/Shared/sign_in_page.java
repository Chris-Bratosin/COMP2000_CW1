package com.example.comp2000_cw1.Shared;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comp2000_cw1.Admin.admin_main_hub;
import com.example.comp2000_cw1.Employee.employee_view_details;
import com.example.comp2000_cw1.Models.DbHelper;
import com.example.comp2000_cw1.R;

public class sign_in_page extends AppCompatActivity
{

    //declaring the variables for the username, password and sign in button
    private EditText usernameEditText, passwordEditText;
    private Button signInButton;

    //declaring a variable for the database helper so that it can interact with the SQLite Database
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);

        //linking the ui elements in the layout file to the corresponding variables
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);


        //initialising the database helper to access the database
        dbHelper = new DbHelper(this);

        //set onClickListener for the sign in button
        signInButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                handleLogin();
            }
        });
    }

    private void handleLogin()
    {
        //getting the username and password from the edit text fields from the user
        String email = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        //validation to check if the fields are empty
        if (email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        //validate the user using the database helper
        String role = dbHelper.validateUser(email, password);

        //checking if the credentials match to that of an admin or employee
        if (role == null)
        {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
        else
        {
            // navigate to the appropriate page based on the role
            if (role.equals("admin"))
            {
                startActivity(new Intent(sign_in_page.this, admin_main_hub.class));
            }
            else if (role.equals("employee"))
            {
                startActivity(new Intent(sign_in_page.this, employee_view_details.class));
            }
        }
    }
}
