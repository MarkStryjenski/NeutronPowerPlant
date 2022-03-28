package com.Materials;

public abstract class Material {
    protected Double energyPerUnit;
    protected Double heatPerUnit;
    protected Double steamPerUnit;

    //getters setters
    public Double getEnergyPerUnit()
    {
        return energyPerUnit;
    }

    public void setEnergyPerUnit(Double energyPerUnit)
    {
        this.energyPerUnit = energyPerUnit;
    }

    public Double getHeatPerUnit()
    {
        return heatPerUnit;
    }

    public void setHeatPerUnit(Double heatPerUnit)
    {
        this.heatPerUnit = heatPerUnit;
    }

    public Double getSteamPerUnit()
    {
        return steamPerUnit;
    }

    public void setSteamPerUnit(Double steamPerUnit)
    {
        this.steamPerUnit = steamPerUnit;
    }
}
