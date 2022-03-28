package com.Decorator.Upgrades;

import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;

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
    public boolean explodePowerPlant(){
//        if(!this.bonusLiveUsed){
//            this.bonusLiveUsed=true;
            return false;
//        }
//        return true;
    }

    public boolean isBonusLiveUsed() {
        return bonusLiveUsed;
    }

    public void setBonusLiveUsed(boolean bonusLiveUsed) {
        this.bonusLiveUsed = bonusLiveUsed;
    }
}
