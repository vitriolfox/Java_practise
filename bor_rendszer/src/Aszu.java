public class Aszu extends Bor {
    public int getPuttony() {
        return puttony;
    }

    public void setPuttony(int puttony) {
        this.puttony = puttony;
    }

    private int puttony;

    public Aszu(int evjarat, int puttony) {
        super("Aszu", evjarat);
        this.puttony = puttony;
    }

    @Override
    public String toString() {
        return "Aszu{" +
                "puttony=" + puttony +
                "} " + super.toString();
    }
}
