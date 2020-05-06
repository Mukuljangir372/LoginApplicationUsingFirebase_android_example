package com.mukuljangir.application.loginapplicationusingfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText email,password,name;
    private Button register_button;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getting intent from MainActivity
        Intent intent = getIntent();

        //to read and write database, we have to get reference
        mDatabase = FirebaseDatabase.getInstance().getReference("User");

        //accessing components
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        register_button = (Button) findViewById(R.id.register);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentEmail = email.getText().toString();
                String currentPass = password.getText().toString();
                String currentName = name.getText().toString();
                if(currentEmail.equals("") || currentPass.equals("")) {

                    Toast.makeText(getApplicationContext(),"Fill above info",Toast.LENGTH_SHORT).show();
                }else {
                   writeNewUser(currentName,currentEmail,currentPass);
                    Toast.makeText(getApplicationContext(),"Register Completed",Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }
        });

    }
    private void writeNewUser(String name,String email,String password) {
        //In database,id must be String.
        mDatabase.child("User").child(name).child("Email").setValue(email);
        mDatabase.child("User").child(name).child("Password").setValue(password);
    }
}
