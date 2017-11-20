package com.flowacademy.strategy;

public class Bus implements ITravelStrategy {

    @Override
    public void travel(Client client) {
        client.setMoney(client.getMoney()-2);
        client.setMentalHealth(client.getMentalHealth()-5);
        client.setTime(client.getTime()-3);
    }
}
