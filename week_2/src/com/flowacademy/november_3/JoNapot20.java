package com.flowacademy.november_3;

//2. Készíts programot, amely egymás alá hússzor kiírja a "Jó napot kívánok!" szöveget!

public class JoNapot20 {
    public static void main(String[] args) {
        int ennyiJonapot = 20;

        for (int i = 0; i < ennyiJonapot; i++) {
            System.out.println("Jó napot kívánok! " + (i+1));
        }
    }
}
