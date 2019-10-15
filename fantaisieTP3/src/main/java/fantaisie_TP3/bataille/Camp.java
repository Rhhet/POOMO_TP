package fantaisie_TP3.bataille;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fantaisie_TP3.protagoniste.EtreVivant;



public class Camp<T extends EtreVivant> implements Iterable<T> {

    List<T> liste = new LinkedList<>();  //called listeCamp in part 2. in "contraintes" ...

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

    public Iterator<T> iterator() {
        return liste.listIterator();
    }

    public List<T> getListe() {
        return liste;
    }

    @Deprecated
    public String toString_old() {
        return liste.toString();
    }

    /**
     * This method must be used with the liste toString
     * like in the version {@link #toString_old()} but for a more
     * elegant format we use this verion.
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