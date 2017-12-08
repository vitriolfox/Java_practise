package com.flowacademy;

import com.flowacademy.machine.Truck;
import com.flowacademy.machine.comparator.TypeComparator;
import com.flowacademy.machine.comparator.WeigthComparator;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MunkagepRendezes {

    public static void main(String[] args) {


    List<Truck> truckLista = new LinkedList<>();

        truckLista.add(new Truck(1000,"IFA",2000));
        truckLista.add(new Truck(3800,"LIZ",2500));
        truckLista.add(new Truck(900,"KAZ",1800));
        truckLista.add(new Truck(1200,"VOLGA",5000));

        Collections.sort(truckLista, Collections.reverseOrder());
        System.out.println(truckLista);

        truckLista.sort(new WeigthComparator());
        System.out.println(truckLista);

        truckLista.sort(new TypeComparator());
        System.out.println(truckLista);

    }

}
