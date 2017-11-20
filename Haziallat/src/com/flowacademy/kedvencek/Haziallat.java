package com.flowacademy.kedvencek;

import com.flowacademy.exeptions.HaziallatExeptions;

public abstract class Haziallat {
    protected int ehseg;
    protected int jokedv;
    protected boolean boldogsag;

    public boolean isBoldogsag() {
        return boldogsag;
    }

    public boolean setBoldogsag(){
        if (this.ehseg < 4 && this.jokedv > 8) {
            return boldogsag = true;
        } else {
            return boldogsag = false;
        }
    }

    public abstract void simogat() throws HaziallatExeptions;
    public abstract void megetet() throws HaziallatExeptions;
}
