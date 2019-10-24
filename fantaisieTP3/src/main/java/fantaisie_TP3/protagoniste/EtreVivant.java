package fantaisie_TP3.protagoniste;

import fantaisie_TP3.bataille.Bataille;



public abstract class EtreVivant implements Comparable<EtreVivant> {

    private String nom;
    private int forceDeVie;
    private Bataille bataille; 

    /**
     * EtreVivant constructor
     * @param nom
     * @param forceDeVie
     */
    public EtreVivant(String nom, int forceDeVie) {
        this.nom = nom;
        this.forceDeVie = forceDeVie;
    }

    public void rejoindBataille(Bataille bataille) {
        this.bataille = bataille;
    }

    public abstract void mourir();

    /* getters/setters */

    public String getNom() {
        return nom;
    }

    public int getForceDeVie() {
        return forceDeVie;
    }

    public void setForceDeVie(int pv) {
        forceDeVie = pv;
    }

    public Bataille getBataille() {
        return bataille;
    }

    @Override
    public int compareTo(EtreVivant etreVivant) {
        return nom.compareTo(etreVivant.nom);
    }

    @Override
    public String toString() {
        return "--Etre vivant: " + getNom() + "--" +
               "\nPV: " + forceDeVie;
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) 
            return true;
        if (ob != null && ob instanceof EtreVivant) {
            EtreVivant etreVivant = (EtreVivant) ob;
            return (nom.equals(etreVivant.nom));
        }
        return false;
    }
}