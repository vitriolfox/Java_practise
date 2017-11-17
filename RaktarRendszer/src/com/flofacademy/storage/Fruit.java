package com.flofacademy.storage;

import com.flofacademy.exceptions.BadQualityException;

import java.util.Random;

public class Fruit implements Ware {
    private String fruitName;
    private int badQualityRandom = (new Random().nextInt(6)+1);

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    @Override
    public boolean isGood() throws BadQualityException {
        int goodRandom = badQualityRandom;
        if (goodRandom == 3){
            throw new BadQualityException("Ez a gyümölcs megromlott, én nem venném meg...");
        } else if(goodRandom % 2 == 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Fruit;" +
                fruitName + ';';
    }
}
