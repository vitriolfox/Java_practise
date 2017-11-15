package com.flowacademy.november_3;
import java.util.Scanner;
import java.util.Random;

public class Szokitalalo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] szavak = {"rája", "elefánt", "vipera"};
        Random rand = new Random();

        char[] egySzo = szavak[rand.nextInt(szavak.length)].toCharArray();
        char[] kijelzett = new char[egySzo.length];
        int korok = 1;
        int match = 0;

        System.out.println("Gondoltam egy " + egySzo.length + " betűs állatnevet. Van " + egySzo.length + " köröd, hogy kitaláld!");
        System.out.println();
        System.out.println(korok + ". kör:");
        System.out.print("Tippeld meg az állatnevet amire gondoltam: ");
        char[] tipp = scanner.next().toCharArray();



        for (int i = 0; i < egySzo.length ; i++){
            System.out.println(korok + ". kör:");
            korok ++;
            for (int j = 0; j < egySzo.length; j++){
                if (tipp[j] == egySzo[j]){
                    kijelzett[j] = egySzo[j];
                } else {
                    kijelzett[j] = '.';
                }
            }

            for (int j = 0; j < egySzo.length; j++){
                if (tipp[j] == egySzo[j]){
                    match ++;
                }
            }

            if (match == egySzo.length){
                System.out.println("NYERTÉL!");
                break;
            } else if (korok == egySzo.length){
                System.out.println("KIFUTOTTÁL AZ IDŐBŐL!");
                break;
            } else {
                System.out.println(kijelzett);
                System.out.print("Új tipp: ");
                tipp = scanner.next().toCharArray();
            }
        }
    }
}