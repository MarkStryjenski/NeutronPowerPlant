package com;

import com.Alarm.AlarmSystem;
import com.Alarm.state.*;
import com.Decorator.EnergyFactory;
import com.Materials.NeutronParticle;
import java.util.ArrayList;

public class PowerPlant implements EnergyFactory {
    private Double maxAllowedHeat;
    private Meltdown meltdown;
    private Double totalEnergyUnits;
    private Double totalHeatUnits;
    private Double totalSteamUnits;
    private EnergyFactory energyFactory;
    private AlarmSystem alarmSystem;
    private int warningCount;
    private int plantLevel;
    private ArrayList<Core> builtInCores;
    private State powerPlantState;

    public PowerPlant(Double maxAllowedHeat,EnergyFactory energyFactory) {
        this.maxAllowedHeat = maxAllowedHeat;
        this.energyFactory = energyFactory;
        this.alarmSystem = new AlarmSystem("meltdown", "warning", "workingProperly");
        this.totalEnergyUnits = 0.0;
        this.totalHeatUnits = 0.0;
        this.totalSteamUnits = 0.0;
        this.warningCount = 0;
        this.plantLevel = 0;
        this.builtInCores = new ArrayList<>();
        this.powerPlantState = new WorkingProperly(this);
    }

    @Override
    public void stateHasChanged(String eventType, State state)
    {
        this.alarmSystem.notify(eventType, state);
    }

    public Double getTotalEnergyUnits() {
        return totalEnergyUnits;
    }

    public void setTotalEnergyUnits(Double totalEnergyUnits) {
        this.totalEnergyUnits = totalEnergyUnits;
    }

    @Override
    public double getTotalHeatUnits() {
        return totalHeatUnits;
    }

    public void setTotalHeatUnits(Double totalHeatUnits) {
        this.totalHeatUnits = totalHeatUnits;
    }

    @Override
    public double getTotalSteamUnits() {
        return totalSteamUnits;
    }

    public void setTotalSteamUnits(Double totalSteamUnits) {
        this.totalSteamUnits = totalSteamUnits;
    }

    public ArrayList<Core> getBuildInCores()
    {
        return this.builtInCores;
    }

    //when harvest energy new is called, it runs through all cores and executes harvest energy for the amount on each
    @Override
    public void harvestEnergyNew(int amount)
    {
        if(this.getCores().get(0).getInputMaterial() instanceof NeutronParticle)
        {
            int counter = 1;
            for (Core builtInCore : this.getCores())
            {
                System.out.println("Core number " + counter + " produced: ");
                this.getPowerPlantState().energyHarvest(amount,  this, builtInCore);
                counter++;
            }
        } else {
            System.out.println("The input material is not compatible with the core upgrade");
        }
    }

    @Override
    public void setTotalUnits(EnergyPackage energyPackage)
    {
        this.setTotalEnergyUnits(this.getTotalEnergyUnits() + energyPackage.getEnergyUnits());
        this.setTotalHeatUnits(this.getTotalEnergyUnits() + energyPackage.getHeatUnits());
        this.setTotalSteamUnits(this.getTotalSteamUnits() + energyPackage.getSteamUnits());
    }

    @Override
    public void setCore(Core core)
    {
        this.builtInCores.clear();
        for(int i = 0; i <= this.plantLevel; i++)
        {
            this.builtInCores.add(new Core(core.getInputMaterial()));
        }
    }

    @Override
    public ArrayList<Core> getCores()
    {
        return this.getBuildInCores();
    }

    @Override
    public AlarmSystem getAlarmSystem()
    {
        return null;
    }

    @Override
    public int getPlantLevel() {
        return this.plantLevel;
    }

    @Override
    public void setPlantLevel(int newLevel) {
        this.plantLevel = newLevel;
    }

    @Override
    public int getWarningCount() {
        return warningCount;
    }

    @Override
    public void increaseWarningCount() {
        this.warningCount++;
    }

    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }

    //state getter and setter
    @Override
    public State getPowerPlantState() {
        return powerPlantState;
    }

    @Override
    public void setPowerPlantState(State powerPlantState) {
        this.powerPlantState = powerPlantState;
    }

    public void addCoreToCores(Core core)
    {
        this.builtInCores.add(core);
    }

    public void removeCoreByObject(Core core)
    {
        this.builtInCores.remove(core);
    }
}
