package org.binarycommunity.paul.morswipesample;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    private TextView MorMesage;
    private GestureDetectorCompat gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MorMesage = (TextView)findViewById(R.id.MorText23);

        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        MorMesage.setText("On SingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        MorMesage.setText("On Double tap only");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        MorMesage.setText("On Double Tap event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        MorMesage.setText("On Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        MorMesage.setText("On Show Press");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        MorMesage.setText("On SingleTap");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        MorMesage.setText("On Scroll");

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        MorMesage.setText("On LongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        MorMesage.setText("On Fling");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
