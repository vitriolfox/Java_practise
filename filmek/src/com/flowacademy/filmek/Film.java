package com.flowacademy.filmek;

import java.util.Random;

public class Film {
    protected String cim;
    protected String rendezo;
    protected int gyartasEve;

    public Film(String cim, String rendezo, int gyartasEve) {
        this.cim = cim;
        this.rendezo = rendezo;
        this.gyartasEve = gyartasEve;
    }

    public boolean jelolesOscarDijra(int jelolesEve){
        Random random01Kozott = new Random();

        if (jelolesEve < 1929 || jelolesEve > 2017 || random01Kozott.nextInt() == 0){
            return false;

        } else if (random01Kozott.nextInt() == 1){
            return true;

        } else {
            return false;
        }
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getRendezo() {
        return rendezo;
    }

    public void setRendezo(String rendezo) {
        this.rendezo = rendezo;
    }

    public int getGyartasEve() {
        return gyartasEve;
    }

    public void setGyartasEve(int gyartasEve) {
        this.gyartasEve = gyartasEve;
    }

    @Override
    public String toString() {
        return  "Cím: " + cim +
                ", rendező: " + rendezo +
                ", gyártás éve: " + gyartasEve;
    }
}
