package com.Decorator.Upgrades;

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
        return null;
    }

    @Override
    public void activateAlert() {

    }

    @Override
    public void storeEnergy()
    {

    }

    @Override
    public void sllStoredEnergy()
    {

    }

    @Override
    public void checkState()
    {

    }

    @Override
    public void checkTemperature()
    {

    }

    @Override
    public void releasePressure()
    {

    }

    @Override
    public void increaseProduction()
    {

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

    }

    public boolean isBonusLiveUsed() {
        return bonusLiveUsed;
    }

    public void setBonusLiveUsed(boolean bonusLiveUsed) {
        this.bonusLiveUsed = bonusLiveUsed;
    }
}
