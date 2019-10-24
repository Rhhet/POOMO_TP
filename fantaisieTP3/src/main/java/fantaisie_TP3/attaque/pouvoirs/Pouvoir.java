package fantaisie_TP3.attaque.pouvoirs;

import fantaisie_TP3.attaque.ForceDeCombat;


/*   Le constructeur de pouvoir a comme argument nbUtilisationPouvoirInitial
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
            setOperationnel(true);    // non spécifié dans le sujet: si Pouvoir peut être utilisé
        }                             // 150 fois, il est bien opérationnel...
    }
    
    /** Getter pour NbUtilisationPouvoir -- utilisé dans le package 
     * {@link protagoniste.Monstre}, methode {@link #allAttaques}. */
    public String getNbUtilPV() {
        return (nbUtilisationPouvoirInitial == -1) 
                        ? "infinite" 
                        : Integer.toString(nbUtilisationPouvoir);
    }

    // nbUtilisationPouvoirInitial n'a aucune utilité comme tel dans le sujet...
    @Deprecated
    public void setNbPvInit(int NbPvInit) {
        this.nbUtilisationPouvoirInitial = NbPvInit;
    }

    /* else non demandé dans le sujet: permet à regenerePouvoir() d'être appelée pour un 
    sort à utilisation infinie + ne pas être utilisée alors que le sort a encore des charges */
    public void regenererPouvoir() {
        if (!isOperationnel()) { 
            nbUtilisationPouvoir = nbUtilisationPouvoirInitial;
            setOperationnel(true);    
        } else 
            System.out.println("Le pouvoir " + getNom() + " est encore utilisable.");
    }

    @Override
    public int utiliser() {
		if (isOperationnel()) {
			nbUtilisationPouvoir--;
			if (nbUtilisationPouvoir == 0)
				setOperationnel(false);
			return getPointDeDegat();
		} else
            return 0;
    }
}