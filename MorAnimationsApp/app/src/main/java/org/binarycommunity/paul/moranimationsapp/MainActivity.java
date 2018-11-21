package org.binarycommunity.paul.moranimationsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ViewGroup MorgykenLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       MorgykenLayout = (ViewGroup)findViewById(R.id.MorLayout);

       MorgykenLayout.setOnTouchListener(
               new RelativeLayout.OnTouchListener(){
                   @Override
                   public boolean onTouch(View v, MotionEvent event)
                   {
                       moveButton();
                       return true;
                   }

               }
       );

    }

    public void moveButton(){
        View Morbutt = findViewById(R.id.MorButton);
        //change the position of the button
        TransitionManager.beginDelayedTransition(MorgykenLayout);

        RelativeLayout.LayoutParams  PositioningRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        PositioningRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        PositioningRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        Morbutt.setLayoutParams(PositioningRules);
        //change the size of the buttom
        ViewGroup.LayoutParams sizeRules = Morbutt.getLayoutParams();
        sizeRules.width =450;
        sizeRules.height= 300;
        Morbutt.setLayoutParams(sizeRules);
    }

}
