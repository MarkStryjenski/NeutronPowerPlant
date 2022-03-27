package com.Materials;

public class IonParticle extends Material {


    public IonParticle(Double energyPerUnit, Double heatPerUnit, Double steamPerUnit) {
        this.energyPerUnit = energyPerUnit;
        this.heatPerUnit = heatPerUnit;
        this.steamPerUnit = steamPerUnit;
    }

    public void test(){
        Double testVar = 0.2;
        System.out.println(testVar + this.energyPerUnit);

    }
}
