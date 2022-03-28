package com.Decorator.Upgrades;

import com.Core;
import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;
import com.EnergyPackage;
import com.Materials.Material;
import com.Materials.NeutronParticle;

public class CoreUpgrade1 extends FactoryDecorator {

//    private EnergyFactory energyFactory;
    public CoreUpgrade1(EnergyFactory energyFactory) {
        super(energyFactory);
    }

    @Override
    public EnergyPackage harvestEnergy(int amount, Core core) {
        Material inputMaterial = core.getInputMaterial();
        if(inputMaterial instanceof NeutronParticle || inputMaterial instanceof com.Materials.ProtonParticle){
            if(amount <= core.getMaximumCapacity()){
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

    @Override
    public void activateAlert() {

    }

    @Override
    public void storeEnergy()
    {
        energyFactory.storeEnergy();
    }

    @Override
    public void sllStoredEnergy()
    {
        energyFactory.sllStoredEnergy();
    }

    @Override
    public void checkState()
    {
        energyFactory.checkState();
    }

    @Override
    public void checkTemperature()
    {
        energyFactory.checkTemperature();
    }

    @Override
    public void releasePressure()
    {
        energyFactory.releasePressure();
    }

    @Override
    public void increaseProduction()
    {
        energyFactory.increaseProduction();
    }

    @Override
    public boolean explodePowerPlant()
    {
        return false;
    }

    @Override
    public void toWarning() {

    }

    public EnergyFactory getEnergyFactory() {
        return energyFactory;
    }

    public void setEnergyFactory(EnergyFactory energyFactory) {
        this.energyFactory = energyFactory;
    }
}
