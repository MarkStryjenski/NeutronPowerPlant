package com.Materials;

public abstract class Material {
    protected Double energyPerUnit;
    protected Double heatPerUnit;
    protected Double steamPerUnit;

    public Material(Double energyPerUnit,Double heatPerUnit,Double steamPerUnit){
        this.energyPerUnit=energyPerUnit;
        this.heatPerUnit=heatPerUnit;
        this.steamPerUnit=steamPerUnit;
    }
}
