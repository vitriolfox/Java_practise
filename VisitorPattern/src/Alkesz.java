public class Alkesz extends Ember{
    public Alkesz() {
    }

    @Override
    public void visit(Kocsma kocsma) {
        System.out.println("Otthon édes otthon!");
    }

    @Override
    public void visit(Bordely bordely) {
        System.out.println("Pezsgővel jobban csúszik!");
    }

    @Override
    public void visit(Temeto temeto) {
        System.out.println("Igyá' komám meg sápadt vagy!");
    }
}
