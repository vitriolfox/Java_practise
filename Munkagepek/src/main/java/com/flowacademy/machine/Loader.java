package com.flowacademy.machine;

import java.io.Serializable;

public class Loader extends Machinery implements Serializable {

    private int loadingWeight;

    public Loader(int weight, String type, int loadingWeight) {
        super(weight, type);
        this.loadingWeight = loadingWeight;
    }

    public double load(int sandWeightToLoad, int kmToTransport, Truck truckToLoad) {

        double transportTime = 0;
        double transportingSubTime = 0;
        int transportCycles = 0;
        int loadingTime = 0;
        int loadingSubTime;

        if (truckToLoad.type.equals(this.type)) {
            loadingSubTime = 5;
        } else {
            loadingSubTime = 6;
        }


        while (sandWeightToLoad > 0) {

            if (truckToLoad.loadedWeight < truckToLoad.capacity) {

                if (this.loadingWeight > sandWeightToLoad) {
                    truckToLoad.loadedWeight += sandWeightToLoad;
                    sandWeightToLoad = 0;
                    loadingTime += loadingSubTime;

                    try {
                        transportingSubTime = 0;
                        transportingSubTime = transportTime += truckToLoad.transport(kmToTransport);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    transportTime += transportingSubTime;
                    transportCycles++;

                } else {
                    sandWeightToLoad -= this.loadingWeight;
                    truckToLoad.loadedWeight += this.loadingWeight;
                    loadingTime += loadingSubTime;
                }
            }

            if (truckToLoad.loadedWeight >= truckToLoad.capacity) {

                try {
                    transportingSubTime = 0;
                    transportingSubTime = transportTime += truckToLoad.transport(kmToTransport);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                transportTime += transportingSubTime;
                transportCycles++;

            }


        }
        return (transportTime * transportCycles) + loadingTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loader loader = (Loader) o;

        return loadingWeight == loader.loadingWeight;
    }

    @Override
    public int hashCode() {
        return loadingWeight;
    }

    @Override
    public String toString() {
        return "Loader: " +
                "loadingWeight: " + loadingWeight +
                super.toString();
    }
}

