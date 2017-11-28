package com.flowacademy.machine.util;

import com.flowacademy.machine.Truck;

import java.util.*;

public class Util {

    public static <K,V> Map<K,Collection<V>> putMapSet(Map<K,Collection<V>> map, K key, V value){
        if (map.containsKey(key)){
            Collection<V> values = map.get(key);
            values.add(value);
            map.put(key, values);

        } else {
            Set<V> values = new HashSet<V>();
            values.add(value);
            map.put(key, values);
        }
        return map;
    }
}
