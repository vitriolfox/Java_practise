import exception.HibasKikolcsonzesException;
import exception.NotFoundException;
import videoteka.OktatoVideo;
import videoteka.Video;
import videoteka.VideoTeka;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String INPUT = "./data/input.txt";
    private static final String VIDEOTEKA_FILEPATH = "./data/videoteka.ser";


    public static void videotekaSerial(VideoTeka videoteka) {
        try {
            FileOutputStream fileOut = new FileOutputStream(VIDEOTEKA_FILEPATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(videoteka);
            out.close();
            fileOut.close();
            System.out.println("Magic!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        VideoTeka videoteka = new VideoTeka();
        BufferedReader br;
        String[] splittedLine;
        int elementCounter = 0;

        try {
            br = new BufferedReader(new FileReader(INPUT));
            int inputElementsNumber = Integer.parseInt(br.readLine());
            String line;

            while (elementCounter < inputElementsNumber) {
                line = br.readLine();
                splittedLine = line.split(";");

                if (splittedLine.length == 3) {
                    videoteka.add(new Video(splittedLine[0], splittedLine[1], Integer.parseInt(splittedLine[2])));

                } else if (splittedLine.length == 2){
                    videoteka.add(new OktatoVideo(splittedLine[0], splittedLine[1]));

                } else {

                    System.out.println("HIBAAA!");
                }

                elementCounter ++;

                }

                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Lefutott a videoteka feltöltése.");
            }

        Video kikeresettVideo = null;
        try {
            kikeresettVideo = videoteka.keres("ÉletaFöldön", true);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        try {
                if (kikeresettVideo.kikolcsonoz(18,20)){
                    System.out.println("Sikeresen kikölcsönözted: " + kikeresettVideo.toString());
                } else {
                    System.out.println("Sajnos a " + kikeresettVideo.getFilmCime() + " már ki lett kölcsönözve.");
                }
            } catch (HibasKikolcsonzesException e) {
                e.printStackTrace();
            }

            videotekaSerial(videoteka);

    }
}
