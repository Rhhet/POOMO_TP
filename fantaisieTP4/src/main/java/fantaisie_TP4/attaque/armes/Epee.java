package fantaisie_TP4.attaque.armes;



public class Epee extends Arme {

    private String nomEpee; 

    public Epee(String nomEpee) {
        super(80, "Epee");
        this.nomEpee = nomEpee;
        setOperationnel(true);
    }

    public String getNomEpee() {
        return nomEpee;
    }
}