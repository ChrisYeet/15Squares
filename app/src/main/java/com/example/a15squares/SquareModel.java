package com.example.a15squares;

import android.content.Context;

import java.util.Random;

//Partly taken from FlappyBird
public class SquareModel {
    public int amt = 1;
    public boolean check = false;
    private Random rng;

    private int[][] squares;
    private int row;
    private int col;


    public SquareModel()
    {
        rng = new Random();
        squares = new int[4][4];
        resetSquares();
    }

    private void resetSquares() {
        for (int i = 0; i < 4; i++) {
            for (int z = 0; z < 4; z++) {
                squares[i][z] = rng.nextInt(10) + 1;
            }
        }
        row = rng.nextInt(4);
        col = rng.nextInt(4);
    }

    public void reset()
    {
        amt = 1;
    }

    public void changeSquare() {
        row = rng.nextInt(4);
        col = rng.nextInt(4);
    }

    public boolean clickSquare(int row, int col) {
        if (row == this.row && col == this.col) {
            resetSquares();
            return true;
        } else {
            return false;
        }
    }

    public int row()
    {
        return row;
    }

    public int col() {
        return col;
    }

}
