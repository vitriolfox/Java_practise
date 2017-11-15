package com.flowacademy.november_3;

import java.util.Scanner;

public class Anagramma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérlek add meg az első szavat: ");

        String firstWord = scanner.next();
        char[] firstWordArray = firstWord.toCharArray();

        System.out.print("Kérlek add meg a második szavat: ");

        String secondWord = scanner.next();
        char[] secondWordArray = secondWord.toCharArray();

        char[] abc = {
                'a', 'á', 'b', 'c', 'd', 'e', 'é', 'f', 'g', 'h', 'i', 'í', 'j', 'k', 'l', 'm', 'n', 'o', 'ó', 'ö',
                'ő', 'p', 'q', 'r', 's', 't', 'u', 'ú', 'ü', 'ű', 'v', 'w', 'x', 'y', 'z', 'A', 'Á', 'B', 'C', 'D',
                'E', 'É', 'F', 'G', 'H', 'I', 'Í', 'J', 'K', 'L', 'M', 'N', 'O', 'Ó', 'Ö', 'Ő', 'P', 'Q', 'R', 'S',
                'T', 'U', 'Ú', 'Ü', 'Ű', 'V', 'W', 'X', 'Y', 'Z'
        };

        int[] firstWordFingerprint = new int[70];
        int[] secondWordFingerprint = new int[70];

        for (int i = 0; i < firstWordArray.length; i++){
            for (int j = 0; j < abc.length; j++){
                if (abc[j] == firstWordArray[i]){
                    firstWordFingerprint[j] += 1;
                }
            }
        }

        for (int i = 0; i < secondWordArray.length; i++) {
            for (int j = 0; j < abc.length; j++) {
                if (abc[j] == secondWordArray[i]) {
                    secondWordFingerprint[j] += 1;
                }
            }
        }

        int eredmeny = 0;

        for (int i = 0; i < firstWordFingerprint.length; i++) {
                if (firstWordFingerprint[i] == secondWordFingerprint[i]) {
                    eredmeny++;
            }
        }

        if (eredmeny == firstWordFingerprint.length){
            System.out.println("Ez egy anagramma!");
        } else{
            System.out.println("Ez NEM anagramma!");
        }
    }
}
