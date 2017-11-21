package com.flowacademy.strategy;

public class Main {
    public static void main(String[] args) {

        ITravelStrategy bus = new Metro();
        Client otto = new Client("Ottó",100,100,100, bus);
        otto.travelClient();
    }
}
