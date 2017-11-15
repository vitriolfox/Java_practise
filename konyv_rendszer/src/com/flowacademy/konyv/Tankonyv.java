package com.flowacademy.konyv;

public class Tankonyv extends Konyv {

    protected String tantargy;

    public Tankonyv() {
        this.tantargy = "Programozás 1";
    }

    public Tankonyv(String cim, String szerzo, String kiado, int datum) {
        super(cim, szerzo, kiado, datum);
        this.tantargy = "Programozás 1";
    }

    public Tankonyv(String cim, String szerzo, String kiado, int datum, String tantargy) {
        super(cim, szerzo, kiado, datum);
        this.tantargy = tantargy;
    }

    public String getTantargy() {
        return tantargy;
    }

    public void setTantargy(String tantargy) {
        this.tantargy = tantargy;
    }

    @Override
    public String toString() {
        return   super.toString() +
                "tantargy='" + tantargy;
    }
}
