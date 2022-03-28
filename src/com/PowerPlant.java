package com;

import com.Alarm.AlarmSystem;
import com.Alarm.state.*;
import com.Decorator.EnergyFactory;

import java.util.ArrayList;

public class PowerPlant implements EnergyFactory {
    private ArrayList<Core> buildInCores;
    private final Double maxAllowedHeat;
    private Double totalEnergyUnits;
    private Double totalHeatUnits;
    private Double totalSteamUnits;
    private EnergyFactory energyFactory;
    private Meltdown meltdown;
    private SystemState systemState;

    public AlarmSystem alarms;

    public PowerPlant(ArrayList<Core> buildInCores, Double maxAllowedHeat,EnergyFactory energyFactory) {
        this.buildInCores = buildInCores;
        this.maxAllowedHeat = maxAllowedHeat;
        this.energyFactory = energyFactory;
        this.systemState = new SystemState();
        this.meltdown = new Meltdown(systemState);

        this.alarms = new AlarmSystem("working", "meltdown", "warning");
    }

    public void toMeltdown() {
        this.systemState.changeState(this.meltdown);
        alarms.notify("meltdown", this.meltdown);
    }

    public ArrayList<Core> getBuildInCores() {
        return buildInCores;
    }

    public void setBuildInCores(ArrayList<Core> buildInCores) {
        this.buildInCores = buildInCores;
    }

    public Double getMaxAllowedHeat() {
        return maxAllowedHeat;
    }

    public Double getTotalEnergyUnits() {
        return totalEnergyUnits;
    }

    public void setTotalEnergyUnits(Double totalEnergyUnits) {
        this.totalEnergyUnits = totalEnergyUnits;
    }

    public Double getTotalHeatUnits() {
        return totalHeatUnits;
    }

    public void setTotalHeatUnits(Double totalHeatUnits) {
        this.totalHeatUnits = totalHeatUnits;
    }

    public Double getTotalSteamUnits() {
        return totalSteamUnits;
    }

    public void setTotalSteamUnits(Double totalSteamUnits) {
        this.totalSteamUnits = totalSteamUnits;
    }

    public EnergyFactory getEnergyFactory() {
        return energyFactory;
    }

    public void setEnergyFactory(EnergyFactory energyFactory) {
        this.energyFactory = energyFactory;
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
    public boolean explodePowerPlant()
    {
        return false;
    }
}
