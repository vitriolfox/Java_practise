package com.flowacademy.machine.comparator;

import com.flowacademy.machine.Truck;

import java.util.Comparator;

public class TypeComparator implements Comparator <Truck> {

    @Override
    public int compare(Truck truck1, Truck truck2) {
        return String.CASE_INSENSITIVE_ORDER.compare(truck1.getType(), truck2.getType());
    }
}
