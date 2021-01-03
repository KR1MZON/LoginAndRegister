package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText email,pass ;
    Button login ;
    DatabaseHelper db ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this) ;
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext =email.getText().toString();
                String passwordtext =pass.getText().toString();
                Boolean chkemailpassword =db.emailpass(emailtext,passwordtext);
                if (chkemailpassword==true){
                    Toast.makeText(getApplicationContext(), "Login Successful  ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Email or password is wrong ", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}

