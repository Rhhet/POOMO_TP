package fantaisie_TP3.attaque.pouvoirs.sharpSpells;
//package regrouping all classes inheriting form Tranchant


import fantaisie_TP3.attaque.pouvoirs.Pouvoir;

/* Pas de classe TranchantInfini implémentée: si un pouvoir peut être
    utilisé un nb infini de fois, alors nbUtilisationPouvoirInitial = -1
    et la methode utiliser() est overriden.    */
public abstract class Tranchant extends Pouvoir {

    public Tranchant(int pointDeDegat, String nom, int nbUtilisationPouvoirInitial) {
        super(pointDeDegat, nom, nbUtilisationPouvoirInitial);
    }
}
