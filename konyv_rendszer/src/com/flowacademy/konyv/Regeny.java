package com.flowacademy.konyv;

public class Regeny extends Konyv {
    String tipus;
    private static int regenyekSzama = 0;

    public Regeny() {
        this.tipus = "ifjusági";
        regenyekSzama++;
    }

    public Regeny(String cim, String szerzo, String kiado, int datum, String tipus) {
        super(cim, szerzo, kiado, datum);
        this.tipus = tipus;
        regenyekSzama++;
    }

    public Regeny(String cim, String szerzo, String kiado, int datum) {
        super(cim, szerzo, kiado, datum);
        this.tipus = "ifjusági";
        regenyekSzama++;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", típus: " + tipus;
    }
}
