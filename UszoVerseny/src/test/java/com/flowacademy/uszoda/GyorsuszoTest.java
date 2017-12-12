package com.flowacademy.uszoda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GyorsuszoTest {

    String nev = "Test";
    int teljesitmeny = 15;
    String nemzetiseg = "magyar";
    int versenytav = 200;

    Gyorsuszo gyorsuszo = new Gyorsuszo(nev,teljesitmeny,nemzetiseg);

    double random = gyorsuszo.getRandom();

    @Test
    void versenyez() {

        assertEquals(((((this.teljesitmeny *1.3)*random)*versenytav/10)+((versenytav/50)*2))+1.5,
                gyorsuszo.versenyez(versenytav), "HIBA a verseny metódusban!");

        versenytav = 201;

        assertEquals(0, gyorsuszo.versenyez(versenytav),"HIBA a verseny metódusban!");
    }

}