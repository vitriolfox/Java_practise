import java.util.Arrays;

public class Vasarlo {
    protected Gyumolcs[] kosar;
    protected int osszeg;

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
            if (gyumolcs.getAr() > getOsszeg()) {
                System.out.println("Sajnos nincs elég pénzük a " + gyumolcs + " megvásárlásához.");

            } else if (gyumolcs.getAr() <= this.getOsszeg() && gyumolcs.getSzin().equals("zold")){
                osszeg -= gyumolcs.getAr();
                kosar[i] = gyumolcs;

            } else {
                System.out.println("Sajnos mi csak zöld gyümölcsöt szeretnénk venni.");
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
