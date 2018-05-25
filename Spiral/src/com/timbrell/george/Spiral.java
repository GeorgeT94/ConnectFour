package com.timbrell.george;

import java.util.Arrays;

public class Spiral {
    int[][] spiralGrid;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_WHITE = "\u001B[37m";
    public int[][] board = new int[7][6];

    public void makeGrid(int size){
        int rows = size;
        int cols = size;
        spiralGrid = new int[rows][cols];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                spiralGrid[i][j] = 0;
            }
        }
    }

    public void fillGrid(){
        int factor = spiralGrid.length;
        int currentNum = 0;
        int iteration  = 0;
        while(currentNum < (factor * factor)){
            for (int j = 0+iteration; j < factor-iteration ; j++) {
                spiralGrid[0+iteration][j] = ++currentNum;
            }

            for (int j = 1+iteration; j < factor-iteration; j++) {
                spiralGrid[j][factor-1-iteration] = ++currentNum;
            }
            for (int j = factor-1-iteration; j > (0 + iteration)  ; j--) {
                spiralGrid[factor-1-iteration][j-1] = ++currentNum;

            }

            for (int j = factor-2-iteration; j > 0 + iteration; j--) {
                spiralGrid[j][0+iteration] = ++currentNum;
            }

            iteration++;
        }


    }

    public void printGrid(){
        for (int i = 0; i < spiralGrid.length; i++) {
            if(i%3 == 0){
                System.out.print(ANSI_RED);
            }
            if(i%3 == 1){
                System.out.print(ANSI_YELLOW);
            }
            if(i%3 == 2){
                System.out.print(ANSI_WHITE);
            }
            for (int j = 0; j < spiralGrid.length ; j++) {
                int maxLength = String.valueOf(spiralGrid.length).length();

                System.out.print(spiralGrid[i][j]);
                for (int k = 0; k < maxLength - String.valueOf(spiralGrid[i][j]).length()+2  ; k++) {
                    System.out.print(" ");
                }

                System.out.print( " ");

            }
            System.out.println();
        }
    }
}
