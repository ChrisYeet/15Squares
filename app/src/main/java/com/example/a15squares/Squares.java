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
    private Paint textsquare = new Paint();
    private int squareSize = 250;

    //Constructor
    public Squares(Context context, AttributeSet attrs) {
        super(context, attrs);
        squareModel = new SquareModel();
        squareController = new SquareController(squareModel, this);

        setOnTouchListener(squareController);

        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        square.setColor(Color.BLACK);
        square.setStyle(Paint.Style.STROKE);
        square.setStrokeWidth(5);
        textsquare.setColor(Color.BLACK);
        textsquare.setTextSize(50);
        textsquare.setTextAlign(Paint.Align.CENTER);
    }

    public Squares(Context context) {
        super(context, null);
    }

    @Override
    public void onDraw(Canvas c) {
        for (int i = 0; i < 4 * squareModel.amt; i++) {
            for (int j = 0; j < 4 * squareModel.amt; j++) {
                int squareNumber = squareModel.squares[i][j];

                if (squareNumber != 0) {
                    float left = j * (float)squareSize;
                    float top = i * (float)squareSize;
                    float right = left + squareSize;
                    float bottom = top + squareSize;
                    c.drawRect(left, top, right, bottom, square);

                    String text = String.valueOf(squareNumber);
                    float textWidth = square.measureText(text);
                    float textHeight = square.ascent() + square.descent();
                    float textX = left + (squareSize - textWidth) / 2;
                    float textY = top + (squareSize - textHeight) / 2;
                    c.drawText(text, textX, textY, textsquare);
                }
            }
        }
    }

    //Getter method for the SquareModel
    public SquareModel getSquareModel() {
        return squareModel;
    }
}