package com.flowacademy;

import com.flowacademy.uszoda.Gyorsuszo;
import com.flowacademy.uszoda.Hatuszo;
import com.flowacademy.uszoda.Uszo;
import com.flowacademy.uszoda.UszoMester;
import com.flowacademy.uszoda.comparators.GyorsuszoComparator;
import com.flowacademy.uszoda.comparators.HatuszoComparator;
import com.flowacademy.uszoda.comparators.UszoMesterComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Uszoverseny {

    private static final String INPUT = "./data/input.txt";
    private static final String OUTPUT = "./data/eredmeny.txt";
    private static final String USZOMESTER_SERIALIZATION_FILE_PATH = "./data/uszomesterek.ser";
    private static final String GYORSUSZO_SERIALIZATION_FILE_PATH = "./data/gyorsuszasverseny.ser";
    private static final String HATUSZO_SERIALIZATION_FILE_PATH = "./data/hatuszasverseny.ser";

    public static void uszoPrint(List<Uszo> uszomesterList, Uszo gyorsNyertes, Uszo hatNyertes, Writer uszoWriter) throws IOException{
        List<Uszo> kiirtUszoList = new ArrayList<>(uszomesterList);
        kiirtUszoList.add(gyorsNyertes);
        kiirtUszoList.add(hatNyertes);
        for (Uszo listElement : kiirtUszoList) {

            try {
                if (listElement instanceof UszoMester) {

                    uszoWriter.write(listElement.toString() + "\n");

                } else if (listElement instanceof Gyorsuszo){

                    uszoWriter.write("A gyorsúszás nyertese: " + listElement.toString() + "\n");

                } else if (listElement instanceof Hatuszo){

                    uszoWriter.write("A hátúszás nyertese: " + listElement.toString() + "\n");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void uszoSerial(List<Uszo> uszoBogyokak, String serialPath) {
        serializationCore(uszoBogyokak, serialPath);
    }

    public static void hatuszoSerial(List<Hatuszo> uszoBogyokak, String serialPath) {
        serializationCore(uszoBogyokak, serialPath);
    }

    public static void gyorsuszoSerial(List<Gyorsuszo> uszoBogyokak, String serialPath) {
        serializationCore(uszoBogyokak, serialPath);
    }

    public static void serializationCore(List list, String serialPath){
        try {
            FileOutputStream fileOut = new FileOutputStream(serialPath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
            System.out.println("Magic!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static List<Uszo> uszoDeSerialization(String file){
        List<Uszo> uszoList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            uszoList = (List<Uszo>) in.readObject();
            System.out.println("!cigaM");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return uszoList;
    }



    public static List<Gyorsuszo> gyorsUszoDeSerialization(String file){
        List<Gyorsuszo> uszoList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            uszoList = (List<Gyorsuszo>) in.readObject();
            System.out.println("!cigaM");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return uszoList;
    }



    public static List<Hatuszo> hatUszoDeSerialization(String file){
        List<Hatuszo> uszoList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            uszoList = (List<Hatuszo>) in.readObject();
            System.out.println("!cigaM");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return uszoList;
    }




    public static void main(String[] args) {

        System.out.println("===========input beolvasás úszólistába!===========");

        List<Uszo> uszoList = new ArrayList<>();

        BufferedReader br;
        String[] splittedLine;

        try {
            br = new BufferedReader(new FileReader(INPUT));
            String line;

            while ((line = br.readLine()) != null){
                splittedLine = line.split(" ");

                String uszoNev = splittedLine[1];
                int uszoTeljesitmeny = Integer.parseInt(splittedLine[2]);
                String uszoNemzetiseg = splittedLine[3];

                if (splittedLine[0].equals("Uszomester")) {

                    uszoList.add(new UszoMester(uszoNev,uszoTeljesitmeny,uszoNemzetiseg));

                } else if (splittedLine[0].equals("Gyorsuszo")){

                    uszoList.add(new Gyorsuszo(uszoNev,uszoTeljesitmeny,uszoNemzetiseg));

                } else if (splittedLine[0].equals("Hatuszo")) {

                    uszoList.add(new Hatuszo(uszoNev,uszoTeljesitmeny,uszoNemzetiseg));

                } else {
                    System.out.println("Wrong constructor parameters!");
                }
            }

            br.close();

            System.out.println("UszoLista kész!");

        } catch (IOException e) {
            e.printStackTrace();

        }

        System.out.println(uszoList + "\n");
        System.out.println("======Szétválogatás!=====");

        List<Uszo> uszoMesterList = new ArrayList<>();
        List<Gyorsuszo> gyorsuszoList = new ArrayList<>();
        List<Hatuszo> hatuszoList = new ArrayList<>();


        for (Uszo bogyoka: uszoList){
            if (bogyoka instanceof UszoMester){
                uszoMesterList.add((UszoMester) bogyoka);
            } else if (bogyoka instanceof Gyorsuszo){
                gyorsuszoList.add((Gyorsuszo) bogyoka);
            } else if (bogyoka instanceof Hatuszo){
                hatuszoList.add((Hatuszo) bogyoka);
            }
        }

        System.out.println(uszoMesterList);
        System.out.println(gyorsuszoList);
        System.out.println(hatuszoList + "\n");

        System.out.println("=====Rendezés=====");

        uszoMesterList.sort(new UszoMesterComparator());
        System.out.println("Úszómesterek névsorban: " + uszoMesterList);
        gyorsuszoList.sort(new GyorsuszoComparator());
        System.out.println("Gyorsúszás nyertese: " + gyorsuszoList.get(1));
        hatuszoList.sort(new HatuszoComparator());
        System.out.println("Hátúszás nyertese: " + hatuszoList.get(1));
        System.out.println();

        System.out.println("=====Úszómesterek névsora, versenyek nyerteseinek kiírása az eredmeny.txt fájlba.===");

        try {

            Writer uszasWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT), "utf-8"));
            uszoPrint(uszoMesterList, gyorsuszoList.get(1), hatuszoList.get(1), uszasWriter);

            uszasWriter.flush();
            uszasWriter.close();
            System.out.println("=====Kiírás sikeres!=====" + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=====Listák serializálása=====");

        uszoSerial(uszoMesterList, USZOMESTER_SERIALIZATION_FILE_PATH);
        gyorsuszoSerial(gyorsuszoList, GYORSUSZO_SERIALIZATION_FILE_PATH);
        hatuszoSerial(hatuszoList,HATUSZO_SERIALIZATION_FILE_PATH);

        System.out.println("=====Listák deserializálása=====");

       List<Uszo> deserializaltUszoMesterek = uszoDeSerialization(USZOMESTER_SERIALIZATION_FILE_PATH);
       List<Gyorsuszo> deserializaltGyorsuszok = gyorsUszoDeSerialization(GYORSUSZO_SERIALIZATION_FILE_PATH);
       List<Hatuszo> deserializaltHatuszok = hatUszoDeSerialization(HATUSZO_SERIALIZATION_FILE_PATH);



        //System.out.println(deserializaltUszoMesterek.indexOf(deserializaltUszoMesterek.get(1)));
        Collections.sort(gyorsuszoList);
        System.out.println("\n =====Gyorsúszók listái: teljesítmény szerint rendezve, versenyeredmény szerint rendezve=====");
        System.out.println(gyorsuszoList);
        System.out.println(deserializaltGyorsuszok);





    }

}
