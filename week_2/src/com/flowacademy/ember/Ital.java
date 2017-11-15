package com.flowacademy.ember;

public class Ital {
    private int alkoholtartalom;
    private int ar;

    public Ital(int alkoholtartalom, int ar) {
        this.alkoholtartalom = alkoholtartalom;
        this.ar = ar;
    }

    public int getAlkoholtartalom() {
        return alkoholtartalom;
    }

    public int getAr() {
        return ar;
    }

    @Override
    public String toString() {
        return "Ital{" +
                "alkoholtartalom=" + alkoholtartalom +
                ", ar=" + ar +
                '}';
    }
}
