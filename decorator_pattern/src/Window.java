public class Window implements IWindow {

    protected int heigth;
    protected int width;

    @Override
    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void display() {
        System.out.println("Window");
    }

}
