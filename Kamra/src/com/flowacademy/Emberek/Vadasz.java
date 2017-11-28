package com.flowacademy.Emberek;

import com.flowacademy.Kamra.Kamra;

import java.util.Random;

public class Vadasz extends Ember implements ZsakmanyoloEmber {

    private float szerencse;

    public Vadasz(String nev, int kor, int energia, float szerencse) {
        super(nev, kor, energia);
        this.szerencse = szerencse;
    }

    public double getSzerencse() {
        return szerencse;
    }

    public void setSzerencse(float szerencse) {
        this.szerencse = szerencse;
    }

    @Override
    public int zsakamanyol() {
        int vadMerete = new Random().nextInt(20);
        int result = Math.round(vadMerete * this.szerencse * (this.getEnergia()/100));
        Kamra.setHusok(Kamra.getHusok() + result);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", szerencse: " + szerencse +
                ", VADÁSZ";

    }
}
