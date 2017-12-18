package com.flowacademy;

public class QueensAlgoritm {

    public static Integer[] coordinateArray(int rowNumber){
        Integer[] coordinateArray = new Integer[rowNumber];

        int modulus = rowNumber % 12;
        int normalNumber = 2;
        for (int i=0; i < coordinateArray.length; i++){

            if (normalNumber%2 == 0){
                coordinateArray[i] = normalNumber;
            }
            normalNumber +=2;
        }

        if (modulus == 3 || modulus == 9){                                   //if modulus is 3 or 9
            for (int i=0; i < coordinateArray.length-1; i++){
                 coordinateArray[i] = coordinateArray[i+1];
                 coordinateArray[(rowNumber/2)-1] = 2;
                }
            for (int i=rowNumber/2; i < coordinateArray.length; i++){
                int oddNumber = 5;
                if (oddNumber%2 != 0){
                    coordinateArray[i] = oddNumber;
                }
                oddNumber +=2;
            }
            coordinateArray[rowNumber-2] = 1;
            coordinateArray[rowNumber-1] = 3;

        } else if (modulus == rowNumber){                                   //if modulus is n
            for (int i=rowNumber/2; i < coordinateArray.length; i++){
                int oddNumber = 5;
                if (oddNumber%2 != 0){
                    coordinateArray[i] = oddNumber;
                }
                oddNumber +=2;
            }

            coordinateArray[rowNumber/2] = 3;
            coordinateArray[(rowNumber/2)+1] = 1;
            coordinateArray[(rowNumber/2)+2] = 7;
            coordinateArray[(rowNumber/2)+3] = 5;

        } else if (modulus == 2 || modulus == 4){                           //if modulus is 2 or 4
            for (int i=rowNumber/2; i < coordinateArray.length; i++){
                int oddNumber = 5;
                if (oddNumber%2 != 0){
                    coordinateArray[i] = oddNumber;
                }
                oddNumber +=2;
            }

            coordinateArray[rowNumber/2] = 3;
            coordinateArray[(rowNumber/2)+1] = 1;
            coordinateArray[(rowNumber/2)+2] = 7;
            coordinateArray[rowNumber-1] = 5;

        }
        return coordinateArray;
    }

    public static Integer[] QueensWIPSolution(int n, int m){
        Integer[] WIPArray = new Integer[n];
        for (int i = 0; i < WIPArray.length; i++){
             WIPArray[i] = m;
             m +=2;
        }
        for (int i=0; i<WIPArray.length; i++){
            if (WIPArray[i]>n){
                int x = 1;
                for (int j=0; j<i; j++){
                    while (j+WIPArray[j]==x+i || WIPArray[j]-j==x-i||WIPArray[j]==x){
                        x++;
                    }
                    WIPArray[i] = x;
                }
            }
        }


        return WIPArray;
    }

}
