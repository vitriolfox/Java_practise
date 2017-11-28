package com.flowacademy.machine;

import com.flowacademy.machine.util.Util;

import java.util.*;

public class TruckStat {
    private HashMap<String, Set<Integer> > teherbiras = new HashMap<>();

    public TruckStat(HashMap<String, Collection<Integer>> teherbiras) {
        this.teherbiras = teherbiras;
    }

    public void teherBiras(Truck truck){
        Util.putMapSet(teherbiras,truck.type,truck.capacity);

    }
}
