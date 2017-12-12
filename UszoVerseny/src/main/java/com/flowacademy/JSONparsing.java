package com.flowacademy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowacademy.uszoda.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONparsing{

    public static void main(String[] args) {

        Gyorsuszo uszoBogyoka = null;

        try {

            BufferedReader br = new BufferedReader(new FileReader("./data/gyorsuszokJSON.json"));
            String line = null;
            List<Gyorsuszo> uszoParsedList = new ArrayList<>();

            while ((line = br.readLine()) != null){

                ObjectMapper objectMapper = new ObjectMapper();
                uszoBogyoka = objectMapper.readValue(line, Gyorsuszo.class);
                uszoParsedList.add(uszoBogyoka);

            }

            System.out.println(uszoParsedList);




        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("Gyorsuszo Object\n" + uszoBogyoka);

    }
}