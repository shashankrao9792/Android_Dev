package com.example.shashank.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveMessageActivity extends Activity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_message);
        Intent intent = getIntent();
        String m = intent.getStringExtra(EXTRA_MESSAGE);
        TextView mView = (TextView) findViewById(R.id.message);
        mView.setText(m);
    }


}
