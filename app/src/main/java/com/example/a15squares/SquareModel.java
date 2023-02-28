package com.example.a15squares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Parts taken from FlappyBird
public class SquareModel {
    public int amt = 1;
    private Random rng;

    public int[][] squares;
    private int row;
    private int col;


    public SquareModel() {
        rng = new Random();
        reset(amt);

        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            values.add(i);
        }
        Collections.shuffle(values);

        int index = 0;
        for (int i = 0; i < 4*amt; i++) {
            for (int z = 0; z < 4*amt; z++) {
                if (index < values.size()) {
                    squares[i][z] = values.get(index);
                    index++;
                } else {
                    squares[i][z] = 0;
                    row = i;
                    col = z;
                }
            }
        }
    }

    public int[][] getSquares() {
        return squares;
    }

    private void resetSquares() {
        for (int i = 0; i < 4*amt; i++) {
            for (int z = 0; z < 4*amt; z++) {
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
