package com.Decorator.Upgrades;

import com.Alarm.AlarmSystem;
import com.Alarm.state.State;
import com.Core;
import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;
import com.EnergyPackage;
import com.Materials.Material;
import com.Materials.NeutronParticle;

public class CoreUpgrade1 extends FactoryDecorator {

    public CoreUpgrade1(EnergyFactory energyFactory) {
        super(energyFactory);
    }

    @Override
    public EnergyPackage harvestEnergy(int amount, Core core) {
        Material inputMaterial = core.getInputMaterial();
        if(core.getInputMaterial() instanceof NeutronParticle || inputMaterial instanceof com.Materials.ProtonParticle){
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
    public void toWarning() {

    }

    @Override
    public void setTotalUnits(EnergyPackage energyPackage)
    {
        energyFactory.setTotalUnits(energyPackage);
    }

    @Override
    public void setCore(Core core)
    {
        energyFactory.setCore(core);
    }

    @Override
    public Core getCore()
    {
        return energyFactory.getCore();
    }

    @Override
    public AlarmSystem getAlarmSystem()
    {
        return null;
    }

    @Override
    public void update(String eventType, State state)
    {

    }
}
