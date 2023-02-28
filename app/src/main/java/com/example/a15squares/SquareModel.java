package com.example.a15squares;

import java.util.Random;

//Parts taken from FlappyBird
public class SquareModel {
    public int amt = 1;
    private Random rng;

    private int[][] squares;
    private int row;
    private int col;


    public SquareModel() {
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

    public void reset(int progress) {
        amt = progress;
        squares = new int[4*amt][4*amt];
        resetSquares();
    }

    public void changeSquare() {
        row = rng.nextInt(4);
        col = rng.nextInt(4);
    }

    public int getRow()
    {
        return row;
    }

    public int getCol() {
        return col;
    }

}
