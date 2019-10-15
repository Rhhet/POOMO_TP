package fantaisie_TP3.protagoniste;

import java.util.Iterator;
import java.util.Random;
import fantaisie_TP3.attaque.pouvoirs.Pouvoir;
import fantaisie_TP3.bataille.Bataille;


public class Monstre<T extends Pouvoir> extends EtreVivant {
    
    private T[] attaques;
    private ZoneDeCombat zoneDeCombat;
    private Domaine domaine;
    private GestionAttaque gstAtt;

    // constructor
    @SafeVarargs
    public Monstre(String nom, int forceDeVie, ZoneDeCombat zdc, 
                   Domaine dom, T ... attaques) {
        super(nom, forceDeVie);
        this.zoneDeCombat = zdc;
        this.domaine = dom;
        this.attaques = attaques;
    }

    @Override
    public void rejoindBataille(Bataille bataille) {
        super.rejoindBataille(bataille);     //equiv   this.bataille = bataille;
        bataille.ajouter(this);
    }

    public void mourir() {
        bataille.eliminer(this);
    }

    /* classe interne */

    private class GestionAttaque implements Iterator<T> {

        private T[] attaquesPossibles = attaques;
        private int nbAttaquesPossibles = attaques.length;

        @Deprecated
        public GestionAttaque() {
            attaquesPossibles = attaques;
            nbAttaquesPossibles = attaques.length;
        }

        public boolean hasNext() {
            for (int i = 0; i < nbAttaquesPossibles; i++) {
                T attaque = attaquesPossibles[i];
                while (!attaque.isOperationnel()) {
                    attaque = attaquesPossibles[nbAttaquesPossibles - 1];
                    nbAttaquesPossibles--;
                }
            }
            return (nbAttaquesPossibles != 0);
        }

        public T next() {
            Random rand = new Random();
            int index = rand.nextInt(nbAttaquesPossibles);
            return attaquesPossibles[index];
        }
    }

    
    /* getters */

    public ZoneDeCombat getZDC() {
        return zoneDeCombat;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    /** 
     * This method restores all powers in {@link #attaques} 
     * but thanks to a different implementation (more logical,
     * see {@link Pouvoir})
     * it will print "le pouvoir X est encore utilisable" if the
     * power has been declared with a nb of charge > 0.
     * <p>A power is operationnal when declared with at least 1
     * charge, it doen't need to initialize the fight. </p>
     * <p>Instanciates the class {@link GestionAttaque}.</p>
    */
    public void entreEnCombat() {
        for (T x : attaques) {
            x.regenererPouvoir();
        }
        this.gstAtt = new GestionAttaque();
        //yes this. is optional...
    }

    /**
     * Need to be called after {@link #entreEnCombat()} or after
     * a {@link GestionAttaque} object has been created in order
     * to declare the attribute {@link #gstAtt}.
     * @return a random attack if it is available, or null.
     * <p>This method uses the {@link #hasNext()} and 
     * {@link #next()} methods declared in {@link GestionAttaque} 
     * meaning it may return the same attack when called twice.</p>
     */
    public T attaque() {
        return (gstAtt.hasNext()) ? gstAtt.next() 
                                  : null;
    }


    /**
     * Getter on {@link #attaques}.
     * @return {@link #attaques} attribute.
     */
    public T[] getAttaques() {
        return attaques;
    }

    /**
     * Used in {@link #toString()}.
     * <p>Note: this method should be "upgraded" to return
     * a more readable format. </p>
     * @return contents of this.attaques in a String.
     */
    private String allAttaques() {
        String str = "";
        for (T x : attaques) {
            str += x.getNom() + " [Deg: " + x.getPointDeDegat() 
                + ", Utilisable?: " + x.isOperationnel() + " ("
                + x.getNbUtilPV() + ")],\n"; 
        }
        //return str without the last comma/vertical line
        return str.substring(0, str.length() - 2);
    }

    
    /*  *** Other version ***
     (format moins lisible mais utilise toString() de Feu inherited de ForceDeCombat)

    private String allAttaques2() {
        String str = "";
        for (T x : attaques) {
            str += x.getNom() + " [" + x.toString() + "],\n"; 
        }
        return str.substring(0, str.length() - 2);
    } */
    

    @Override
    public String toString() {

        return "\t----->> " + getNom() + " <<-----" +
               "\nPV: " + getForceDeVie() + "  --  Domaine: " + getDomaine() +
               "  --  Zone de Combat: " + getZDC() +
               "\n\t\t ->Attaques<-\n" + allAttaques() + "\n";
    }
}