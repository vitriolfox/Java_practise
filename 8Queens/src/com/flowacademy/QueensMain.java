package com.flowacademy;

import static com.flowacademy.BoardGenerator.createFilledBoard;



public class QueensMain {

    public static void displayBoard (Integer[][] chessBoard) {
        int counter = 0;

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == 1) {
                    System.out.printf("|%s|", "x");
                    counter++;
                } else {
                    System.out.printf("|%s|", "o");
                }
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int fieldsNumber = 10;
        int firstQueen = 4;


        //displayBoard(QueensPlacing.placingQueens(QueensAlgoritm.coordinateArray(fieldsNumber), BoardGenerator.createEmptyBoard(fieldsNumber)));

        displayBoard(QueensPlacing.placingQueens(QueensAlgoritm.QueensWIPSolution(fieldsNumber, firstQueen), BoardGenerator.createEmptyBoard(fieldsNumber)));

    }
}
