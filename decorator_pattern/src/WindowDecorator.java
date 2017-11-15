public abstract class WindowDecorator implements IWindow {

    protected IWindow interfaceWindow;

    @Override
    public int getHeigth() {
        return interfaceWindow.getHeigth();
    }

    @Override
    public int getWidth() {
        return interfaceWindow.getWidth();
    }

    @Override
    public abstract void display();

    public WindowDecorator(IWindow interfaceWindow) {
        this.interfaceWindow = interfaceWindow;
    }
}
