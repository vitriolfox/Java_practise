package com.flowacademy.torta;

public class Torta {
    protected int szelet;
    protected String iz;

    public Torta(int szelet, String iz) {
        this.szelet = szelet;
        this.iz = iz;
    }

    public String getIz() {
        return iz;
    }

    public void setIz(String iz) {
        this.iz = iz;
    }

    public void info() {
        System.out.println("Ez a torta " + this.iz + " íz, és " + this.szelet + " szeletes.");
    }
}
