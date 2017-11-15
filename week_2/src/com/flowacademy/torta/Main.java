package com.flowacademy.torta;

public class Main {
    public static void main(String[] args) {
        Torta csokiTorta = new Torta(10, "csoki");
        SzulinapiTorta kaveTorta = new SzulinapiTorta(10, "kávé", 5);

        Torta[] tortakTarolasaraAlkalmasTomb = new Torta[2];
        tortakTarolasaraAlkalmasTomb[0] = csokiTorta;
        tortakTarolasaraAlkalmasTomb[1] = kaveTorta;

        for (int i = 0; i < tortakTarolasaraAlkalmasTomb.length; i++)
            tortakTarolasaraAlkalmasTomb[i].info();
    }
}
