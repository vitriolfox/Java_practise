package com.flowacademy;

import com.flowacademy.wehicle.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void egyezesJellel (Car a, Car b){
        if (a == b){
            System.out.println("egyezesJellel: IGEN");
        } else {
            System.out.println("egyezesJellel: NEM");
        }
    }

    public static void egyezesEquals (Car a, Car b){

        if (a.equals(b)){
            System.out.println("egyezesEquals: IGEN");
        } else {
            System.out.println("egyezesEquals: NEM");
        }
    }

    public static void main(String[] args) {

        List<Car> autoList = new ArrayList<>();
        HashSet<Car> autoHalmaz = new HashSet<>();
        HashSet<String> gyumik = new HashSet<>();

        gyumik.add("alma");
        gyumik.add("korte");
        gyumik.add("szilva");
        gyumik.add("papaja");


        Car auto1 = new Car(1500, 200);
        Car auto2 = new Car(1500, 200);
        Car auto3 = auto1;
        Car auto4 = new Car(1500, 200);

        autoList.add(auto1);
        autoList.add(auto2);
        autoList.add(auto3);

        autoHalmaz.add(auto1);
        autoHalmaz.add(auto2);
        autoHalmaz.add(auto3);
        autoHalmaz.add(auto4);

        auto1.setWeight(2000);
        System.out.println(auto3.getWeight());

        egyezesJellel(auto1,auto2);
        egyezesEquals(auto1,auto2);
        System.out.println("==============");
        System.out.println(autoList.contains(auto4));
        System.out.println("==============");

        System.out.println(autoHalmaz.contains(auto4));

        System.out.println(gyumik.contains("papaja"));

        HashSet<Car> autoHalmaz2 = new HashSet<>();
        autoHalmaz2.add(auto1);
        auto1.setWeight(50);

        System.out.println(autoHalmaz2.contains(auto1));


    }

}
