package com.flowacademy.kedvencek;

import com.flowacademy.exeptions.HaziallatExeptions;

public class Kutya extends Haziallat{
    protected String nev;

    public Kutya(String nev) {
        this.nev = nev;
        this.jokedv = 5;
        this.ehseg = 5;
    }

    @Override
    public void simogat() throws HaziallatExeptions {
        this.jokedv ++;
    }

    @Override
    public void megetet() throws HaziallatExeptions {
        this.ehseg --;
        if (this.ehseg < 0){
            throw new HaziallatExeptions("Már nagyon éhes ez az állatka!");
        }
    }

    public void setaltat() {
        this.jokedv +=2;
        this.ehseg +=1;
    }

    @Override
    public String toString() {
        String boldogsagText;
        if (this.boldogsag) {
            boldogsagText = "BOLDOG";
        } else {
            boldogsagText = "";
        }
        return nev + " egy " + boldogsag + " kutya" +
                ", éhség: " + ehseg +
                ", jókedv: " + jokedv;
    }
}
