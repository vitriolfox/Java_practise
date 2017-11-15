package com.flowacademy.filereader;

public class Reader {
    public static void main(String[] args) {
        String[] szamok = {"1","2","3"};
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(szamok[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Túlszaladtunk");
            e.printStackTrace();
        }
        osztas(6, 0);

    }

    public static void osztas (int a, int b){
        try {
            System.out.println(a/b);
        } catch (ArithmeticException e){
            System.out.println("Nemjou!");
            e.printStackTrace();
        }
    }
}
