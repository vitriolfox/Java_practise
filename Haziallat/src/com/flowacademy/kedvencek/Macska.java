package com.flowacademy.kedvencek;

import com.flowacademy.exeptions.HaziallatExeptions;

public class Macska extends Haziallat{
    protected String nev;


    public Macska(String nev) {
        this.nev = nev;
        this.ehseg = 5;
        this.jokedv = 5;
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

    public void dorombol() throws HaziallatExeptions{
        this.ehseg ++;
        this.jokedv -= 2;

        if (this.jokedv < 0) {
            throw new HaziallatExeptions("A macskának rossz a kedve!");
        }
    }

    @Override
    public String toString() {
        String boldogsagText;
        if (this.boldogsag) {
            boldogsagText = "BOLDOG";
        } else {
            boldogsagText = "";
        }
        return nev + " egy " + boldogsag + " macska" +
                ", éhség: " + ehseg +
                ", jókedv: " + jokedv;
    }
}
