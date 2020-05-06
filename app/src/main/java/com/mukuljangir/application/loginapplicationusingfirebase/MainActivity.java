package com.mukuljangir.application.loginapplicationusingfirebase;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Button signUP,login;
    private EditText email,password,name;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //to read and write,we have to get reference
        ref = FirebaseDatabase.getInstance().getReference();

        signUP = (Button) findViewById(R.id.SignUp);
        login =(Button) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        name = (EditText) findViewById(R.id.name);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               String currentName = name.getText().toString();
                 String currentEmail = email.getText().toString();
                 String currentPass = password.getText().toString();
                if(currentEmail.equals("") || currentPass.equals("")) {
                    Toast.makeText(getApplicationContext(),"Fill above info",Toast.LENGTH_SHORT).show();
                }else {




                }
            }

        });

        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startRegisterActivity();
            }
        });

    }
    private void startProfileActivity() {
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(intent);
    }
    private void startRegisterActivity() {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent); }

}
