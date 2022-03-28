package com.Decorator;

public interface EnergyFactory {
    default Double produceEnergy(){
        System.out.println("produce energy interface default");
        return 1.0;
    }
    default void activateAlert(){
        System.out.println("activate alert defulat interface");
    }
    //void activateAlert();
    void storeEnergy();
    void sllStoredEnergy();
    void checkState();
    void checkTemperature();
    void releasePressure();
    void increaseProduction();
    boolean explodePowerPlant();
}
