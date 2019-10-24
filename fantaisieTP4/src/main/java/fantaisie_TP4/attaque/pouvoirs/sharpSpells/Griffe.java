package fantaisie_TP4.attaque.pouvoirs.sharpSpells;


public class Griffe extends Tranchant {

    public Griffe() {
        super(20, "Griffe", -1);    //nbUtilisationPouvoirInitial = -1 means 
    }                               // infinite nb of utilisations

    //override utiliser(): Griffe utilisable un nb infini de fois...
    @Override
    public int utiliser() {
		if (isOperationnel())
			return getPointDeDegat();
		else
			return 0;
	}
}