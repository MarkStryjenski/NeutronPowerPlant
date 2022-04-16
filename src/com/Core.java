package com;

import com.Alarm.AlarmListener;
import com.Alarm.state.State;
import com.Materials.Material;
import com.Materials.NeutronParticle;

public class Core implements AlarmListener {
    private Material inputMaterial;
    private final int maximumCapacity;

    public Core(Material inputMaterial) {
        this.inputMaterial = inputMaterial;
        this.maximumCapacity = 3000;
    }

    public EnergyPackage harvestEnergy(int amount, Core core){
        if(amount <= maximumCapacity){
            double heatUnits = (double) Math.round((amount * inputMaterial.getHeatPerUnit()*100)/100);
            double steamUnits = (double) Math.round((amount * inputMaterial.getSteamPerUnit()*100)/100);
            double energyUnits = (double) Math.round((amount * inputMaterial.getEnergyPerUnit())*100)/100;
            System.out.println("Units of heat: "+heatUnits+" units of steam: "+steamUnits+" units of energy: "+energyUnits);
            return new EnergyPackage(energyUnits, heatUnits, steamUnits);
        }else{
            System.out.println("You have put more than max capacity allows");
            return null;
        }
    }

    public EnergyPackage harvestEnergyNew(int amount, State currentState){
        if(this.inputMaterial instanceof NeutronParticle){
            if(amount <= maximumCapacity){
                //currentState.energyHarvest(amount,this);
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

    @Override
    public void update(String eventType, State state) {
        System.out.println("Alarm triggered from object " + this.toString() + "! Event type: " + eventType + ", State: " + state);
    }
}
