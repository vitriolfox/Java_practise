package com.flowacademy.wehicle;

import com.flowacademy.exceptions.IsBrokenException;

import java.io.Serializable;

public class Bicycle extends Wehicle implements Serializable{

    public Bicycle(int weight) {
        this.weight = weight;
        this.maxSpeed = 40;
    }

    @Override
    public void startEngine() throws IsBrokenException {
        if (this.broken){
            throw new IsBrokenException("A bicaj elromlott!");
        } else {
            System.out.println("Felbőgött a bicikli motorja!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " ez egy bicikli mellesleg.";
    }
}
