package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPw;
    Button btLogin;
    String strUsername;
    String strPassword;

    String[] username = {"din_djarin"};
    String[] pw = {"baby_yoda_ftw"};
    String[] userid = {"1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.etUsername);
        etPw = findViewById(R.id.etPw);
        btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                strUsername = etUsername.getText().toString();
                strPassword = etPw.getText().toString();
//                Log.d("myDebugTab", String.valueOf(verifyUsername(strUsername)));
//                Log.d("myDebugTab", String.valueOf(verifyPassword(strPassword)));
                if (!verifyUsername(strUsername)) {
                    etUsername.setError("Incorrect Username");
                }

                if (!verifyPassword(strPassword)) {
                    etPw.setError("Incorrect Password");
                }

                if (verifyUsername(strUsername) && verifyPassword(strPassword)) {
                    int idx = Arrays.asList(username).indexOf(strUsername);
                    intent.putExtra("userid", userid[idx]);
                    intent.putExtra("username", strUsername);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    static Boolean verifyUsername(String strUsername) {
        String[] username = {"din_djarin"};
        return Arrays.stream(username).anyMatch(strUsername::equals);
    }

    static Boolean verifyPassword(String strPassword) {
        String[] pw = {"baby_yoda_ftw"};
        return Arrays.stream(pw).anyMatch(strPassword::equals);
    }

    private static <KEY, VALUE> void put(Map<KEY, List<VALUE>> map, KEY key, VALUE value) {
        map.compute(key, (s, strings) -> strings == null ? new ArrayList<>() : strings).add(value);
    }

}