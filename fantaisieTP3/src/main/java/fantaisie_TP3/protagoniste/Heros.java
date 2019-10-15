package fantaisie_TP3.protagoniste;



public class Heros extends Homme {

    private static final int PV = 100;

    public Heros(String nom) {
        super(nom);
        this.forceDeVie = PV;
    }

    @Override
    public String toString() {
        return getNom() + " (PV: " + forceDeVie + ")";
    }
}