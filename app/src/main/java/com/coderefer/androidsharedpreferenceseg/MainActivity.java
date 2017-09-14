package com.coderefer.androidsharedpreferenceseg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREF = "MyPref";
    public static final String KEY = "MY_NAME_KEY";
    public static final String BOOLEAN_KEY = "MY_IDENTITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etUsername = (EditText) findViewById(R.id.et_username);
        final CheckBox cbAreYouHuman = (CheckBox) findViewById(R.id.cb_verify_humanity);
        Button  login = (Button) findViewById(R.id.b_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY, etUsername.getText().toString());
                editor.putBoolean(BOOLEAN_KEY, cbAreYouHuman.isChecked());
                editor.apply();

                Intent  i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);


            }
        });
    }
}
