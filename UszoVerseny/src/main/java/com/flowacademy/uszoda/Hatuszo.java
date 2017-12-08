package com.flowacademy.uszoda;

import com.flowacademy.uszoda.exceptions.UszikException;
import com.flowacademy.uszoda.exceptions.VersenyezException;

public class Hatuszo extends Uszo implements Versenyzo, Comparable {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public Hatuszo(String nev, int teljesitmeny, String nemzetiseg) {
        super(nev, teljesitmeny, nemzetiseg);
    }

    @Override
    public double uszik() throws UszikException {
        double uszoEredmeny = (this.teljesitmeny *1.1)*Math.random();
        if (uszoEredmeny>0){
            return uszoEredmeny;
        } else {
            throw new UszikException("JUJJUJ " + this.nev + " elfelejtett úszni, valaki mentse ki!");
        }
    }

    @Override
    public double versenyez(int versenytav){
        double versenyezResult = 0;
        if (versenytav%50 != 0){
            System.out.println("Rosszul megadott úszástáv " + this.nev + " úszónál!");
        } else {
            try {
                versenyezResult = ((uszik()*versenytav/10)+(versenytav/50)*2);
            } catch (UszikException e) {
                e.printStackTrace();
            }
        }
        return versenyezResult;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Hátúszó bogyóka.";

    }

    @Override
    public int compareTo(Object o) {
        Hatuszo hatuszo1 = (Hatuszo) o;
        if (((Hatuszo) o).teljesitmeny > this.teljesitmeny){
            return 1;
        } else if (((Hatuszo) o).teljesitmeny < this.teljesitmeny) {
            return -1;
        } else  {
            return 0;
        }
    }
}
