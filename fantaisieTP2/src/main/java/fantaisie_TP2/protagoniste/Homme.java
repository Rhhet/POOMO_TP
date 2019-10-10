package fantaisie_TP2.protagoniste;

import fantaisie_TP2.bataille.Bataille;



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

    public void mourir() {
        bataille.eliminer(this);
    }

    @Override
    public String toString() {
        return getNom() + " (PV: " + forceDeVie + ")";
    }
}