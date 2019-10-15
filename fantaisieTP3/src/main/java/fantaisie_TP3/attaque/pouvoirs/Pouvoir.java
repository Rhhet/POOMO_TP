package fantaisie_TP3.attaque.pouvoirs;

import fantaisie_TP3.attaque.ForceDeCombat;


/*   Les constructeurs des pouvoirs ont comme argument nbUtilisationPouvoirInitial
    et pas nbUtilisationPouvoir, c'est logique...                  */


public abstract class Pouvoir extends ForceDeCombat {

    private int nbUtilisationPouvoir;
    private int nbUtilisationPouvoirInitial;
    

    /* la troisème var a été changé pour nbUtilisationPouvoirInitial
    contrairement à nbUtilisationPouvoir dans le sujet: cette dernière 
    ne peu pas servir à initialiser le pouvoir... */

    public Pouvoir(int pointDeDegat, String nom, int nbUtilisationPouvoirInitial) {
        super(pointDeDegat, nom);
        this.nbUtilisationPouvoirInitial = nbUtilisationPouvoirInitial;
        this.nbUtilisationPouvoir = nbUtilisationPouvoirInitial;
        if (nbUtilisationPouvoirInitial > 0 || nbUtilisationPouvoirInitial == -1) {
            operationnel = true;      //non spécifié dans le sujet: si Pouvoir peut être utilisé
        }                             // 150 fois, il est bien opérationnel...
    }

    //nbUtilisationPouvoirInitial n'a aucune utilité comme tel dans le sujet...
    @Deprecated
    public void setNbPvInit(int NbPvInit) {
        this.nbUtilisationPouvoirInitial = NbPvInit;
    }


    /* else non demandé dans le sujet: permet à regenerePouvoir() d'être appelée pour un 
    sort à utilisation infinie + ne pas être utilisée alors que le sort a encore des charges */
    public void regenererPouvoir() {
        if (!isOperationnel()) { 
            nbUtilisationPouvoir = nbUtilisationPouvoirInitial;
            operationnel = true;       //utiliser setOperationnel() si operationnel est private
        } else 
            System.out.println("Le pouvoir " + getNom() + " est encore utilisable.");
    }

    public int utiliser() {
		if (isOperationnel()) {
			nbUtilisationPouvoir--;
			if (nbUtilisationPouvoir == 0)
				operationnel = false;           //si operationnel est private... 
			return getPointDeDegat();           //utiliser setOperationnel()
		} else
            return 0;
    }


    /*  getter pour NbUtilisationPouvoir -- utilisé dans package protagoniste.Monstre
     methode allAttaques()            */
    public String getNbUtilPV() {
        return (nbUtilisationPouvoirInitial == -1) ? "infinite" : Integer.toString(nbUtilisationPouvoir);
    }
}