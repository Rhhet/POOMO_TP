package fantaisie_TP3.protagoniste;


public class Heros extends Homme {

    private static final int PV = 100;

    public Heros(String nom) {
        super(nom);
        this.setForceDeVie(PV);
    }

    @Override
    public String toString() {
        return getNom() + " (PV: " + getForceDeVie() + ")";
    }
}