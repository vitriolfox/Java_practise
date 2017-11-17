public class AgeControllProxy implements IAuto{
    private Auto tutu;
    private int korhatar;


    public AgeControllProxy(Auto tutu, int korhatar) {
        this.tutu = tutu;
        this.korhatar = korhatar;
    }

    @Override
    public void beindit(Szemely szemely) {
        tutu.beindit(szemely);
    }

    @Override
    public void vezet(Szemely szemely) {
        if (szemely.getEletkor() >= korhatar){
            tutu.vezet(szemely);
        } else {
            System.out.println(szemely.getNev() + " kicsi vagy te még ehhez.");
        }
    }
}
