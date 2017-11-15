public class HorsontalScrollDekorator extends WindowDecorator {

    @Override
    public void display() {
       interfaceWindow.display();
        System.out.println("Horizontáltam!");
    }

    public HorsontalScrollDekorator(IWindow interfaceWindow) {
        super(interfaceWindow);
    }
}
