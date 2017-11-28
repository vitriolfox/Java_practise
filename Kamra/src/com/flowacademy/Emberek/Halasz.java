package com.flowacademy.Emberek;

import com.flowacademy.Kamra.Kamra;

public class Halasz extends Ember implements ZsakmanyoloEmber {

    private int haloMeret;
    private float szerencse;

    public Halasz(String nev, int kor, int energia, int haloMeret, float szerencse) {
        super(nev, kor, energia);
        this.haloMeret = haloMeret;
        this.szerencse = szerencse;
    }

    public int getHaloMeret() {
        return haloMeret;
    }

    public void setHaloMeret(int haloMeret) {
        this.haloMeret = haloMeret;
    }

    public double getSzerencse() {
        return szerencse;
    }

    public void setSzerencse(float szerencse) {
        this.szerencse = szerencse;
    }

    @Override
    public int zsakamanyol() {
        int result = Math.round(this.haloMeret * this.szerencse * (this.getEnergia()/100));
        Kamra.setHalak(Kamra.getHalak() + result);
        return result;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", szerencse: " + szerencse +
                ", hálóméret: " + haloMeret +
                ", HALÁSZ";
    }
}
