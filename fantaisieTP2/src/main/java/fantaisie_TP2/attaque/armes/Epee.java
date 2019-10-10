package fantaisie_TP2.attaque.armes;



public class Epee extends Arme {

    private String nomEpee; 

    public Epee(String nomEpee) {
        super(80, "Epee");
        this.nomEpee = nomEpee;
        operationnel = true;
    }

    //getter utilisant l'attribut nomEpee...
    public String getNomEpee() {
        return nomEpee;
    }
}