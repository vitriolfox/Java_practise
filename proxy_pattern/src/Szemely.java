public class Szemely {
    protected String nev;
    protected int eletkor;

    public Szemely(String nev, int eletkor) {
        this.nev = nev;
        this.eletkor = eletkor;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }
}
