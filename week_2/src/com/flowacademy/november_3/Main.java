package com.flowacademy.november_3;
import java.util.Scanner;
//1. Készíts programot, ami egy számformátumban megadott érdemjegyet szövegesen jelenít meg!
// Az érdemjegyet a billentyűzeten kell bevinni! (pl. 1 = elégtelen; 2 = elégséges; stb.)

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérlek add meg az érdemjegyet: ");

        String scannerNumber = scanner.next();

        switch (scannerNumber) {
            case "1":
                System.out.println("Ez egy elégtelen osztályzat.");
                break;
            case "2":
                System.out.println("Ez egy elégséges osztályzat.");
                break;
            case "3":
                System.out.println("Ez egy közepes osztályzat.");
                break;
            case "4":
                System.out.println("Ez egy jó osztályzat.");
                break;
            case "5":
                System.out.println("Ez egy jeles osztályzat.");
                break;
            default:
                System.out.println("Kérlek érvényes érdemjegyet adj meg, 1 és 5 között.");
                break;
        }

    }
}
