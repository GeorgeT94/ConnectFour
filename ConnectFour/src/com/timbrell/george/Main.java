package com.timbrell.george;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConnectFour game = new ConnectFour();
        game.makeZeroGrid();

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("enter column number: ");

            int column = scanner.nextInt();
            game.play(column);
        }

    }
}
