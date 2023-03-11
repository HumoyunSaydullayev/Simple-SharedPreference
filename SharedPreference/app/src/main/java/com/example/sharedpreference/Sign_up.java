package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sign_up extends AppCompatActivity {

    private EditText email;
    private EditText password;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.Sign_EmailAddress);
        password = findViewById(R.id.Sign_Password);
        TextView erroremail = findViewById(R.id.Sign_erroremail);
        TextView errorpassword = findViewById(R.id.Sign_errorpassword);
        TextView back = findViewById(R.id.have_login);
        Button sign = findViewById(R.id.Sign);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_up.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        sign.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("") && password.getText().toString().equals("")) {
                    erroremail.setText("*Email field empty !!!");
                    errorpassword.setText("*Password field empty !!!");
                } else if (email.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    erroremail.setText("*Email field empty !!!");
                    errorpassword.setText("");
                } else if (!email.getText().toString().equals("") && password.getText().toString().equals("")) {
                    erroremail.setText("");
                    errorpassword.setText("*Password field empty !!!");
                } else {
                    sharedPreferences=getSharedPreferences("MyUsers", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("email", email.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.apply();

                    Intent intent = new Intent(Sign_up.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
    public void onBackPressed(){
        Intent intent=new Intent(Sign_up.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}