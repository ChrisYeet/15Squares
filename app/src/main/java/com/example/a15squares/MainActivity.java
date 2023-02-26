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
        Squares squares = findViewById(R.id.squarelayout);
        SquareController squareController = new SquareController(model, squares);

        //Taken from FlappyBird
        squares.addButton(0,0, findViewById(R.id.b_11));
        squares.addButton(0,1, findViewById(R.id.b_12));
        squares.addButton(0,2, findViewById(R.id.b_13));
        squares.addButton(0,3, findViewById(R.id.b_14));
        squares.addButton(1,0, findViewById(R.id.b_21));
        squares.addButton(1,1, findViewById(R.id.b_22));
        squares.addButton(1,2, findViewById(R.id.b_23));
        squares.addButton(1,3, findViewById(R.id.b_24));
        squares.addButton(2,0, findViewById(R.id.b_31));
        squares.addButton(2,1, findViewById(R.id.b_32));
        squares.addButton(2,2, findViewById(R.id.b_33));
        squares.addButton(2,3, findViewById(R.id.b_34));
        squares.addButton(3,0, findViewById(R.id.b_41));
        squares.addButton(3,1, findViewById(R.id.b_42));
        squares.addButton(3,2, findViewById(R.id.b_43));
        squares.addButton(3,3, findViewById(R.id.b_44));
//
//        SquareModel.changeSquare();
        //view.enableButton();

//        SquareController controller = new SquareController(model, view);
//        view.setListener(controller);

        squares.setOnTouchListener(squareController);
        squares.setOnDragListener(squareController);

        Button reset = findViewById(R.id.Reset);
        reset.setOnClickListener(squareController);

        SeekBar amt = findViewById(R.id.SquareAmt);
        amt.setOnClickListener(squareController);
    }
}