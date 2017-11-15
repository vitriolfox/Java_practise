package com.flowacademy.ember;

public class Kocsmaros {
    private int penz;
    private static int koszosPohar;

    public Kocsmaros(int penz) {
        this.penz = penz;
    }

    public void setPenz(int penz) {
        this.penz += penz;
    }

    public static void setKoszosPohar(int koszosPohar) {
        Kocsmaros.koszosPohar += koszosPohar;
    }

    public void elmos(){
        if (koszosPohar < 1){
            System.out.println("Nincs koszos pohár, nincs mit elmosni.");
        } else {
            koszosPohar -= 1;
            System.out.println("A kocsmáros elmosott egy poharat. A maradék koszos poharak száma: " + koszosPohar);
        }
    }

    @Override
    public String toString() {
        return "Kocsmaros{" +
                "penz=" + penz +
                '}';
    }
}
