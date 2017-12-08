package com.flowacademy.uszoda;

import com.flowacademy.uszoda.exceptions.UszikException;

import java.util.Comparator;

public class Gyorsuszo extends Uszo implements Versenyzo, Comparable{

    public Gyorsuszo(String nev, int teljesitmeny, String nemzetiseg) {
        super(nev, teljesitmeny, nemzetiseg);
    }

    public Gyorsuszo() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public double uszik() throws UszikException {
        double uszoEredmeny = (this.teljesitmeny *1.3)*Math.random();
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
                versenyezResult = ((uszik()*versenytav/10)+((versenytav/50)*2))+1.5;
            } catch (UszikException e) {
                e.printStackTrace();
            }
        }
        return versenyezResult;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Gyorsúszó bogyóka.";
    }

    @Override
    public int compareTo(Object o) {
        Gyorsuszo gyorsuszo1 = (Gyorsuszo) o;
        if (((Gyorsuszo) o).teljesitmeny > this.teljesitmeny){
            return 1;
        } else if (((Gyorsuszo) o).teljesitmeny < this.teljesitmeny) {
            return -1;
        } else  {
            return 0;
        }
    }
}
