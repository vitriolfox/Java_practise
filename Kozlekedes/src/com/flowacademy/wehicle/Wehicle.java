package com.flowacademy.wehicle;

import com.flowacademy.exceptions.IsBrokenException;

import java.io.Serializable;
import java.util.Objects;

public abstract class Wehicle implements Serializable{
    protected int weight;
    protected int maxSpeed;
    protected boolean broken;

    public Wehicle() {
    }

    public Wehicle(int weight, int maxSpeed) {
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.broken = false;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }


    public abstract void startEngine() throws IsBrokenException;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wehicle wehicle = (Wehicle) o;

        if (weight != wehicle.weight) return false;
        return maxSpeed == wehicle.maxSpeed;
    }

    @Override
    public int hashCode() {
        int result = weight;
        result = 31 * result + maxSpeed;
        return result;
    }

    @Override
    public String toString() {
        return "A jármű súlya: " + weight +
                ", max. sebessége: " + maxSpeed +
                ", el van romolva?: " + broken;
    }
}
