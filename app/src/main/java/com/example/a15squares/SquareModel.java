package com.example.a15squares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Parts taken from FlappyBird
public class SquareModel {
    //Instance Vars
    public int amt = 1;
    private Random rng;
    public int[][] squares;
    private int row;
    private int col;

    //Constructor
    public SquareModel() {
        rng = new Random();
        reset(amt);
    }

    //Getter Method
    public int[][] getSquares() {
        return squares;
    }

    //Reset's the Squares
    private void resetSquares() {
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

    //Calls resetSquares, the main reseter
    public void reset(int progress) {
        amt = progress;
        squares = new int[4*amt][4*amt];
        resetSquares();
    }

    //Checks moves
    public void move(int r, int c) {
        if (r == row && c == col) {
            return;
        }
        if (r == row) {
            int direction = (c > col) ? 1 : -1;
            for (int i = col + direction; i != c + direction; i += direction) {
                int temp = squares[r][i];
                squares[r][i] = 0;
                squares[r][i - direction] = temp;
            }
            col = c;
        } else if (c == col) {
            int direction = (r > row) ? 1 : -1;
            for (int i = row + direction; i != r + direction; i += direction) {
                int temp = squares[i][c];
                squares[i][c] = 0;
                squares[i - direction][c] = temp;
            }
            row = r;
        }
    }

    //Checks if it has been solved
    public boolean isSolved() {
        int value = 1;
        for (int i = 0; i < 4*amt; i++) {
            for (int j = 0; j < 4*amt; j++) {
                if (squares[i][j] != value && (i != 3*amt || j != 3*amt)) {
                    return false;
                }
                value++;
            }
        }
        return true;
    }
}