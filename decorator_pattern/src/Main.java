public class Main {
    public static void main(String[] args) {
        IWindow ablak = new HorsontalScrollDekorator(new VerticalScrollWindow(new Window()));

        ablak.display();

    }
}
