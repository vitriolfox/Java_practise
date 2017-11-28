package com.flowacademy.Emberek;

import com.flowacademy.Kamra.HalHusEnum;
import com.flowacademy.Kamra.Kamra;
import com.flowacademy.Exceptions.TeleVanException;

import java.io.Serializable;
import java.util.Random;

public class Ember implements Serializable {

    private String nev;
    private int kor;
    private int energia;


    public Ember(String nev, int kor, int energia) {
        this.nev = nev;
        this.kor = kor;
        this.energia = energia;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ember ember = (Ember) o;

        if (kor != ember.kor) return false;
        if (energia != ember.energia) return false;
        return nev != null ? nev.equals(ember.nev) : ember.nev == null;
    }

    @Override
    public int hashCode() {
        int result = nev != null ? nev.hashCode() : 0;
        result = 31 * result + kor;
        result = 31 * result + energia;
        return result;
    }


    public void eszik(HalHusEnum halVagyHus) throws TeleVanException {
        int random = new Random().nextInt(10);
        if (this.energia < 100) {
            if (halVagyHus.equals(halVagyHus.HAL)) {
                Kamra.setHalak(Kamra.getHalak() - random);
                this.energia = -random;
            } else {
                Kamra.setHusok(Kamra.getHusok() - random);
                this.energia = -random;
            }
        } else {
            this.energia = 100;
            throw new TeleVanException(this.nev + " tele van, nem tud többet enni!");
        }

    }

    @Override
    public String toString() {
        return  "nev: " + nev + '\'' +
                ", kor: " + kor +
                ", energia: " + energia;
    }
}
