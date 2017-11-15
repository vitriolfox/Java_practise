package com.flowacademy.automata;

public class UresAutomata {
    protected int bedobottPenz;
    protected int poharakSzama;
    protected boolean isHasznalhato;

    public UresAutomata(int bedobottPenz, int poharakSzama, boolean isHasznalhato) {
        this.bedobottPenz = bedobottPenz;
        this.poharakSzama = poharakSzama;
        this.isHasznalhato = isHasznalhato;
    }

    public int getBedobottPenz() {
        return bedobottPenz;
    }

    public void setBedobottPenz(int bedobottPenz) {
        this.bedobottPenz = bedobottPenz;
    }

    public int getPoharakSzama() {
        return poharakSzama;
    }

    public void setPoharakSzama(int poharakSzama) {
        this.poharakSzama = poharakSzama;
    }

    public boolean isHasznalhato() {
        return isHasznalhato;
    }

    public void setHasznalhato(boolean hasznalhato) {
        isHasznalhato = hasznalhato;
    }

    public void penztBedob(int penz){
        System.out.println("Ez az automata nincs feltöltve, nem használható");
    }

    @Override
    public String toString() {
        String hasznalhato;
        if (isHasznalhato){
            hasznalhato = "használható";
        } else {
            hasznalhato = "nem használható";
        }
        return "Automata :" +
                hasznalhato +
                ", bedobott pénzösszeg: " +
                bedobottPenz + ", ";
    }
}
