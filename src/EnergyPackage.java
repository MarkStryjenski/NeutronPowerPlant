import com.Decorator.EnergyFactory;

public class EnergyPackage {
    private Double energyUnits;
    private Double heatUnits;
    private Double steamUnits;
    private EnergyFactory eng;

    public EnergyPackage(Double energyUnits, Double heatUnits, Double steamUnits) {
        this.energyUnits = energyUnits;
        this.heatUnits = heatUnits;
        this.steamUnits = steamUnits;
    }
}
