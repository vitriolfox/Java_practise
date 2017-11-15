public class VerticalScrollWindow extends WindowDecorator{

    @Override
    public void display() {
        interfaceWindow.display();
        System.out.println("Vertikáltam!");
    }

    public VerticalScrollWindow(IWindow interfaceWindow) {
        super(interfaceWindow);
    }
}
