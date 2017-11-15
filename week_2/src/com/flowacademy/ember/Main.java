package com.flowacademy.ember;

import com.flowacademy.ember.Ember;
import com.flowacademy.ember.Kocsmaros;
import com.flowacademy.ember.Ital;

public class Main {
    public static void main(String[] args) {
        Ember jozsi = new Ember("Józsi", 63, true,30);
        Ember karoly = new Ember( "Karcsika",102,true,100);
        Ember petya = new Ember("Petyus",41,true,60);

        Kocsmaros geza = new Kocsmaros(100);
        Kocsmaros erzsi = new Kocsmaros(50);

        Ital koccintos = new Ital(5,10);
        Ital kommersz = new Ital(5, 30);


        Ember[] emberek = {jozsi, karoly, petya};

        for (int i = 0; i < emberek.length; i++){
            emberek[i].kiir();
        }
        float korSum = 0;
        for (int i = 0; i < emberek.length; i++){
            korSum += emberek[i].getKor();
        }
        System.out.println("Az átlagéletkor: " + korSum/emberek.length);

        jozsi.jon();
        jozsi.iszik(geza, kommersz);
        petya.jon();
        petya.iszik(geza, kommersz);
        jozsi.iszik(geza, kommersz);
        jozsi.iszik(geza, koccintos);
        petya.iszik(geza, koccintos);
        karoly.jon();
        karoly.iszik(geza, kommersz);
        petya.iszik(geza, kommersz);
        jozsi.iszik(geza, kommersz);
        karoly.iszik(geza, koccintos);

        System.out.println("Emberek száma: " + Ember.getEMBEREKSZAMA());


    }
}
