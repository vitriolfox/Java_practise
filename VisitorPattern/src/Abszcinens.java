public class Abszcinens extends Ember{
    public Abszcinens() {
    }

    @Override
    public void visit(Kocsma kocsma) {
        System.out.println("Lónyálat innám!");
    }

    @Override
    public void visit(Bordely bordely) {
        System.out.println("Alkoholmentes nőt kérek!");
    }

    @Override
    public void visit(Temeto temeto) {
        System.out.println("Mé hideg a talpa ennek az alvó embernek?");

    }
}
