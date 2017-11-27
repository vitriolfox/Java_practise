package com.flowacademy.machine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TruckStat {
    private HashMap<String, Set<Integer> > teherbiras = new HashMap<>();

    public TruckStat(HashMap<String, Set<Integer>> teherbiras) {
        this.teherbiras = teherbiras;
    }

    public void teherBiras(Truck truck){
        if (teherbiras.containsKey(truck.type)){
            Set<Integer> teherbirasok = teherbiras.get(truck.type);
            teherbirasok.add(truck.getCapacity());
            teherbiras.put(truck.type, teherbirasok);

        } else {
            Set<Integer> teherbirasok = new HashSet<Integer>();
            teherbirasok.add(truck.getCapacity());
            teherbiras.put(truck.type, teherbirasok);
        }
    }
}
