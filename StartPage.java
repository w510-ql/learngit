package com.example.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPage extends Activity {

    Button newsButton;
    Button messageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);


        newsButton = findViewById(R.id.newsButton);
        newsButton.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v){
                  Intent intent = new Intent(StartPage.this, NewsFeed.class);
                  startActivity(intent);
              }
          }
        );

        messageButton = findViewById(R.id.messageButton);
        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(StartPage.this, Message.class);
                startActivity(intent);
            }
        });

    }
}