package com.flowacademy.szovegkezel;

import java.util.StringTokenizer;

public class SzovegKezel {
    public static void main(String[] args) {
        String text = "egy kettő három négy öt hat hét nyolc kilenc tíz";

        String[] szamok = text.split(" ");

        for(String szam: szamok) {
            System.out.println(szam);
        }

        System.out.println("===============================================");

        StringTokenizer tokanizer = new StringTokenizer(text, " ");
         while (tokanizer.hasMoreElements()){
             System.out.println(tokanizer.nextToken());
         }

        System.out.println("===============================================");

    }
}
