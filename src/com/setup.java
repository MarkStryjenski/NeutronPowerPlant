package com;

import com.Alarm.AlarmSystem;
import com.Alarm.state.State;
import com.Decorator.EnergyFactory;
import com.Decorator.Upgrades.CoreUpgrade1;
import com.Decorator.Upgrades.CoreUpgrade2;
import com.Decorator.Upgrades.EarlyWarningSystem;
import com.Materials.IonParticle;
import com.Materials.Material;
import com.Materials.NeutronParticle;
import com.Materials.ProtonParticle;

import java.util.ArrayList;

public class setup {
    public static EnergyFactory energyFactory = new EnergyFactory() {

        @Override
        public void harvestEnergyNew(int amount) {

        }

        @Override
        public void activateAlert() {

        }

        @Override
        public void setTotalUnits(EnergyPackage energyPackage)
        {

        }

        @Override
        public void setCore(Core core)
        {

        }

        @Override
        public ArrayList<Core> getCores()
        {
            return null;
        }

        @Override
        public AlarmSystem getAlarmSystem()
        {
            return null;
        }

        @Override
        public int getPlantLevel() {
            return 0;
        }

        @Override
        public void setPlantLevel(int newLevel) {

        }

        @Override
        public State getPowerPlantState() {
            return null;
        }

        @Override
        public void stateHasChanged(String eventType, State state) {

        }

        @Override
        public void setPowerPlantState(State newState) {

        }

        @Override
        public double getTotalHeatUnits() {
            return 0;
        }

        @Override
        public double getTotalSteamUnits() {
            return 0;
        }

        @Override
        public int getWarningCount() {
            return 0;
        }

        @Override
        public void increaseWarningCount() {

        }
    };
    public static Material neutronParticle = new NeutronParticle();
    public static Material protonParticle = new ProtonParticle();
    public static Material ionParticle = new IonParticle();
    public static Core neutronCore = new Core(neutronParticle);
    public static Core protonCore = new Core(protonParticle);
    public static Core ionCore = new Core(ionParticle);
    public static AlarmSystem alarmSystem = new AlarmSystem("meltdown", "warning", "workingProperly");
    public static EnergyFactory basePowerPlant = new PowerPlant(21.0, energyFactory);

    public static void applyCoreUpgrade1()
    {
        basePowerPlant = new CoreUpgrade1(basePowerPlant);
    }

    public static void applyCoreUpgrade2()
    {
        basePowerPlant = new CoreUpgrade2(basePowerPlant);
    }

    public static void applyEarlyWarningSystem()
    {
        basePowerPlant = new EarlyWarningSystem(basePowerPlant, alarmSystem);
    }

    //getters setters
    public static EnergyFactory getEnergyFactory() {
        return energyFactory;
    }

    public static void setEnergyFactory(EnergyFactory energyFactory) {
        energyFactory = energyFactory;
    }

    public static Material getNeutronParticle() {
        return neutronParticle;
    }

    public static void setNeutronParticle(Material neutronParticle) {
        neutronParticle = neutronParticle;
    }

    public static Material getProtonParticle() {
        return protonParticle;
    }

    public static void setProtonParticle(Material protonParticle) {
        protonParticle = protonParticle;
    }

    public static Material getIonParticle() {
        return ionParticle;
    }

    public static void setIonParticle(Material ionParticle) {
        ionParticle = ionParticle;
    }

    public static Core getNeutronCore() {
        return neutronCore;
    }

    public static void setNeutronCore(Core neutronCore) {
        neutronCore = neutronCore;
    }

    public static Core getProtonCore() {
        return protonCore;
    }

    public static void setProtonCore(Core protonCore) {
        protonCore = protonCore;
    }

    public static Core getIonCore() {
        return ionCore;
    }

    public static void setIonCore(Core ionCore) {
        ionCore = ionCore;
    }

    public static AlarmSystem getAlarmSystem() {
        return alarmSystem;
    }

    public static void setAlarmSystem(AlarmSystem alarmSystem) {
        alarmSystem = alarmSystem;
    }

    public static EnergyFactory getBasePowerPlant() {
        return basePowerPlant;
    }

    public static void setBasePowerPlant(EnergyFactory basePowerPlant) {
        basePowerPlant = basePowerPlant;
    }
}

