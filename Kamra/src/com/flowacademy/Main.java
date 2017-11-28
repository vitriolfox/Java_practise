package com.flowacademy;

import com.flowacademy.Emberek.Ember;
import com.flowacademy.Emberek.Halasz;
import com.flowacademy.Emberek.Vadasz;
import com.flowacademy.Emberek.ZsakmanyoloEmber;
import com.flowacademy.Exceptions.TeleVanException;
import com.flowacademy.Kamra.HalHusEnum;
import com.flowacademy.machine.util.Util;

import java.io.*;
import java.util.*;

public class Main {

    private static final String INPUT = "./data/input.txt";
    private static final String SERIALIZATION_FILE_PATH = "./data/emberlista.ser";

    private static void emberSerial(List<Ember> emberList) {

        try {
            FileOutputStream fileOut = new FileOutputStream(SERIALIZATION_FILE_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emberList);
            out.close();
            fileOut.close();
            System.out.println("Magic!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Ember> emberDeSerial(String file){
        List<Ember> deserialEmberList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(SERIALIZATION_FILE_PATH));
            deserialEmberList = (List<Ember>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("!cigaM");
        return deserialEmberList;
    }

    public static void addZsakmanyoloErtek(Map<ZsakmanyoloEmber, Set<Integer>> zsakmanyoloListHashMap,
                                           ZsakmanyoloEmber zsakmanyoloEmber, int zsakmanyolt){

        Util.putMapSet(zsakmanyoloListHashMap,zsakmanyoloEmber,zsakmanyolt);

    }


    public static Map<ZsakmanyoloEmber, List<Integer>> zsakmannyoloMapGyart(List<Ember> emberList){
        Map<ZsakmanyoloEmber, List<Integer>> zsakmanyoloListHashMap = new HashMap<>();
        for (Ember ember : emberList){
            if (ember instanceof ZsakmanyoloEmber){
                addZsakmanyoloErtek(zsakmanyoloListHashMap,((ZsakmanyoloEmber) ember),((ZsakmanyoloEmber) ember).zsakamanyol());
            }
        }
        return zsakmanyoloListHashMap;
    }

    public static void main(String[] args) {

        System.out.println("===========EmberLista készül!===========");


        List<Ember> emberList = new ArrayList<>();

        HashMap<Ember, HalHusEnum> emberMap = new HashMap<>();

        BufferedReader br;
        String[] splittedLine;
        int elementCounter = 0;

        try {
            br = new BufferedReader(new FileReader(INPUT));
            String line;

            while ((line = br.readLine()) != null){
                splittedLine = line.split(";");

                int emberKor = Integer.parseInt(splittedLine[2]);
                String emberNev = splittedLine[1];
                int emberEnergia = Integer.parseInt(splittedLine[3]);

                if (splittedLine[0].equals("Ember")) {

                    emberList.add(new Ember(emberNev,emberKor,emberEnergia));

                } else if (splittedLine[0].equals("Vadász")){

                    float szerencse = Float.parseFloat(splittedLine[4]);

                    emberList.add(new Vadasz(emberNev,emberKor,emberEnergia, szerencse));

                } else if (splittedLine[0].equals("Halász")) {

                    int haloMeret = Integer.parseInt(splittedLine[4]);
                    float szerencse = Float.parseFloat(splittedLine[5]);

                    emberList.add(new Halasz(emberNev, emberKor, emberEnergia, haloMeret, szerencse));

                } else {
                    System.out.println("Wrong constructor parameters!");
                }
            }

            br.close();

            System.out.println("EmberLista kész!");

        } catch (IOException e) {
            e.printStackTrace();

        }
        int random = new Random().nextInt(100);
        HalHusEnum eztEsziAzEmber;
        if (random > 50) {
            eztEsziAzEmber = HalHusEnum.HAL;
        } else {
            eztEsziAzEmber = HalHusEnum.HUS;
        }
        System.out.println("==========Emberek tevékenyek==========");

        for(Ember ember: emberList) {
            if (ember instanceof Vadasz) {
                ((Vadasz) ember).zsakamanyol();
                System.out.println(ember.getNev() + " vadászott!");
                emberMap.put(ember, HalHusEnum.HUS);

            } else if (ember instanceof Halasz) {
                ((Halasz) ember).zsakamanyol();
                System.out.println(ember.getNev() + " halászott!");
                emberMap.put(ember, HalHusEnum.HAL);

            } else {
                try {
                    ember.eszik(eztEsziAzEmber);
                    System.out.println(ember.getNev() + " evett!");
                    emberMap.put(ember, eztEsziAzEmber);
                } catch (TeleVanException e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println("============serialization=============");
        emberSerial(emberList);
        System.out.println("===========deserialization============");
        List<Ember> deserialEmberList = emberDeSerial(SERIALIZATION_FILE_PATH);
        System.out.println("============átlagszámítás=============");

        double szerencseSum = 0;
        int vadaszCounter = 0;

        for(Ember ember: deserialEmberList){
            if (ember instanceof Vadasz){
                System.out.println(ember.getNev() + " vadász");
                szerencseSum += ((Vadasz) ember).getSzerencse();
                vadaszCounter ++;
            } else {
                System.out.println(ember.getNev() + " nem vadász");
            }
        }
        System.out.println("======vadászok  átlagszerencséje======");
        System.out.println();
        System.out.println("A vadászok átlagszerencséje: " + szerencseSum/vadaszCounter);
        System.out.println();
        System.out.println("=============lista és map=============");
        System.out.println("emberList: " + emberList);
        System.out.println("emberMap: " + emberMap);
        System.out.println("deserialEmberList: " + deserialEmberList);
        System.out.println("==========kaki============");



    }

}
