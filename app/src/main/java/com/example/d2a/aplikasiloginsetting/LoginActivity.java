package com.example.d2a.aplikasiloginsetting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginApp(View view) {
        EditText edtUsername, edtPassword;
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();


        if(username.equals("yoga") && password.equals("wiranto")){
            SharedPreferences sp = getSharedPreferences("login.file", MODE_PRIVATE);
            SharedPreferences.Editor spEdit = sp.edit();

            spEdit.putString("username", username);
            spEdit.putString("password", password);
            spEdit.apply();

            Intent it = new Intent(this, MainActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(it);

        }
    }
}
