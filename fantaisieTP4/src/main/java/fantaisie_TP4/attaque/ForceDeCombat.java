package fantaisie_TP4.attaque;

import fantaisie_TP4.attaque.armes.Arme;
import fantaisie_TP4.attaque.pouvoirs.Pouvoir;

public abstract class ForceDeCombat {

    private int pointDeDegat;
    private String nom;

    /**
     * <p> can be declared private... </p>
     * <p> NOTE: il aurait peut être été plus judicieux d'initialiser
     * operationnel à true de base et éviter quelques lignes de code dans
     * les constructeurs des sous classes. </p>
     */
    private boolean operationnel;     
    

    /**
     * {@link ForceDeCombat} constructor.
     * @param pointDeDegat - weapon/spell damage.
     * @param nom - weapon/spell name.
     * @see {@link Arme} and {@link Pouvoir}.
     */
    public ForceDeCombat(int pointDeDegat, String nom) {
        this.pointDeDegat = pointDeDegat;
        this.nom = nom;
    }

    public int getPointDeDegat() {
        return pointDeDegat;
    }

    public String getNom() {
        return nom;
    }

    public boolean isOperationnel() {
        return operationnel;
    }

    public void setOperationnel(boolean operationnel) {
        this.operationnel = operationnel;
    }

    /**
     * @return all attributes in a string.
     */
    @Override
    public String toString() {
        return "Nom: " + getNom() + 
               "\nPts deg: " + getPointDeDegat() + 
               "\nOperationnel: " + isOperationnel();
    }
    
    /**
     * Use the weapon/spell once.
     * @return weapon/spell damage.
     */
    public int utiliser() {
        return operationnel ? pointDeDegat : 0;
    }
}