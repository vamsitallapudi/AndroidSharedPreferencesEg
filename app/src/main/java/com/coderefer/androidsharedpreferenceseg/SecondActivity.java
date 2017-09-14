package com.coderefer.androidsharedpreferenceseg;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvCall = (TextView)findViewById(R.id.tv_call);
        TextView tvDecision = (TextView) findViewById(R.id.tv_decision);

        //Accessing Android SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.MY_PREF,MODE_PRIVATE);
        String name = sharedPreferences.getString(MainActivity.KEY,"default");
        tvCall.setText("Hello " + name);
        boolean isHuman = sharedPreferences.getBoolean(MainActivity.BOOLEAN_KEY, false);
        if(isHuman){
            tvDecision.setText("Our app verified that you are a human. Congratulations!");
        } else{
            tvDecision.setText("Hey! you are not a human. Get out of my app!");
        }


    }
}
