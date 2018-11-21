package org.binarycommunity.paul.mornewfirstbuttonclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button morbutt = (Button) findViewById(R.id.MorButton);
        Button morbutt1 = (Button)findViewById(R.id.MorButt1);

        morbutt.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        TextView mortextView = (TextView)findViewById(R.id.MorText);
                        mortextView.setText("I have been Changed!");
                    }
                }
        );

        morbutt1.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v)
                    {
                        TextView mortextView = (TextView)findViewById(R.id.MorText);
                        mortextView.setText("Original Text here");
                        return true;
                    }
                }
        );

        morbutt.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v)
                    {
                        TextView mortextView = (TextView)findViewById(R.id.MorText);
                        mortextView.setText("Long Click to give it up");
                        return true;
                    }
                }
        );

    }
}
