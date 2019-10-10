package fantaisie_TP2.livre;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import fantaisie_TP2.bataille.Bataille;
import fantaisie_TP2.bataille.Camp;
import fantaisie_TP2.protagoniste.Heros;
import fantaisie_TP2.protagoniste.Homme;



public class AideEcrivain {

    private Bataille bataille;

    public AideEcrivain(Bataille bataille) {
        this.bataille = bataille;
    }

    /* this method takes more than 20 lines BUT this is 
     * because of formating (see the while and blank lines) 
     * ==> no refactoring for this method is needed   */
    /**
     * 
     * @return List of humans in the human camp of the battlefield
     */
    public List<Homme> visualiserForcesHumaines() {
        List<Homme> listeTriee = new LinkedList<>();
        Camp<Homme> camp = bataille.getCampHumains();

        for (Homme h : camp) {
            if (listeTriee.isEmpty()) {
                listeTriee.add(h);
            } else if (!(h instanceof Heros)) {
                listeTriee.add(h);
            } else {
                ListIterator<Homme> iter = listeTriee.listIterator();
                while (iter.hasNext() && (iter.next() instanceof Heros)) {
                    ;       //loop until first non-hero is met
                }
                if (iter.hasNext()) {   //add hero after last hero and before first non-hero
                    iter.previous();
                    iter.add(h);
                } else {            //list contains only heroes
                    listeTriee.add(h);  
                }
            }
        }
        return listeTriee;
    }
    
    /**
     * This method works fine (uses the properties of the linkedlist
     * and of the listiterator) but doesn't follow the restrictions
     * @return List of humans in the human camp of the battlefield
     */
    @Deprecated
    public List<Homme> visualiserForcesHumaines_old() {
        List<Homme> listeTriee = new LinkedList<>();
        Camp<Homme> camp = bataille.getCampHumains();
        int nbHeros = 0;

        for (Iterator<Homme> iter = camp.iterator(); iter.hasNext(); ) {
            Homme homme = iter.next();
            
            if (homme instanceof Heros) {
                listeTriee.add(nbHeros++, homme);
            } else {
                listeTriee.add(homme);
            }
        }
        return listeTriee;
    }
    
}