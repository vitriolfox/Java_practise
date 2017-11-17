import java.util.Random;

public class SzuperNagyi extends Vasarlo {
    private boolean isAlkudozo;
    Random random = new Random();

    public SzuperNagyi(Gyumolcs[] kosar, int osszeg) {
        super(kosar, (int)(osszeg*0.8));

        if (random.nextInt()==1){
            this.isAlkudozo = true;
        } else {
            this.isAlkudozo = false;
        }
    }

    public void megmondtam(){
        System.out.println("ugye unokám megmondtam, hogy ennél az árusnál lehet alkudni…");
    }

    @Override
    public void vasarol(Gyumolcs gyumolcs){
        for(int i=0; i < kosar.length; i++){
            if (gyumolcs.getAr() > getOsszeg()) {
                System.out.println("Sajnos nincs elég pénzük a " + gyumolcs + " megvásárlásához.");

            } else if (gyumolcs.getAr() <= this.getOsszeg() && gyumolcs.getSzin().equals("zold") || gyumolcs.getSzin().equals("sarga")){
                if (random.nextInt(100) > 25){
                    osszeg -= (gyumolcs.getAr()*0.9);
                    megmondtam();
                    kosar[i] = gyumolcs;
                } else {
                    osszeg -= gyumolcs.getAr();
                    kosar[i] = gyumolcs;
                }

            } else {
                System.out.println("Sajnos mi csak zöld gyümölcsöt szeretnénk venni.");
            }
        }
    }
}
