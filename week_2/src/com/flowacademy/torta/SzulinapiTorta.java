package com.flowacademy.torta;

public class SzulinapiTorta extends Torta {
    private int gyertyakSzama = 0;

    public SzulinapiTorta(int szelet, String iz, int gyertyakSzama) {
        super(szelet, iz);
        this.gyertyakSzama = gyertyakSzama;
    }

    public void info() {
        System.out.println("Ez a torta "
                + super.iz + " íz, és "
                + super.szelet + " szeletes "
                + gyertyakSzama + " gyertyás torta.");
    }

    public void kivansagotTeljesit() {
        System.out.println("Boldog Szülinapot!");
    }
}
