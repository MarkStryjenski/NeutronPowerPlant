import java.util.ArrayList;

public class PowerPlant {
    private ArrayList<Core> buildInCores;
    private final Double maxAllowedHeat;
    private Double totalEnergyUnits;
    private Double totalHeatUnits;
    private Double totalSteamUnits;

    public PowerPlant(ArrayList<Core> buildInCores, Double maxAllowedHeat) {
        this.buildInCores = buildInCores;
        this.maxAllowedHeat = maxAllowedHeat;
    }

    public void explodePowerPlant(){

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
}
