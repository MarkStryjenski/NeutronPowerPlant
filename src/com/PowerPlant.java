package com;

import com.Alarm.AlarmListener;

import com.Alarm.AlarmSystem;
import com.Alarm.state.*;
import com.Core;
import com.Decorator.EnergyFactory;
import com.EnergyPackage;

import java.util.ArrayList;

public class PowerPlant implements EnergyFactory, AlarmListener {
    private Core buildInCore;
    private final Double maxAllowedHeat;
    private SystemState systemState;
    private Meltdown meltdown;
    private Double totalEnergyUnits;
    private Double totalHeatUnits;
    private Double totalSteamUnits;
    private EnergyFactory energyFactory;
    public AlarmSystem alarmSystem;
    private int warningCount;

    public PowerPlant(Core core, Double maxAllowedHeat,EnergyFactory energyFactory, AlarmSystem alarmSystem) {
        this.buildInCore = core;
        this.maxAllowedHeat = maxAllowedHeat;
        this.energyFactory = energyFactory;
        this.alarmSystem = alarmSystem;
        this.totalEnergyUnits = 0.0;
        this.totalHeatUnits = 0.0;
        this.totalSteamUnits = 0.0;
        this.systemState = new SystemState();
        this.meltdown = new Meltdown(systemState);
        this.warningCount=0;
    }

//    public void setTotalUnits(EnergyPackage energyPackage) {
//        this.setTotalEnergyUnits(this.getTotalEnergyUnits() + energyPackage.getEnergyUnits());
//        this.setTotalHeatUnits(this.getTotalEnergyUnits() + energyPackage.getHeatUnits());
//        this.setTotalSteamUnits(this.getTotalSteamUnits() + energyPackage.getSteamUnits());
//
//        if(this.getTotalHeatUnits() > 2000.0 || this.getTotalSteamUnits() > 1500.0) {
//            this.toMeltdown();
//        }
//    }

    public void toMeltdown() {
        this.systemState.changeState(this.meltdown);
        alarmSystem.notify("meltdown", this.meltdown);
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

    public Core getBuildInCore()
    {
        return buildInCore;
    }

    public void setBuildInCore(Core buildInCore)
    {
        this.buildInCore = buildInCore;
    }

    public Meltdown getMeltdown()
    {
        return meltdown;
    }

    public void setMeltdown(Meltdown meltdown)
    {
        this.meltdown = meltdown;
    }

    public SystemState getSystemState()
    {
        return systemState;
    }

    public void setSystemState(SystemState systemState)
    {
        this.systemState = systemState;
    }

    //    public EnergyPackage harvestEnergy(int amount)
//    {
//        return null;
//    }

    @Override
    public EnergyPackage harvestEnergy(int amount, Core core)
    {
        return buildInCore.harvestEnergy(amount, core);
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

    @Override
    public void toWarning() {

    }

    @Override
    public void setTotalUnits(EnergyPackage energyPackage)
    {
        this.setTotalEnergyUnits(this.getTotalEnergyUnits() + energyPackage.getEnergyUnits());
        this.setTotalHeatUnits(this.getTotalEnergyUnits() + energyPackage.getHeatUnits());
        this.setTotalSteamUnits(this.getTotalSteamUnits() + energyPackage.getSteamUnits());

        if(this.getTotalHeatUnits() > 2000.0 || this.getTotalSteamUnits() > 1500.0) {
            this.toMeltdown();
        }
    }

    @Override
    public void setCore(Core core)
    {
        this.buildInCore = core;
    }

    @Override
    public Core getCore()
    {
        return this.getBuildInCore();
    }

    @Override
    public AlarmSystem getAlarmSystem()
    {
        return this.alarmSystem;
    }

    @Override
    public void update(String eventType, State state) {
        System.out.println("Alarm triggered! " + "Event type: " + eventType + ", State: " + state);
        if(eventType.equals("meltdown")){
            System.exit(0);
        }
        if(warningCount==2){
            System.out.println("Too many warnings, Reactor meltdown!!!");
            System.exit(0);
        }
        warningCount++;
    }
}
