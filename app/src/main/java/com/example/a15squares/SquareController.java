package com.example.a15squares;

import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class SquareController implements View.OnTouchListener, View.OnDragListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    //Instance Vars
    private float x,y;
    private Squares square;
    private SquareModel squareModel;

    public SquareController(SquareModel model, Squares squares) {
        //Setters
        square = squares;
        squareModel = squares.getSquareModel();

        squareModel.reset(squareModel.amt);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        this.x = event.getX();
        this.y = event.getY();

        square.invalidate();
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.x = event.getX();
        this.y = event.getY();

        square.invalidate();
        return false;
    }

    @Override
    public void onClick(View v) {
        squareModel.reset(squareModel.amt);
        square.invalidate();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        squareModel.reset(progress);
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
