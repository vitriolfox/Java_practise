package com.flowacademy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowacademy.machine.Truck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jsonParsing {

    public static void main(String[] args) {


        Truck truck = null;

        try {

            BufferedReader br = new BufferedReader(new FileReader("./data/trucks.json"));
            String line = null;
            List<Truck> truckParsedList = new ArrayList<>();

            while ((line = br.readLine()) != null) {

                ObjectMapper objectMapper = new ObjectMapper();
                truck = objectMapper.readValue(line, Truck.class);
                truckParsedList.add(truck);

            }

            System.out.println(truckParsedList);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
