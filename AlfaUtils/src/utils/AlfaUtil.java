package utils;

import java.io.*;
import java.util.*;

public class AlfaUtil {
    public static <K,V> Map<K,Collection<V>> putMapSet(Map<K,Collection<V>> map, K key, V value){
        if (map.containsKey(key)){
            Collection<V> values = map.get(key);
            values.add(value);
            map.put(key, values);

        } else {
            Set<V> values = new HashSet<V>();
            values.add(value);
            map.put(key, values);
        }
        return map;
    }


    public static String[] fileSplitReader(String inputFilePath, String splitterCharacter) throws IOException {

        BufferedReader br;
        String[] splittedLine = null;

        try {
            br = new BufferedReader(new FileReader(inputFilePath));
            String line;

            if ((line = br.readLine()) != null) {
                splittedLine = line.split(splitterCharacter);
            } else {
                throw new IOException("No line to split!");
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return splittedLine;
    }

    public static void machineSerial(Object object, String outputPath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(outputPath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.println("Magic!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Object> deSerializeList(String deSerializePath) {
        List<Object> list = null;
        try {
            FileInputStream fileIn = new FileInputStream(deSerializePath);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            list.add(objIn.readObject());
            objIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
