import com.Alarm.AlarmListener;
import com.Alarm.AlarmSystem;
import com.Alarm.state.*;
import com.Decorator.EnergyFactory;

import java.util.ArrayList;

public class PowerPlant implements EnergyFactory, AlarmListener {
    private ArrayList<Core> buildInCores;
    private final Double maxAllowedHeat;
    private final SystemState systemState;
    private final Meltdown meltdown;
    private Double totalEnergyUnits;
    private Double totalHeatUnits;
    private Double totalSteamUnits;
    private EnergyFactory energyFactory;
    public AlarmSystem alarmSystem;

    public PowerPlant(ArrayList<Core> buildInCores, Double maxAllowedHeat,EnergyFactory energyFactory, AlarmSystem alarmSystem) {
        this.buildInCores = buildInCores;
        this.maxAllowedHeat = maxAllowedHeat;
        this.energyFactory = energyFactory;
        this.alarmSystem = alarmSystem;
        this.totalEnergyUnits = 0.0;
        this.totalHeatUnits = 0.0;
        this.totalSteamUnits = 0.0;
        this.systemState = new SystemState();
        this.meltdown = new Meltdown(systemState);
    }

    public void setTotalUnits(EnergyPackage energyPackage) {
        this.setTotalEnergyUnits(this.getTotalEnergyUnits() + energyPackage.getEnergyUnits());
        this.setTotalHeatUnits(this.getTotalEnergyUnits() + energyPackage.getHeatUnits());
        this.setTotalSteamUnits(this.getTotalSteamUnits() + energyPackage.getSteamUnits());

        if(this.getTotalHeatUnits() > 2000.0 || this.getTotalSteamUnits() > 1500.0) {
            this.toMeltdown();
        }

    }

    public void toMeltdown() {
        this.systemState.changeState(this.meltdown);
        alarmSystem.notify("meltdown", this.meltdown);
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

    @Override
    public void update(String eventType, State state) {
        System.out.println("Alarm triggered! " + "Event type: " + eventType + ", State: " + state);
    }
}
