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
}
