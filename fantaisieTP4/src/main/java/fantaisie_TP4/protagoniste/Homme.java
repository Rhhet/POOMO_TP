package fantaisie_TP4.protagoniste;

import fantaisie_TP4.bataille.Bataille;


public class Homme extends EtreVivant {

    private static final int PV = 70;
    
    public Homme(String nom) {
        super(nom, PV);
    }

    @Override
    public void rejoindBataille(Bataille bataille) {
        super.rejoindBataille(bataille);    //equiv    this.bataille = bataille;
        bataille.ajouter(this);
    }

    @Override
    public void mourir() {
        Bataille bataille = getBataille();
        bataille.eliminer(this);
    }

    @Override
    public String toString() {
        return getNom() + " (PV: " + getForceDeVie() + ")";
    }
}