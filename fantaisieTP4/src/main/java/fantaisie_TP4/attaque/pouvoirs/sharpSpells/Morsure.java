package fantaisie_TP4.attaque.pouvoirs.sharpSpells;


public class Morsure extends Tranchant {

    /**
     * Moruse can be used an infinite amount of time
     * @param pointDeDegat    - depends on the monster who uses this spell
     */
    public Morsure(int pointDeDegat) {
        super(pointDeDegat, "Morsure", -1);    // nbUtilisationPouvoirInitial = -1 means 
    }                                          // infinite nb of utilisations

    // Morsure utilisable un nb infini de fois...
    @Override
    public int utiliser() {
		if (isOperationnel())
			return getPointDeDegat();
		else
			return 0;
	}
}