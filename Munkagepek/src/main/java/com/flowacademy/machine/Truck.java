package com.flowacademy.machine;

import com.flowacademy.Transporter;

import java.io.Serializable;
import java.util.Random;

public class Truck extends Machinery implements Transporter, Serializable, Comparable {

    protected int capacity;
    protected int loadedWeight;

    public Truck(int weight, String type, int capacity) {
        super(weight, type);
        this.capacity = capacity;
        this.loadedWeight = 0;
    }

    public Truck() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLoadedWeight() {
        return loadedWeight;
    }

    public void setLoadedWeight(int loadedWeight) {
        this.loadedWeight = loadedWeight;
    }

    @Override
    public double transport(int km) throws Exception {
        if (this.loadedWeight == 0){
            throw new Exception("No loading to be transported!");

        } else {
            double random = Math.random();
            double velocity = (this.weight + this.loadedWeight) * random;
            double transportTime = km/velocity;

            this.loadedWeight = 0;
            return transportTime;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Truck truck = (Truck) o;

        if (capacity != truck.capacity) return false;
        return loadedWeight == truck.loadedWeight;
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + loadedWeight;
        return result;
    }

    @Override
    public String toString() {
        return "Truck: " +
                "capacity: " + capacity +
                ", loadedWeight: " + loadedWeight +
                " " + super.toString();
    }

    @Override
    public int compareTo(Object o) {
        Truck truck1 = (Truck) o;
        if (((Truck) o).capacity > this.capacity){
            return 1;
        } else if (((Truck) o).capacity < this.capacity) {
            return -1;
        } else  {
            return 0;
        }
    }
}
