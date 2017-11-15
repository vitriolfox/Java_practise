package com.flowacademy.november_3;
import java.util.Scanner;
//4. Készítsen egy olyan programot, amely az a,b,c számhármasról eldönti, hogy lehetnek-e egy háromszög oldalai!

public class HaromszogOldalai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérlek add meg az első számot: ");
        int aOldal = scanner.nextInt();

        System.out.print("Kérlek add meg a második számot: ");
        int bOldal = scanner.nextInt();

        System.out.print("Kérlek add meg a harmadik számot: ");
        int cOldal = scanner.nextInt();

        if ((aOldal + bOldal) > cOldal && (aOldal + cOldal) > bOldal && (bOldal + cOldal) > aOldal){
            System.out.println("Ezek egy háromszőg oldalai is lehetnek.");
        } else {
            System.out.println("Ezek nem lehetnek egy háromszög oldalai.3");
        }
    }
}
