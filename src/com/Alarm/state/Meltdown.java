package com.Alarm.state;

import com.Core;
import com.Decorator.EnergyFactory;
import com.EnergyPackage;
import com.PowerPlant;

public class Meltdown extends State {

    public Meltdown(EnergyFactory powerPlant) {
        super(powerPlant);
    }

    @Override
    public void onChangeState() {
        powerPlant.setPowerPlantState(new Meltdown(powerPlant));
    }

    @Override
    public void energyHarvest(int amount, EnergyFactory plant, Core core)
    {
        System.out.println("*KABOOOM* The attempt to produce energy in meltdown state causes the reactor to blow up!! *KABOOOM*");
        System.out.println("The app will now demonstrativly close to simulate what you just did");
        System.exit(0);
    }
}
