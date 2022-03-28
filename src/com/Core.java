package com;

import com.Materials.Material;
import com.Materials.NeutronParticle;

public class Core {
    private Material inputMaterial;
    private final int maximumCapacity;

    public Core(Material inputMaterial) {
        this.inputMaterial = inputMaterial;
        this.maximumCapacity = 3000;
    }

    public EnergyPackage harvestEnergy(int amount, Core core){
        if(core.getInputMaterial() instanceof NeutronParticle){
            if(amount <= maximumCapacity){
                double heatUnits = (double) Math.round((amount * inputMaterial.getHeatPerUnit()*100)/100);
                double steamUnits = (double) Math.round((amount * inputMaterial.getSteamPerUnit()*100)/100);
                double energyUnits = (double) Math.round((amount * inputMaterial.getEnergyPerUnit())*100)/100;
                System.out.println("Created heatUnits: "+heatUnits+" steamUnits: "+steamUnits+" energyUnits: "+energyUnits);
                return new EnergyPackage(energyUnits, heatUnits, steamUnits);
            }else{
                System.out.println("You have put more than max capacity allows");
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
