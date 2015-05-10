package com.ipn.mauriciodinki.drawingcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawingView customView = new DrawingView(this);
        setContentView(customView);
    }

    class DrawingView extends View {
        Path path = new Path();
        float x = -100;
        float y = -100;
        String text = "Event";
        String action = "Action";
        int radius = 20;

        public DrawingView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            canvas.drawColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6);
            paint.setColor(Color.WHITE);
            path.addCircle(x, y, radius, Path.Direction.CW);
            canvas.drawPath(path, paint);

            paint.setColor(Color.GRAY);
            paint.setTextSize(20);
            paint.setStrokeWidth(2);
            canvas.drawText(text, 300, 25, paint);
            canvas.drawText("x = " + x +  "  y = " + y, 5, 25, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = event.getX();
            y = event.getY();
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                action = "down";
                text = "Action Down";
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                text = "Action Up";
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                action = "move";
                text = "Action Move";
            }
            invalidate();
            return true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
