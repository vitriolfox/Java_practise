public class Fonok implements Kollegak {

    Kollegak[] beosztottak = new Kollegak[5];

    public void setBeosztottak(Kollegak[] beosztottak) {
        this.beosztottak = beosztottak;
    }

    @Override
    public void bonusztOszt() {

        System.out.println("Hulljon a zsé a népre!");

        for (Kollegak beosztott: beosztottak){
            beosztott.bonusztOszt();
        }
    }
}
