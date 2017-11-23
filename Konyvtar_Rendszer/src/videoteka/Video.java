package videoteka;

import exception.HibasKikolcsonzesException;
import exception.HibasVideoException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Video implements Kolcsonozheto{

    protected String filmCime;
    protected boolean kolcsonozheto;
    protected String kolcsonzesiIdo;
    protected int korhatar;

    protected int kolcsonzesiIdoInt;

    private String kolcsinzesiIdoVizsgalat(String ido) throws HibasVideoException{
        HashSet<String> kolcsonzesiIdoHash = new HashSet<>();
        kolcsonzesiIdoHash.add("egynapos");
        kolcsonzesiIdoHash.add("ketnapos");
        kolcsonzesiIdoHash.add("korlatlan");

        if (ido.equals("egynapos")){
            this.kolcsonzesiIdoInt = 1;
        } else if (ido.equals("ketnapos")){
            this.kolcsonzesiIdoInt = 2;
        } else if (ido.equals("korlatlan")){
            this.kolcsonzesiIdoInt = 999999999;
        }

        if (kolcsonzesiIdoHash.contains(ido)){
            return ido;
        } else {
            throw new HibasVideoException ("Hibás megadott kölcsönzési idő paraméter!");
        }

    }

    private int korhatarVizsgalat(int ido) throws HibasVideoException{
        List<Integer> korhatarList = new ArrayList<>();
        korhatarList.add(0);
        korhatarList.add(12);
        korhatarList.add(16);
        korhatarList.add(18);

        if (korhatarList.contains(ido)){
            return ido;
        } else {
            throw new HibasVideoException ("Hibás megadott korhatár paraméter!");
        }

    }

    public Video(String filmCime, String kolcsonzesiIdo, int korhatar){
        this.filmCime = filmCime;
        this.kolcsonozheto = true;
        try {
            this.kolcsonzesiIdo = kolcsinzesiIdoVizsgalat(kolcsonzesiIdo);
            this.korhatar = korhatarVizsgalat(korhatar);

        } catch (HibasVideoException e) {
            e.printStackTrace();
        }
    }

    public String getFilmCime() {
        return filmCime;
    }

    public void setFilmCime(String filmCime) {
        this.filmCime = filmCime;
    }

    public boolean isKolcsonozheto() {
        return kolcsonozheto;
    }

    public void setKolcsonozheto(boolean kolcsonozheto) {
        this.kolcsonozheto = kolcsonozheto;
    }

    public String getKolcsonzesiIdo() {
        return kolcsonzesiIdo;
    }

    public void setKolcsonzesiIdo(String kolcsonzesiIdo) {
        this.kolcsonzesiIdo = kolcsonzesiIdo;
    }

    public int getKorhatar() {
        return korhatar;
    }

    public void setKorhatar(int korhatar) {
        this.korhatar = korhatar;
    }

    @Override
    public boolean kikolcsonoz(int kor, int meddig) throws HibasKikolcsonzesException {

        if (kor > this.korhatar && meddig <= this.kolcsonzesiIdoInt){
            this.kolcsonozheto = false;
            return true;
        } else if (!this.kolcsonozheto){
            return false;
        } else {
            throw new HibasKikolcsonzesException ("Hibásan megadott kikölcsönzési paraméterek!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        if (kolcsonozheto != video.kolcsonozheto) return false;
        if (korhatar != video.korhatar) return false;
        if (filmCime != null ? !filmCime.equals(video.filmCime) : video.filmCime != null) return false;
        return kolcsonzesiIdo != null ? kolcsonzesiIdo.equals(video.kolcsonzesiIdo) : video.kolcsonzesiIdo == null;
    }

    @Override
    public int hashCode() {
        int result = filmCime != null ? filmCime.hashCode() : 0;
        result = 31 * result + (kolcsonozheto ? 1 : 0);
        result = 31 * result + (kolcsonzesiIdo != null ? kolcsonzesiIdo.hashCode() : 0);
        result = 31 * result + korhatar;
        return result;
    }

    @Override
    public boolean visszahoz() {
        return this.kolcsonozheto = true;
    }

    @Override
    public String toString() {
        return filmCime +
                ", kolcsonzesiIdo: " + kolcsonzesiIdo +
                ", korhatar: " + korhatar;
    }
}
