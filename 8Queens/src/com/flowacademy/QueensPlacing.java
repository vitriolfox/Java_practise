package com.flowacademy;

public class QueensPlacing {

    public static Integer[][] placingQueens(Integer[] sourceArray, Integer[][] emptyMatrix) {

        for (int i = 0; i < sourceArray.length; i++){
            emptyMatrix[i][sourceArray[i]-1]=1;
        }

        return emptyMatrix;

    }

}
