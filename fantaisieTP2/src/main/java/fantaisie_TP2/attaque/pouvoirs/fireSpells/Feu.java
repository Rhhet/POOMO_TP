package fantaisie_TP2.attaque.pouvoirs.fireSpells;
//package regrouping all classes inheriting from Feu



import fantaisie_TP2.attaque.pouvoirs.Pouvoir;

public abstract class Feu extends Pouvoir {

    public Feu(int pointDeDegat, String nom, int nbUtilisationPouvoirInitial) {
        super(pointDeDegat, nom, nbUtilisationPouvoirInitial);
    }
}