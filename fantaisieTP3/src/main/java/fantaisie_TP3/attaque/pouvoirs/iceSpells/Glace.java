package fantaisie_TP3.attaque.pouvoirs.iceSpells;
//package regrouping all classes inheriting form Glace


import fantaisie_TP3.attaque.pouvoirs.Pouvoir;

public abstract class Glace extends Pouvoir {

    public Glace(int pointDeDegat, String nom, int nbUtilisationPouvoirInitial) {
        super(pointDeDegat, nom, nbUtilisationPouvoirInitial);
    }
}