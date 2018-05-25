package com.timbrell.george;

public class ConnectFour {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_WHITE = "\u001B[37m";
    public int[][] board = new int[7][6];
    int boardCols = 7;
    int boardRows = 6;
    int round = 0;
    boolean stillPlaying = true;

    public void makeZeroGrid(){
        for (int i = 0; i < boardCols; i++) {
            for (int j = 0; j < boardRows; j++) {
                board[i][j] = 0;
            }
        }
    }
    private void addCounter(int column, int num){
        column -= 1;
        for(int i=boardRows-1; i >=0; i-- ){
            if(board[column][i] ==  0){
                board[column][i] = num;
                break;
            }
        }
    }

    public void printGrid(){
        for (int i = 0; i < boardCols; i++) {
            System.out.print((i+1) + " ");
        }
        System.out.println();

        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j < boardCols; j++) {
                if(board[j][i] == 1){
                    System.out.print(ANSI_RED + "\uD83D\uDE1F" + ANSI_RESET);

                }
                if(board[j][i] == 2){
                    System.out.print(ANSI_YELLOW + "\uD83D\uDE31" + ANSI_RESET);

                }
                if(board[j][i] == 0){
                    System.out.print(ANSI_WHITE + "\uD83D\uDC7D" + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    public void play(int colNum){

        if(round % 2 == 0){
            System.out.println(ANSI_YELLOW + "player \uD83D\uDE31 turn" + ANSI_RESET);


            addCounter(colNum, 1);
        }
        if(round % 2 == 1){
            System.out.println(ANSI_RED + "player \uD83D\uDE1F turn" + ANSI_RESET);

            addCounter(colNum, 2);
        }
        printGrid();
        winCondition();
        if(!stillPlaying){
            System.out.println("player " + (round % 2 +1) + " won in " + (round+1) + " rounds");

            System.exit(0);
        }
        round++;
    }

    public void winCondition(){
        checkHorizontal();
        checkVertical();
        checkDiagonal();
    }

    private void checkHorizontal(){
        int counter = 0;
        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j < boardCols-1 ; j++) {

                if(board[j][i] != 0 && board[j][i] == board[j+1][i]){
                    counter++;
                    if(counter == 3){
                        stillPlaying = false;
                        break;
                    }
                }else{
                    counter = 0;
                }
            }
        }
    }

    private void checkVertical(){
        int counter = 0;
        for (int i = 0; i < boardCols; i++) {
            for (int j = 0; j < boardRows-1 ; j++) {

                if(board[i][j] != 0 && board[i][j] == board[i][j+1]){
                    counter++;
                    if(counter == 3){
                        stillPlaying =false;
                        break;
                    }
                }else{
                    counter = 0;
                }
            }
        }
    }

    private void checkDiagonal(){
        for (int i = 0; i <  boardCols ; i++) {
            for (int j = 0; j < boardRows; j++) {
                try {
                    if (board[i][j] != 0 && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && board[i][j] == board[i - 1][j - 1]) {
                        stillPlaying = false;
                        break;
                    }
                    if (board[i][j] != 0 && board[i][j] == board[i + 1][j -1] && board[i][j] == board[i + 2][j -2] && board[i][j] == board[i - 1][j +1] ){
                        stillPlaying = false;
                        break;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        }
    }


}
