package com.flowacademy.machine;

import java.io.Serializable;

public class Machinery implements Serializable {
    protected int weight;
    protected String type;

    public Machinery(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return  ", weight: " + weight +
                ", type: " + type;
    }
}
