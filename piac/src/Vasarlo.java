import java.util.Arrays;

public class Vasarlo {
    private Gyumolcs[] kosar;
    private int osszeg;

    public Vasarlo(Gyumolcs[] kosar, int osszeg) {
        this.kosar = kosar;
        this.osszeg = osszeg;
    }

    public Gyumolcs[] getKosar() {
        return kosar;
    }

    public void setKosar(Gyumolcs[] kosar) {
        this.kosar = kosar;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public void vasarol(Gyumolcs gyumolcs){
        for(int i=0; i < kosar.length; i++){
            if (gyumolcs.getAr() > getOsszeg()){
                System.out.println("Sajnos nincs elég pénzük a " + gyumolcs + " megvásárlásához.");
            } else if (gyumolcs.getAr() <= getOsszeg() && !(gyumolcs.getSzin().equals("zold"))){
                System.out.println("Sajnos mi csak zöld gyümölcsöt szeretnénk venni.");
            } else {
                kosar[i] = gyumolcs;
            }
        }
    }

    @Override
    public String toString() {
        return "Vasarlo{" +
                "kosar=" + Arrays.toString(kosar) +
                ", osszeg=" + osszeg +
                '}';
    }
}
