package com.flofacademy;

import com.flofacademy.exceptions.BadQualityException;
import com.flofacademy.storage.DairyProduct;
import com.flofacademy.storage.Fruit;
import com.flofacademy.storage.Ware;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Leltar {

    private static final String INPUT = "./src/com/flofacademy/input.csv";
    private static final String KUKA = "./src/com/flofacademy/kuka.csv";
    private static final String POLCRA = "./src/com/flofacademy/polcra.csv";

    public static void warePrint(List<Ware> list, Writer shelfWriter, Writer trashWriter) throws IOException{
        for (Ware listElement : list) {
            try {
                listElement.isGood();
                    shelfWriter.write(listElement.toString() + "\n");

            } catch (BadQualityException e) {
                trashWriter.write(listElement.toString() + "\n");
            }
        }
    }

    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        List<Ware> fruitList = new ArrayList<>();
        List<Ware> dairyList = new ArrayList<>();
        String[] splittedLine;
        int elementCounter = 0;

        try {

            bufferedReader = new BufferedReader(new FileReader(INPUT));
            int inputElementsNumber = Integer.parseInt(bufferedReader.readLine());
            String line;

            while (elementCounter < inputElementsNumber) {
                line = bufferedReader.readLine();
                splittedLine = line.split(";");

                if (splittedLine[0].equals("T")) {
                    String name = splittedLine[3];
                    long productionDate = Long.parseLong(splittedLine[2]);
                    long bestBefore = Long.parseLong(splittedLine[1]);
                    dairyList.add(new DairyProduct(name, productionDate, bestBefore));

                } else if (splittedLine[0].equals("Gy")) {
                    fruitList.add(new Fruit(splittedLine[1]));

                }
                elementCounter++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        try {

            Writer shelfWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(POLCRA), "utf-8"));
            Writer trashWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(KUKA), "utf-8"));

            warePrint(fruitList, shelfWriter, trashWriter);
            warePrint(dairyList, shelfWriter, trashWriter);

            shelfWriter.flush();
            trashWriter.flush();
            shelfWriter.close();
            trashWriter.close();
        } catch (IOException e) {
            e.getStackTrace();

        } finally {
            System.out.println("Lefutott a writer");
        }
    }
}
