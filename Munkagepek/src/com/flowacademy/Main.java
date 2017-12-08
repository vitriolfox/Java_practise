package com.flowacademy;

import com.flowacademy.machine.FastestMachines;
import com.flowacademy.machine.Loader;
import com.flowacademy.machine.Truck;

import java.io.*;
import java.util.*;

public class Main {

    private static final String INPUT = "./data/trucks.txt";
    private static final String OUTPUT = "./data/machines.ser";



    public static void machineSerial(HashMap<Loader, Truck> machines) {
        try {
            FileOutputStream fileOut = new FileOutputStream(OUTPUT);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(machines);
            out.close();
            fileOut.close();
            System.out.println("Magic!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Loader, Truck> machineDeSerialization(String file){
        HashMap<Loader, Truck> machineMap = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(OUTPUT));
            machineMap = (HashMap<Loader, Truck>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return machineMap;
    }

    public static FastestMachines leggyorsabbParos (HashMap<Loader, Truck> hashMap, int mennyit, int tavolsag){
        double leggyorsabb = Double.MAX_VALUE;
        double ido;
        FastestMachines gyorsMasina = null;

        for(Map.Entry<Loader, Truck> entry : hashMap.entrySet()){
            Loader loader = entry.getKey();
            Truck truck = entry.getValue();

            ido = loader.load(mennyit, tavolsag, truck);

            if (ido < leggyorsabb){
                leggyorsabb = ido;

                gyorsMasina = new FastestMachines(loader,truck,leggyorsabb);
            }
        }

        return gyorsMasina;
    }

    public static void main(String[] args) {

        HashMap<Loader, Truck> machineMap = new HashMap<>();
        BufferedReader br;
        String[] splittedLine;

        try {
            br = new BufferedReader(new FileReader(INPUT));
            String line;

            while ((line = br.readLine()) != null){
                splittedLine = line.split(" ");

                int loaderWeight = Integer.parseInt(splittedLine[2]);
                String loaderType = splittedLine[1];
                int loaderLoadingWeight = Integer.parseInt(splittedLine[3]);

                int truckWeight = Integer.parseInt(splittedLine[6]);
                String truckType = splittedLine[5];
                int truckCapacity = Integer.parseInt(splittedLine[7]);

                if (splittedLine[0].equals("Markolo")) {

                    machineMap.put(new Loader(loaderWeight,loaderType,loaderLoadingWeight),
                                   new Truck(truckWeight,truckType,truckCapacity));

                } else {

                    System.out.println("Wrong constructor parameters!");
                }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            System.out.println("HashMap generating done!");
        }


        Set entrySet = machineMap.entrySet();
        Iterator it = entrySet.iterator();
        double ido = 0;
        double legjobbIdo = Double.MAX_VALUE;
        Loader legjobbMarkolo = null;
        Truck legjobbTruck = null;


        double speedTestResult = 0;

        while (it.hasNext()) {
            int cycleCount = 0;
            HashMap.Entry me = (HashMap.Entry)it.next();
            Loader loader = (Loader) me.getKey();
            Truck truck = (Truck) me.getValue();

            ido = loader.load(600, 200, truck);

            if (ido<legjobbIdo){
                legjobbIdo = ido;
                legjobbMarkolo = loader;
            }

            legjobbTruck = machineMap.get(legjobbMarkolo);

        }
        System.out.println("legjobbak: " + legjobbMarkolo + ", " + legjobbTruck);
        System.out.println("==========================================");

        machineSerial(machineMap);
        HashMap<Loader,Truck> desMachineMap = machineDeSerialization(OUTPUT);
        System.out.println(desMachineMap);
        System.out.println("==========================================");

        System.out.println(desMachineMap.keySet());
        int truckNumber = new HashSet<>(desMachineMap.values()).size();
        System.out.println(truckNumber);
        System.out.println("==========================================");

        System.out.println(leggyorsabbParos(desMachineMap, 600, 200));







    }

    }

