package com.example.a15squares;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

public class Squares extends SurfaceView {

    //Instance Vars
    private SquareModel squareModel;
    private SquareController squareController;
    private Paint square = new Paint();

    //Constructor
    public Squares(Context context, AttributeSet attrs) {
        super(context, attrs);
        squareModel = new SquareModel();

        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        square.setColor(Color.BLACK);
        square.setStyle(Paint.Style.STROKE);
    }

    public Squares(Context context) {
        super(context);
        setOnTouchListener(squareController);
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawRect(50f,50f,500f,500f,square);

    }

    //Getter method for the SquareModel
    public SquareModel getSquareModel() {
        return squareModel;
    }
}
