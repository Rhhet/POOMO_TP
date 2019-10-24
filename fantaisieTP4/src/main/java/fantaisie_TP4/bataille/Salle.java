package fantaisie_TP4.bataille;

import fantaisie_TP4.protagoniste.ZoneDeCombat;

public class Salle {
    private int numSalle;
    private ZoneDeCombat zdc;

    public Salle(int numSalle, ZoneDeCombat zdc) {
        this.numSalle = numSalle;
        this.zdc = zdc;
    }

    public int getNumeroSalle() {
        return numSalle;
    }

    public ZoneDeCombat getZDC() {
        return zdc;
    }

    @Override
    public String toString() {
        return "Salle num " + numSalle + " de type " + zdc + ".";
    }
}