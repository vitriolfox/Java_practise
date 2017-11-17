package com.flofacademy.storage;

import com.flofacademy.exceptions.BadQualityException;

public class DairyProduct implements Ware {
    private String dairyName;
    private long productionDate;
    private long bestBefore;

    public DairyProduct(String dairyName, long productionDate, long bestBefore) {
        this.dairyName = dairyName;
        this.productionDate = productionDate;
        this.bestBefore = bestBefore;
    }

    @Override
    public boolean isGood() throws BadQualityException {
        long currentSeconds = System.currentTimeMillis();
        if (bestBefore > (currentSeconds-productionDate)){
            return true;
        } else {
            throw new BadQualityException("A termék lejárt szavatossági idővel rendelkezik.");
        }

    }

    @Override
    public String toString() {
        return "DairyProduct;" +
                dairyName + ';' +
                productionDate + ';' +
                bestBefore + ';';
    }
}
