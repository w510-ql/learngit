package com.example.applicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnterActivity extends AppCompatActivity {
    Button login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        login = findViewById(R.id.bn_enter_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        register = findViewById(R.id.bn_enter_register);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
//    searchButton = (ImageButton) findViewById(R.id.search_button);
//        searchButton.setOnClickListener(new OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
//            startActivity(intent);
//        }
//    });

    }
}