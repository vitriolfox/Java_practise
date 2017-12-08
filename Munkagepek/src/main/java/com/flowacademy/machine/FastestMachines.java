package com.flowacademy.machine;

import java.io.Serializable;

public class FastestMachines implements Serializable{

    private Loader fastestLoader;
    private Truck fastestTruck;
    private double fastestTime;

    public FastestMachines(Loader fastestLoader, Truck fastestTruck, double fastestTime) {
        this.fastestLoader = fastestLoader;
        this.fastestTruck = fastestTruck;
        this.fastestTime = fastestTime;
    }

    public Loader getFastestLoader() {
        return fastestLoader;
    }

    public Truck getFastestTruck() {
        return fastestTruck;
    }

    public double getFastestTime() {
        return fastestTime;
    }

    @Override
    public String toString() {
        return  "FastestLoader: " + fastestLoader +
                " / fastestTruck: " + fastestTruck +
                " / fastestTime: " + fastestTime;
    }
}
