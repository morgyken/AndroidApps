package org.binarycommunity.paul.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Apple_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_activity);

        Bundle appledata = getIntent().getExtras();

        if(appledata == null)
        {
            return;
        }
        String appleMsg = appledata.getString("MorMessage");

        final TextView passedText = (TextView) findViewById(R.id.MorBacon);
        passedText.setText(appleMsg);
    }

    public void onClickBack (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
