package com.example.a15squares;

import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

import java.util.logging.Handler;

public class SquareController implements View.OnTouchListener, View.OnDragListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    //Instance Vars
    private float x,y;
    private Squares square;
    private SquareModel squareModel;

    public SquareController(SquareModel model, Squares squares) {
        //Setters
        square = squares;
        squareModel = squares.getSquareModel();
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
            square.invalidate();
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        square.invalidate();
        return false;
    }

    @Override
    public void onClick(View v) {
        squareModel.reset();
        square.invalidate();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        squareModel.amt = progress;
        square.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        square.invalidate();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        square.invalidate();
    }
}
