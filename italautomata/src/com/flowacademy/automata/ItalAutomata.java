package com.flowacademy.automata;

public class ItalAutomata extends UresAutomata {
    private boolean isHidegIal;

    public ItalAutomata(int poharakSzama, boolean isHidegIal) {
        super(0,poharakSzama,true);
        this.isHidegIal = isHidegIal;
    }

    public boolean isHidegIal() {
        return isHidegIal;
    }

    public void setHidegIal(boolean hidegIal) {
        isHidegIal = hidegIal;
    }

    @Override
    public void penztBedob(int penz) {
        int teaAra = 95;
        System.out.println(teaAra + " Ft-ért lehet teát kérni.");
        if (this.poharakSzama <= 0 || !isHasznalhato){
            System.out.println("Próbálkozzon később");
        } else if (penz < teaAra) {
            System.out.println("Kevés a bedobott pénz");
        } else if (penz >= teaAra){
            System.out.println("Sikeresen kiadtuk a teát, a visszajáró: " + (penz-teaAra) + "-Ft.");
            poharakSzama--;
            bedobottPenz += teaAra;
        } else {
            System.out.println("A vásárlás nem sikerült!");
        }
    }

    @Override
    public String toString() {
        String hidegVagyMelegItal;
        if (isHidegIal){
            hidegVagyMelegItal = "ez a gép hideg italokat árusít";
        } else {
            hidegVagyMelegItal = "ez a gép meleg italokat árusít";
        }

        return super.toString() +
                hidegVagyMelegItal;
    }
}
