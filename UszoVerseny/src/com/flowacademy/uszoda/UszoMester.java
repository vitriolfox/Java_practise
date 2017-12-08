package com.flowacademy.uszoda;

import com.flowacademy.uszoda.exceptions.UszikException;

import java.io.Serializable;
import java.util.Comparator;

public class UszoMester extends Uszo implements Comparable, Serializable {

    public UszoMester(String nev, int teljesitmeny, String nemzetiseg) {
        super(nev, teljesitmeny, nemzetiseg);
    }

    @Override
    public double uszik() throws UszikException {
        return this.teljesitmeny;
    }

    public void megment(Uszo uszo){
        System.out.println(this.nev + " megmentette a bajbajutott " + uszo.nev + "-t!");
    }

    @Override
    public String toString() {
        return super.toString() +
                " Úszómester bogyóka.";

    }

    @Override
    public int compareTo(Object o) {
        UszoMester uszoMester1 = (UszoMester) o;
        if (((UszoMester) o).teljesitmeny > this.teljesitmeny){
            return 1;
        } else if (((UszoMester) o).teljesitmeny < this.teljesitmeny) {
            return -1;
        } else  {
            return 0;
        }
    }
}
