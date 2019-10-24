package fantaisie_TP4.bataille;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import fantaisie_TP4.protagoniste.EtreVivant;


public class Camp<T extends EtreVivant> implements Iterable<T> {

    List<T> liste = new LinkedList<>();  //called listeCamp in part 2. in "contraintes" ...

    public int nbCombattants() {
        return liste.size();
    }
      
    public T selectionner() {
        Random randomGenerateur = new Random();
        int numeroCombattant = randomGenerateur.nextInt(liste.size());
        return liste.get(numeroCombattant);
    } 


    public void ajouter(T etreVivant) {
        if (!liste.contains(etreVivant)) {
            liste.add(etreVivant);
        } else {
            System.out.println(etreVivant + "\n--> is already in the camp.");
        }
    }

    /**
     * Remove a human/monster from the battlefield
     * <p> Uses the overriden method equals from EtreVivant </p>
     * @param etreVivant
     */
    public void eliminer(T etreVivant) {
        if (liste.contains(etreVivant)) {
            liste.remove(etreVivant);
        } else {
            System.out.println(etreVivant + "\n--> not in the camp.");
        }
    }

    public List<T> getListe() {
        return liste;
    }

    @Override
    public Iterator<T> iterator() {
        return liste.listIterator();
    }

    @Deprecated
    public String toString_old() {
        return liste.toString();
    }

    /**
     * This method must be used with the list toString
     * like in the version {@link #toString_old} but for a more
     * readable format we use this verion.
     */
    @Override
    public String toString() {
        String str = "";
        for (T x : liste) {
            str += x + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}