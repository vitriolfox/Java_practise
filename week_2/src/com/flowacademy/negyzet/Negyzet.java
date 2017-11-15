package com.flowacademy.negyzet;

public class Negyzet {
    private float a;
    private float b;

    public Negyzet(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float Kerulet(){
        return 2*(a + b);
    }

    public float Terulet(){
        return a * b;
    }


}