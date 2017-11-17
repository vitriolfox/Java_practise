public class Auto implements IAuto {
    public Auto() {
    }

    public void beindit(Szemely szemely){
        System.out.println("Beindítta az autót " + szemely.getNev());
    }


    public void vezet (Szemely szemely){
        System.out.println("Vezeti az autót " + szemely.getNev());
    }
}
