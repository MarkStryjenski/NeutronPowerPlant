package com.Materials;

public class ProtonParticle extends Material {

    public ProtonParticle(Double energyPerUnit, Double heatPerUnit, Double steamPerUnit) {
        this.energyPerUnit = energyPerUnit;
        this.heatPerUnit = heatPerUnit;
        this.steamPerUnit = heatPerUnit;
    }
}
