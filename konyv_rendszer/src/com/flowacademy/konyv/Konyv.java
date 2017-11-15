package com.flowacademy.konyv;

public class Konyv {
    protected String cim;
    protected String szerzo;
    protected String kiado;
    protected int datum;

    public Konyv(String cim, String szerzo, String kiado, int datum) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.kiado = kiado;
        this.datum = datum;
    }

    public Konyv() {
        this.cim = "Objektumorientált Tervezés és Programozás";
        this.szerzo = "Angster Erzsébet";
        this.kiado = "Kiskapu";
        this.datum = 2001;
    }


    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public String getKiado() {
        return kiado;
    }

    public void setKiado(String kiado) {
        this.kiado = kiado;
    }

    public int getDatum() {
        return datum;
    }

    public void setDatum(int datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return  "Cím: " + cim +
                ", szerző: " + szerzo +
                ", kiadó: " + kiado +
                ", dátum: " + datum;
    }
}
