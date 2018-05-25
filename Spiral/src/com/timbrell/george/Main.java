package com.timbrell.george;

public class Main {

    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        spiral.makeGrid(10000);
        spiral.fillGrid();
        spiral.printGrid();
    }
}
