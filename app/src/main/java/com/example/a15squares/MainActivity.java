package com.example.a15squares;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        SquareModel model = new SquareModel();
        Squares squares = findViewById(R.id.somethinsquares);
        SquareController squareController = new SquareController(model, squares);

        squares.setOnTouchListener(squareController);
        squares.setOnDragListener(squareController);

        Button reset = findViewById(R.id.Reset);
        reset.setOnClickListener(squareController);

        SeekBar amt = findViewById(R.id.SquareAmt);
        amt.setOnSeekBarChangeListener(squareController);
    }
}