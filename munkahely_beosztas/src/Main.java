public class Main {
    public static void main(String[] args) {

        Fonok diri = new Fonok();
        Kollegak[] brigad = new Kollegak[3];

        brigad[0] = new Manager();
        brigad[1] = new Beosztott();
        brigad[2] = new Beosztott();

        diri.setBeosztottak(brigad);
        diri.bonusztOszt();



    }
}
