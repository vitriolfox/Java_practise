package com.flowacademy.ember;

public class Ember {
    private String nev;
    private int kor;
    private boolean nem;
    private int penz;
    private int reszegseg = 0;
    private boolean isKocsmaban = false;
    private static int EMBEREKSZAMA = 0;
    private static final int RESZEGSEG_KORLAT = 40;

    public Ember(String nev, int kor, boolean nem) {
        this.nev = nev;
        this.kor = kor;
        this.nem = nem;
        this.EMBEREKSZAMA++;
    }

    public Ember(String nev) {
        this.nev = nev;
    }

    public Ember(String nev, int kor, boolean nem, int penz) {
        this.nev = nev;
        this.kor = kor;
        this.nem = nem;
        this.penz = penz;
        this.EMBEREKSZAMA++;
    }

    public static int getEMBEREKSZAMA() {
        return EMBEREKSZAMA;
    }

    public void kiir(){
        System.out.println("Szia! Az én nevem " + nev + " " + kor + " éves, " + ((nem == true) ? "férfi" : "nő") + " vagyok.");
    }

    public void iszik(Kocsmaros kocsmaros){
        if ( isKocsmaban != true ){
            System.out.println(this.nev + " nincs a kocsmában, nem tud inni! :(");
        } else {
            penz -= 1;
            reszegseg += 1;
            kocsmaros.setKoszosPohar(1);
            kocsmaros.setPenz(1);
            if (this.reszegseg > RESZEGSEG_KORLAT) {
                this.alszik();
            }
        }
    }

    public void alszik(){
        reszegseg = 0;
        System.out.println(this.nev + " elaludt.");
    }

    public void hazamegy(){
        isKocsmaban = false;
        System.out.println(this.nev + " hazament.");
    }

    public void jon(){
        isKocsmaban = true;
        System.out.println(this.nev + " megjött a kocsmába.");
    }

    public Integer getKor(){
        return kor;
    }

    public void iszik(Kocsmaros kocsmaros, Ital ital){
        if (isKocsmaban != true) {
            System.out.println(this.nev + " nincs a kocsmában, nem tud inni! :(");
        } else {
            kocsmaros.setPenz(ital.getAr());
            this.reszegseg += ital.getAlkoholtartalom();
            System.out.println(this.nev + " lehajtott egy kupicával. Részegség: " + reszegseg);
            if (this.reszegseg > RESZEGSEG_KORLAT) {
                this.alszik();
            }
        }
    }

    @Override
    public String toString() {
        return "com.flowacademy.ember.Ember{" +
                "nev='" + nev + '\'' +
                ", kor=" + kor +
                ", nem=" + nem +
                '}';
    }
}
