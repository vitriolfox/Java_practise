package com.flowacademy;

import sun.util.logging.PlatformLogger;

import java.util.ArrayList;
import java.util.List;

import static com.flowacademy.Level.HIGH;

public class Main {
    public static void main(String[] args) {

        List<Example> peldaList = new ArrayList<>();
        peldaList.add(new Example(HIGH, 1));
        peldaList.add(new Example(Level.MEDIUM, 2));
        peldaList.add(new Example(Level.LOW, 3));

        for (Example valami : peldaList){
            if (valami.getLevel().equals(HIGH)){
                System.out.println(valami.getValue());
            }
        }

    }
}
