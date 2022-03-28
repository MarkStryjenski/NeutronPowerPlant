package com;

public class EnergyPackage {
    private double energyUnits;
    private double heatUnits;
    private double steamUnits;

    public EnergyPackage(double energyUnits, double heatUnits, double steamUnits) {
        this.energyUnits = energyUnits;
        this.heatUnits = heatUnits;
        this.steamUnits = steamUnits;
    }

    public double getEnergyUnits()
    {
        return energyUnits;
    }

    public void setEnergyUnits(Double energyUnits)
    {
        this.energyUnits = energyUnits;
    }

    public double getHeatUnits()
    {
        return heatUnits;
    }

    public void setHeatUnits(Double heatUnits)
    {
        this.heatUnits = heatUnits;
    }

    public double getSteamUnits()
    {
        return steamUnits;
    }

    public void setSteamUnits(Double steamUnits)
    {
        this.steamUnits = steamUnits;
    }
}
