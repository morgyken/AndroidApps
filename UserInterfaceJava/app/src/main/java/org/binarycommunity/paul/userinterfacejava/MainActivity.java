package org.binarycommunity.paul.userinterfacejava;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Init Layout and button
        RelativeLayout morLayout = new RelativeLayout(this);
        morLayout.setBackgroundColor(Color.GREEN);
        //wrap content for the layout
        RelativeLayout.LayoutParams MorBtnParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );



        MorBtnParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        MorBtnParams.addRule(RelativeLayout.CENTER_VERTICAL);
        Button morButton = new Button(this);
        morButton.setText("User Signup");
        morButton.setBackgroundColor(Color.RED);
        morButton.setId(1);


        EditText username = new EditText(this);

        RelativeLayout.LayoutParams UsernameDetails= new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        UsernameDetails.addRule(RelativeLayout.ABOVE, morButton.getId());
        UsernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        UsernameDetails.setMargins(0,0,0,50);
        Resources res = getResources();

        int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200,
                res.getDisplayMetrics()
                );
        username.setWidth(px);
        username.setId(2);


        //add button to Layout
        morLayout.addView(morButton, MorBtnParams);
        morLayout.addView(username, UsernameDetails);


        //use activity for main display

        setContentView(morLayout);
    }
}
