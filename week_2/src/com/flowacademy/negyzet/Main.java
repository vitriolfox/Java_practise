package com.flowacademy.negyzet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Negyzet elsoNegyzet = new Negyzet(5,8);
        Negyzet masodikNegyzet = new Negyzet(8,9);
        Negyzet harmadikNegyzet = new Negyzet(4,6);
        Negyzet negyedikNegyzet = new Negyzet(1,9);
        Negyzet otodikNegyzet = new Negyzet(3,7);

        Random random = new Random();

        Negyzet[] negyzetek = {elsoNegyzet, masodikNegyzet, harmadikNegyzet, negyedikNegyzet, otodikNegyzet};

        Negyzet[] negyzetek2 = new Negyzet[4];
        for (int i = 0; i < 4; i++){
            negyzetek2[i] = new Negyzet(random.nextFloat(), random.nextFloat());
        }

        float sumKerulet = 0;
        float sumTerulet = 0;

        for (int i = 0; i < negyzetek.length; i++){
            sumKerulet += negyzetek[i].Kerulet();
            sumTerulet += negyzetek[i].Terulet();
        }
        System.out.println("Átlag kerület: " + sumKerulet/negyzetek.length);
        System.out.println("Átlag terület: " + sumTerulet/negyzetek.length);

    }
}
