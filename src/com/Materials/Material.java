package com.Materials;

public abstract class Material {
    protected Double energyPerUnit;
    protected Double heatPerUnit;
    protected Double steamPerUnit;

    //getters setters
    protected Double getEnergyPerUnit()
    {
        return energyPerUnit;
    }

    protected void setEnergyPerUnit(Double energyPerUnit)
    {
        this.energyPerUnit = energyPerUnit;
    }

    protected Double getHeatPerUnit()
    {
        return heatPerUnit;
    }

    protected void setHeatPerUnit(Double heatPerUnit)
    {
        this.heatPerUnit = heatPerUnit;
    }

    protected Double getSteamPerUnit()
    {
        return steamPerUnit;
    }

    protected void setSteamPerUnit(Double steamPerUnit)
    {
        this.steamPerUnit = steamPerUnit;
    }
}
