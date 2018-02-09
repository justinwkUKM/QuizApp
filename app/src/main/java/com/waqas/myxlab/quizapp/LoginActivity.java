package com.waqas.myxlab.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    Button btLogin, btSignUp;
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btLogin = (Button) findViewById(R.id.buttonLogin);
        btSignUp = (Button) findViewById(R.id.buttonSignUp);
        etUsername = (EditText) findViewById(R.id.editTextUsername);
        etPassword = (EditText) findViewById(R.id.editTextPassword);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stUsername = etUsername.getText().toString();
                String stPassword = etPassword.getText().toString();
                SharedPreferences sp = getApplicationContext().
                        getSharedPreferences("MyData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username", stUsername);
                editor.putString("password", stPassword);
                editor.commit();
                Snackbar.make(view, "SignUp Successful", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getApplicationContext().
                        getSharedPreferences("MyData", MODE_PRIVATE);
                String username = sp.getString("username", "DefaultValue");
                String password = sp.getString("password", "DefaultValue");
                //Toast.makeText(LoginActivity.this,"User:"username+" Pass:"+password,Toast.LENGTH_SHORT).show();
                String typedUsername = etUsername.getText().toString();
                String typedPassword = etPassword.getText().toString();

                if (typedUsername.equals(username) && typedPassword.equals(password)){
                    Intent i = new Intent(LoginActivity.this, MainMenuActivity.class);
                    startActivity(i);
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Snackbar.make(view, "Login Failed", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }












                //Intent i = new Intent(LoginActivity.this, MainMenuActivity.class);
                //startActivity(i);
            }
        });










        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
