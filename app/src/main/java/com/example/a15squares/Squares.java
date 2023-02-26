package com.example.a15squares;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

//Partly taken from FlappyBird
public class Squares extends SurfaceView {
    //Sets our paints for squares
    private Button[][] buttons;

    //Instance Vars
    private SquareModel squareModel;

    //Constructor
    public Squares(Context context, AttributeSet attrs) {
        super(context, attrs);
        squareModel = new SquareModel();
        buttons = new Button[4][4];

        SurfaceHolder holder = getHolder();
        holder.getSurfaceFrame();

        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);

    }

    public void surfaceCreated (SurfaceHolder holder) {
        holder.getSurfaceFrame();

    }

    public void addButton(int row, int col, Button b)
    {
        buttons[row][col] = b;
    }

    public void enableButton()
    {
        buttons[squareModel.row()][squareModel.col()].setVisibility(View.VISIBLE);
        buttons[squareModel.row()][squareModel.col()].setClickable(true);
//        String s = Integer.toString(squareModel.score());
//        buttons[squareModel.row()][squareModel.col()].setText(s);
    }
    public void disableButton()
    {
        buttons[squareModel.row()][squareModel.col()].setVisibility(View.INVISIBLE);
        buttons[squareModel.row()][squareModel.col()].setClickable(false);
    }

    public void setListener(View.OnClickListener ocl)
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                buttons[i][j].setOnClickListener(ocl);
            }
        }
    }

    //Getter method for the SquareModel
    public SquareModel getSquareModel() {
        return squareModel;
    }
}
