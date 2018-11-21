package org.clearleafs.morgyken.morthreadsapplications;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //use handler to change Interface

    Handler morHandler = new Handler(){
        @Override

        public void handleMessage(Message msg) {

            TextView morgyTextView = (TextView) findViewById(R.id.textView2);
            morgyTextView.setText("Nice Work Morgan !");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MorButtonClock (View view) {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long futuretime = System.currentTimeMillis() + 5000;
                while(System.currentTimeMillis() < futuretime)
                {
                    synchronized (this) {
                        try{
                            wait(futuretime-System.currentTimeMillis()); //deal with threads
                        }
                        catch (Exception e) {}
                    }
                }
                morHandler.sendEmptyMessage(0);
            }
        };
        //Do not update interface within the thread
        //Run many threads at the same time

        Thread MorTHread = new Thread(runnable);
        MorTHread.start();
    }
}
