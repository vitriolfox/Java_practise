package com.flowacademy;

public class BoardGenerator {

    public static Integer[][] createFilledBoard(int fieldsInRows) {

        Integer[][] chessBoard = new Integer[fieldsInRows][fieldsInRows];
        int n = 1;
        for (int i = 0; i < fieldsInRows; i++) {
            for (int j = 0; j < fieldsInRows; j++) {
                chessBoard[i][j] = n;
                n++;
            }
        }
        return chessBoard;
    }


    public static Integer[][] createEmptyBoard(int fieldsInRows) {

        Integer[][] chessBoard = new Integer[fieldsInRows][fieldsInRows];
        for (int i = 0; i < fieldsInRows; i++) {
            for (int j = 0; j < fieldsInRows; j++) {
                chessBoard[i][j] = 0;
            }
        }
        return chessBoard;
    }

}
