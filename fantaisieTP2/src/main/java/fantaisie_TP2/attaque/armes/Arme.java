package fantaisie_TP2.attaque.armes;
//package regrouping all classes inheriting from Arme


/* Les constructeurs des classes héritées d'Arme set operationnel
à true dès qu'elles sont intanciées (logique) sauf Arc car dépend
du nb de flèches données  */

import fantaisie_TP2.attaque.ForceDeCombat;

public abstract class Arme extends ForceDeCombat {
    
    public Arme(int pointDeDegat, String nom) {
        super(pointDeDegat, nom);
    }
}