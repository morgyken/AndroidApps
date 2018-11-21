package org.clearleafs.morgyken.morthreadsapplications;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MorButtonClock (View view) {
        long futuretime = System.currentTimeMillis() + 10000;
        while(System.currentTimeMillis() < futuretime)
        {
            synchronized (this) {
                try{
                    wait(futuretime-System.currentTimeMillis());
                }
                catch (Exception e) {}
            }
        }
        TextView morgyTextView = (TextView) findViewById(R.id.textView2);
        morgyTextView.setText("Nice Work !");
    }
}
