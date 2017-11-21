package com.flowacademy.strategy;

public abstract class TomegKozlekedes implements ITravelStrategy {

    protected abstract void utazas();

    @Override
    public void travel(Client client) {
        System.out.println("Felszállás");
        System.out.println("Jegyellenőrzés");

        //metódus
        utazas();

        System.out.println("Leszállás");
    }
}
