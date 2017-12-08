package com.flowacademy.machine.comparator;

import com.flowacademy.machine.Truck;

import java.util.Comparator;

public class WeigthComparator implements Comparator<Truck>{

    @Override
    public int compare(Truck truck1, Truck truck2) {
        if (truck1.getWeight() > truck2.getWeight()){
            return 1;
        }else if (truck1.getWeight() < truck2.getWeight()){
            return -1;
        } else {
            return 0;
        }
    }
}
