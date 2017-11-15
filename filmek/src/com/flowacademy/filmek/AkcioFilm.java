package com.flowacademy.filmek;

public class AkcioFilm extends Film {
    protected String fohosNeve;
    protected boolean isFerfi;
    protected int halottakSzama;

    public AkcioFilm(String cim, String rendezo, int gyartasEve, String fohosNeve, boolean isFerfi, int halottakSzama) {
        super(cim, rendezo, gyartasEve);
        this.fohosNeve = fohosNeve;
        this.isFerfi = isFerfi;
        this.halottakSzama = halottakSzama;
    }

    public String getFohosNeve() {
        return fohosNeve;
    }

    public void setFohosNeve(String fohosNeve) {
        this.fohosNeve = fohosNeve;
    }

    public boolean isFerfi() {
        return isFerfi;
    }

    public void setFerfi(boolean ferfi) {
        isFerfi = ferfi;
    }

    public int getHalottakSzama() {
        return halottakSzama;
    }

    public void setHalottakSzama(int halottakSzama) {
        this.halottakSzama = halottakSzama;
    }

    @Override
    public String toString() {
        String foszereploNeme;
        if (isFerfi){
            foszereploNeme = ", a főszereplő férfi";
        } else if (!isFerfi){
            foszereploNeme = ", a főszereplő nő";
        } else {
            foszereploNeme = ", nincs megadva a főszereplő neme";
        }

        return super.toString() +
                " főhős neve: " + fohosNeve +
                foszereploNeme +
                ", halottak száma a filmben: " + halottakSzama +
                " akciófilm. ";
    }
}
