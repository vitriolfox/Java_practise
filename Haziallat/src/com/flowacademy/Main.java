package com.flowacademy;

import com.flowacademy.exeptions.HaziallatExeptions;
import com.flowacademy.kedvencek.Haziallat;
import com.flowacademy.kedvencek.Kutya;
import com.flowacademy.kedvencek.Macska;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String INPUT = "./data/input.txt";
    private static final String BOLDOGOK = "./data/boldogok.txt";

    public static void allatPrint(List<Haziallat> list, Writer allatWriter) throws IOException{
        for (Haziallat listElement : list) {
            try {
                if (listElement.isBoldogsag()) {
                    allatWriter.write(listElement.toString() + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        BufferedReader bufferedReader;
        List<Haziallat> allatList = new ArrayList<>();
        String[] splittedLine;
        int elementCounter = 0;


        try {

            bufferedReader = new BufferedReader(new FileReader(INPUT));
            int inputElementsNumber = Integer.parseInt(bufferedReader.readLine());
            String line;

            while (elementCounter <= inputElementsNumber) {
                line = bufferedReader.readLine();
                splittedLine = line.split(";");

                if (splittedLine[0].equals("Kutya")) {
                   allatList.add(new Kutya(splittedLine[1]));

                } else if (splittedLine[0].equals("Macska")) {
                    allatList.add(new Macska(splittedLine[1]));
                }
                elementCounter++;
            }

            while ((line = bufferedReader.readLine()) != null) {
                splittedLine = line.split(";");
                int allatSorszam = Integer.parseInt(splittedLine[0]);

                try {

                    if (splittedLine[1].equals("megetet")) {

                        allatList.get(allatSorszam).megetet();

                    } else if (splittedLine[1].equals("simogat")) {
                        allatList.get(allatSorszam).simogat();
                    }
                } catch (HaziallatExeptions e){
                    e.printStackTrace();
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{

            Writer allatWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(BOLDOGOK), "utf-8"));
            for (Haziallat allat: allatList){
                allat.setBoldogsag();
            }

            allatPrint(allatList, allatWriter);

            allatWriter.flush();
            allatWriter.close();

        }catch (IOException e) {
            e.getStackTrace();

        } finally {
            System.out.println("Lefutott a writer");
        }

    }

}
