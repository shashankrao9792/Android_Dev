package com.example.shashank.lab1a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.shashank.lab1a.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent i = new Intent(this, DisplayMessageActivity.class);
        EditText e = (EditText) findViewById(R.id.editText);
        String message = e.getText().toString();
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
}
