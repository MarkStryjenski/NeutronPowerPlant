package com.Alarm.state;

import com.Core;
import com.Decorator.EnergyFactory;
import com.Decorator.Upgrades.EarlyWarningSystem;
import com.EnergyPackage;
import com.PowerPlant;

public class Warning extends State {

    public Warning(EnergyFactory powerPlant) { super(powerPlant); }

    @Override
    public void onChangeState() {
        powerPlant.setPowerPlantState(new Warning(powerPlant));
    }

    @Override
    public void energyHarvest(int amount, EnergyFactory plant, Core core)
    {
        //harvest energy
        EnergyPackage output = core.harvestEnergy(amount, core);
        if(output != null) {
            //set total units of plant
            plant.setTotalUnits(output);
            //check if state change is required.
            if ((plant.getTotalHeatUnits() > 2000.0 || plant.getTotalSteamUnits() > 1500.0) && plant.getWarningCount() > 1) {
                State newState = new Meltdown(plant);
                plant.setPowerPlantState(newState);
                System.out.println("Too much steam or heat produced, plant enters meltdown state!");
                this.notifyStateChange("meltdown", newState);
            }
        } else {
            System.out.println("The maximum capacity has been met. Invalid input.");
        }
        plant.increaseWarningCount();
    }

}
