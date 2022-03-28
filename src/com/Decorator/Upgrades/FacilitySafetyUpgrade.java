package com.Decorator.Upgrades;

import com.Alarm.AlarmSystem;
import com.Alarm.state.State;
import com.Core;
import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;
import com.EnergyPackage;

public class FacilitySafetyUpgrade extends FactoryDecorator {

    private boolean bonusLiveUsed;

    public FacilitySafetyUpgrade(EnergyFactory energyFactory) {
        super(energyFactory);
        this.bonusLiveUsed=false;
    }

    /**
     * Give player another chance when the power plant breaks
     */
    public void advancedFireExtinguisherSystem(){

    }

    @Override
    public EnergyPackage harvestEnergy(int amount, Core core)
    {
        return energyFactory.harvestEnergy(amount, core);
    }

    @Override
    public void activateAlert() {
        energyFactory.activateAlert();
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
    public boolean explodePowerPlant(){
//        if(!this.bonusLiveUsed){
//            this.bonusLiveUsed=true;
            return false;
//        }
//        return true;
    }

    @Override
    public void toWarning() {
        energyFactory.toWarning();
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
        return energyFactory.getAlarmSystem();
    }

    public boolean isBonusLiveUsed() {
        return bonusLiveUsed;
    }

    public void setBonusLiveUsed(boolean bonusLiveUsed) {
        this.bonusLiveUsed = bonusLiveUsed;
    }

    @Override
    public void update(String eventType, State state)
    {
        energyFactory.update(eventType, state);
    }
}
