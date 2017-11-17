package com.flowacademy.lista;

import java.util.HashSet;
import java.util.Iterator;

public class Halmaz {
    public static void main(String[] args) {
        HashSet<Integer> halmaz = new HashSet<Integer>();

        halmaz.add(1);
        halmaz.add(1);
        halmaz.add(2);
        halmaz.add(1);
        halmaz.add(1);

        System.out.println(halmaz);

        for (Integer halmazelem: halmaz){
            System.out.println(halmazelem);
        }

        for (int i = 0; i < halmaz.size(); i++){
            System.out.println(halmaz);
        }

        Iterator<Integer> halmazItarator = halmaz.iterator();

        while (halmazItarator.hasNext()){
            System.out.println(halmazItarator.next());
        }
    }
}