public class Singleton {

    private static Singleton instance = null;

    private Singleton() {
        System.out.println("Új példány készült");
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
