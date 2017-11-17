public class Main {
    public static void main(String[] args) {
        Szemely jozsi = new Szemely("Józsi", 80);

        IAuto audiA6 = new AgeControllProxy(new Auto(),81);

        audiA6.beindit(jozsi);
        audiA6.vezet(jozsi);
    }
}
