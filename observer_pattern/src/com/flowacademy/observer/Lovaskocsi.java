package com.flowacademy.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Lovaskocsi extends Observable {
    private List<Karakter> utasok;
    private String hol;

    public void ottVagyunk(String hun) {
        this.hol = hun;
        System.out.println("Möggyüttün " + hun + "-ba");
        setChanged();
        notifyObservers(hun);
    }

    public Lovaskocsi() {this.utasok = new ArrayList<Karakter>();}

    public Lovaskocsi(List<Karakter> utasok) {
        this.utasok = utasok;
    }

    public void beszall(Karakter karakter){
        utasok.add(karakter);
        addObserver(karakter);
    }

    public void kiszall(Karakter karakter){
        utasok.remove(karakter);
        deleteObserver(karakter);
        System.out.println(karakter + " kiszállt " + hol + "-ban");
    }
}
