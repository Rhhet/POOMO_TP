package fantaisie_TP3.attaque.armes;



public class Arc extends Arme {

    private int nbFlechesRestantes;    
    
    public Arc(int nbFlechesRestantes) {
        super(50, "Arc");
        this.nbFlechesRestantes = nbFlechesRestantes;
        if (nbFlechesRestantes > 0) {
            setOperationnel(true);
        }
    }

    @Override
    public int utiliser() {
		if (isOperationnel()) {
			nbFlechesRestantes--;
			if (nbFlechesRestantes == 0)
				setOperationnel(false);;         
			return getPointDeDegat();         
		} else
            return 0;
    }

    @Override
    public String toString() {
        return "Nom: " + getNom() + 
               "\nPts deg: " + getPointDeDegat() + 
               "\nFlèches restantes: " + nbFlechesRestantes +
               "\nOperationnel: " + isOperationnel();
    }

}