public class Szexmanias extends Ember{
    public Szexmanias() {
    }

    @Override
    public void visit(Kocsma kocsma) {
        System.out.println("A bárpultra! Most!");
    }

    @Override
    public void visit(Bordely bordely) {
        System.out.println("Medve is kinyalja a mézesköcsögöt!");
    }

    @Override
    public void visit(Temeto temeto) {
        System.out.println("Száraz bor is hidegen jó!");
    }
}
