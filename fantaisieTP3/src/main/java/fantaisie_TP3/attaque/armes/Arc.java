package fantaisie_TP3.attaque.armes;



public class Arc extends Arme {

    private int nbFlechesRestantes;    
    
    public Arc(int nbFlechesRestantes) {
        super(50, "Arc");
        this.nbFlechesRestantes = nbFlechesRestantes;
        if (nbFlechesRestantes > 0) {
            operationnel = true;
        }
    }

    //overrriden method utiliser() de ForceDeCombat
    @Override
    public int utiliser() {
		if (isOperationnel()) {
			nbFlechesRestantes--;
			if (nbFlechesRestantes == 0)
				operationnel = false;         //si operationnel est private... 
			return getPointDeDegat();         //utiliser setOperationnel() 
		} else
            return 0;
    }
    
    //old method utiliser() -- pb avec une flèche restante...
    @Deprecated
    public int utiliser_old() {
        if (nbFlechesRestantes == 0) {
            operationnel = false;
            return 0;
        } else {
            nbFlechesRestantes--;
            return getPointDeDegat();
        }
    }

    //non demandé -- permet d'avoir en plus le nb de flèches...
    @Override
    public String toString() {
        return "Nom: " + getNom() + 
               "\nPts deg: " + getPointDeDegat() + 
               "\nFlèches restantes: " + nbFlechesRestantes +
               "\nOperationnel: " + isOperationnel();
    }

}