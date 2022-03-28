package com;

import com.Materials.Material;

public class Core {
    private Material inputMaterial;
    private final int maximumCapacity;

    public Core(Material inputMaterial) {
        this.inputMaterial = inputMaterial;
        this.maximumCapacity = 100;
    }

    public EnergyPackage harvestEnergy(int amount){
        if(inputMaterial instanceof com.Materials.neutronParticle){
            if(amount <= maximumCapacity){
                double heatUnits = (double) Math.round((amount * inputMaterial.getHeatPerUnit()*100)/100);
                double steamUnits = (double) Math.round((amount * inputMaterial.getSteamPerUnit()*100)/100);
                double energyUnits = (double) Math.round((amount * inputMaterial.getEnergyPerUnit())*100)/100;
                return new EnergyPackage(energyUnits, heatUnits, steamUnits);
            }
            return null;
        }
        return null;
    }

    public Material getInputMaterial()
    {
        return inputMaterial;
    }

    public void setInputMaterial(Material inputMaterial)
    {
        this.inputMaterial = inputMaterial;
    }

    public int getMaximumCapacity()
    {
        return maximumCapacity;
    }
}
