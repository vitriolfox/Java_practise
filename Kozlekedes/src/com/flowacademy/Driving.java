package com.flowacademy;

import com.flowacademy.exceptions.IsBrokenException;
import com.flowacademy.wehicle.Bicycle;
import com.flowacademy.wehicle.Car;
import com.flowacademy.wehicle.Wehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Driving {

    private static final String WEHICLES = "./data/wehicles.txt";
    private static final String WEHICLE_FILEPATH = "./data/car.ser";

    public static void wehicleSerialization(List<Wehicle> wehicleList) {
        try {
            FileOutputStream fileOut = new FileOutputStream(WEHICLE_FILEPATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wehicleList);
            out.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Wehicle> wehicleDeSerialization(File file){
        List<Wehicle> wehicleList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(WEHICLE_FILEPATH));
            wehicleList = (List<Wehicle>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return wehicleList;
    }

    public static void main(String[] args) {
        BufferedReader br;
        List<Wehicle> wehicleList = new ArrayList<>();
        String[] splittedLine;
        int elementCounter = 0;

        try {
            br = new BufferedReader(new FileReader(WEHICLES));
            int inputElementsNumber = Integer.parseInt(br.readLine());
            String line;

            while (elementCounter < inputElementsNumber){
                line = br.readLine();
                splittedLine = line.split(";");

                if (splittedLine[0].equals("Bicycle")) {

                    if (splittedLine[2].equals("1")) {
                        Wehicle romlottBicaj = new Bicycle(Integer.parseInt(splittedLine[1]));
                        romlottBicaj.setBroken(true);
                        wehicleList.add(romlottBicaj);

                    } else {
                    wehicleList.add(new Bicycle(Integer.parseInt(splittedLine[1])));
                    }

                } else if (splittedLine[0].equals("Car")) {
                    wehicleList.add(new Car(Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2])));
                }

                elementCounter ++;
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Lefutott a listagenerálás.");
        }

        for (Wehicle wehicle: wehicleList){

            try {
                wehicle.startEngine();

            } catch (IsBrokenException e) {
                e.printStackTrace();
            }
        }

        Car car = new Car(1500, 300);
        System.out.println("A dudú üzemanyagszintje: " + car.getFuel());

        while( car.getFuel() > 0) {
            try {
                car.startEngine();
            } catch (IsBrokenException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A dudú üzemanyagszintje: " + car.getFuel());
        System.out.println("=====================");

        try {
            car.startEngine();
        } catch (IsBrokenException e) {
            e.printStackTrace();
        }

        wehicleSerialization(wehicleList);
        System.out.println("===================================");
        System.out.println(wehicleDeSerialization(new File(WEHICLE_FILEPATH)));

    }

}
