package org.binarycommunity.paul.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view ){
        Intent intent = new Intent(this, Apple_activity.class);
        final EditText input = (EditText)findViewById(R.id.MorEditText);
        String MorName = input.getText().toString();
        intent.putExtra("MorMessage", MorName);
        startActivity(intent);
    }
}
