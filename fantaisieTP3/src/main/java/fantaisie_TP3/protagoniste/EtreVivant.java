package fantaisie_TP3.protagoniste;

import fantaisie_TP3.bataille.Bataille;



public abstract class EtreVivant implements Comparable<EtreVivant> {

    protected String nom;
    protected int forceDeVie;
    protected Bataille bataille; 

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

    /* getters */

    public String getNom() {
        return nom;
    }

    public int getForceDeVie() {
        return forceDeVie;
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
        if (ob instanceof EtreVivant) {
            EtreVivant etreVivant = (EtreVivant) ob;
            return (nom.equals(etreVivant.nom));
        }
        return false;
    }
}