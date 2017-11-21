package com.flowacademy.Player;

import com.flowacademy.Media.Mp3;
import com.flowacademy.Media.VideoClip;

public class Winamp {
    protected int playListSize;
    protected Mp3[] mp3Array;

    public Winamp(int playListSize) {
        this.playListSize = playListSize;
        this.mp3Array = new Mp3[playListSize];
    }

    public void hozzaad(Mp3 mp3Objektum){

        for (int i=0; i<playListSize; i++) {

            if (this.mp3Array[0] == null) {
                this.mp3Array[i] = mp3Objektum;

            } else if (this.mp3Array[i] != null && this.mp3Array[i+1] == null) {
                this.mp3Array[i+1] = mp3Objektum;
                break;

            }
        }
    }

    public Mp3 lekerdez(int i) {
       Mp3 lekerdezett = this.mp3Array[i];
       return lekerdezett;
    }

    public String info(Mp3 mp3Objektum){
        return mp3Objektum.toString();
    }


    public static void main(String[] args) {
        Winamp player = new Winamp(args.length);

        for (int i=0; i<args.length; i++){
            String[] songArgs = args[i].split(",");
            if (songArgs[0].equals("Mp3")){
                Mp3 mp3Song = new Mp3(songArgs[1], songArgs[2], songArgs[3], Integer.parseInt(songArgs[4]));
                player.hozzaad(mp3Song);
            } else if (songArgs[0].equals("Mp4")){
                Mp3 mp4Song = new VideoClip(songArgs[1], songArgs[2], songArgs[3], Integer.parseInt(songArgs[4]),
                        Integer.parseInt(songArgs[5]), Integer.parseInt(songArgs[6]));
                player.hozzaad(mp4Song);
            } else {
                System.out.println("Valami nemfasza!");
            }
        }

        System.out.println("Ez a sima toString:");

        for (Mp3 song: player.mp3Array){
            System.out.println(song.toString());
        }
        System.out.println("=================================" + '\n');

        System.out.println("Ez az info a playlist 1. tagjáról");
        System.out.println(player.info(player.mp3Array[0]));

        System.out.println("A dalok átlag hossza: " +
                ((player.mp3Array[0].getDuration() + player.mp3Array[1].getDuration())/2));
    }
}
