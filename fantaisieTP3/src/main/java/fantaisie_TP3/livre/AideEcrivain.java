package fantaisie_TP3.livre;


import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.TreeSet;

//import fantaisie_TP3.attaque.pouvoirs.Pouvoir;
import fantaisie_TP3.bataille.Bataille;
import fantaisie_TP3.bataille.Camp;
import fantaisie_TP3.protagoniste.Domaine;
import fantaisie_TP3.protagoniste.Heros;
import fantaisie_TP3.protagoniste.Homme;
import fantaisie_TP3.protagoniste.Monstre;
import fantaisie_TP3.protagoniste.ZoneDeCombat;



public class AideEcrivain {

    private Bataille bataille;

    private Comparator<Monstre<?>> compDomaine = new Comparator<Monstre<?>>() {
        @Override
        public int compare(Monstre<?> monstre1, Monstre<?> monstre2) {
            Domaine dom1 = monstre1.getDomaine();
            Domaine dom2 = monstre2.getDomaine();

            return dom1 == dom2 ? monstre1.compareTo(monstre2)
                                : dom1.compareTo(dom2);
        }
    };

    private Comparator<Monstre<?>> compZone = new Comparator<Monstre<?>>() {
        @Override
        public int compare(Monstre<?> monstre1, Monstre<?> monstre2) {
            ZoneDeCombat zone1 = monstre1.getZDC();
            ZoneDeCombat zone2 = monstre2.getZDC();
            // int returned by getForceDeVie is autoboxed as Integer (auto wrapped)
            Integer pvMonstre1 = monstre1.getForceDeVie();
            Integer pvMonstre2 = monstre2.getForceDeVie();

            if (zone1 != zone2) {
                return zone1.compareTo(zone2);
            }
            // pvMonstre are auto-unboxed as int (auto un-wrapped)
            return pvMonstre1 == pvMonstre2 ? monstre1.compareTo(monstre2)
                                            : pvMonstre2.compareTo(pvMonstre1);
        }
    };

    // other way to create the comparator: with a lambda expression
    // because Comparator is a functionnal interface (only one abstract method)
    /* private Comparator<Monstre<?>> comp_ = (m1, m2) -> {
        Domaine dom1 = m1.getDomaine();
        Domaine dom2 = m2.getDomaine();

        return dom1 == dom2 ? m1.compareTo(m2)
                            : dom1.compareTo(dom2);
    }; */

    private NavigableSet<Monstre<?>> monstresDomaineSet = new TreeSet<>(compDomaine);
    private NavigableSet<Monstre<?>> monstresZoneSet = new TreeSet<>(compZone);

    private NavigableSet<Monstre<?>> monstresDeFeu;
    private NavigableSet<Monstre<?>> monstresDeGlace;
    private NavigableSet<Monstre<?>> monstresTranchants;

    /* ----------------------------------------------------------------------- */
    
    public AideEcrivain(Bataille bataille) {
        this.bataille = bataille;
    }

    /* ----------------------------------------------------------------------- */

    /**
     * Add one by one the monsters in the camp of monsters to the monsters' set.
     * <p>Setter for {@link #monstresDomaineSet}.</p>
     */
    public void updateMonstresDomaine() {
        Camp<Monstre<?>> camp = bataille.getCampMonstres();

        for (Iterator<Monstre<?>> iter = camp.iterator(); iter.hasNext(); ) {
            monstresDomaineSet.add(iter.next());
        }
    }

    /**
     * Add one by one the monsters in the camp of monsters to the monsters' set.
     * <p>Setter for {@link #monstreZoneSet}.</p>
     */
    public void updateMonstresZone() {
        Camp<Monstre<?>> camp = bataille.getCampMonstres();

        for (Iterator<Monstre<?>> iter = camp.iterator(); iter.hasNext(); ) {
            monstresZoneSet.add(iter.next());
        }
    }

    /**
     * Note: this implementation doesn't rely on {@link Domaine}, adding new
     * domains won't require the method to be changed.
     * <p>The method {@link #updateMonstresDomaine()} is called first by the method.</p>
     * @return the monsters in battle classified by domain and ordered by name
     */
    public String ordreMonstreDomaine() {
        updateMonstresDomaine();
        Monstre<?> first = monstresDomaineSet.first();
        Domaine dom = first.getDomaine();
        Iterator<Monstre<?>> itMstr = monstresDomaineSet.iterator();
        String str = dom + ":\n";

        for (Monstre<?> monstre : monstresDomaineSet) {
            Domaine mDom = monstre.getDomaine();
            
            if (mDom == dom) {
                Monstre<?> mstr = itMstr.next();
                str += mstr.getNom() + ", ";
            } else {
                dom = mDom;
                Monstre<?> mstr = itMstr.next();
                str += "\n" + dom + ":\n" + mstr.getNom() + ", ";
            }
        }
        return str.substring(0, str.length() - 2);
    }        

    /**
     * Note: this implementation doesn't rely on {@link Zone}, adding new
     * zones won't require the method to be changed.
     * <p>The method {@link #updateMonstresZone()} is called first by the method.</p>
     * @return the monsters in battle classified by zone and ordered by 
     * hit point and name.
     */
    public String ordreMonstreZone() {
        updateMonstresZone();
        Monstre<?> first = monstresZoneSet.first();
        ZoneDeCombat zone = first.getZDC();
        Iterator<Monstre<?>> itMstr = monstresZoneSet.iterator();
        String str = zone + ":\n";

        for (Monstre<?> monstre : monstresZoneSet) {
            ZoneDeCombat mZone = monstre.getZDC();
            
            if (mZone == zone) {
                Monstre<?> mstr = itMstr.next();
                str += mstr.getNom() + ": " + mstr.getForceDeVie() + ", ";
            } else {
                zone = mZone;
                Monstre<?> mstr = itMstr.next();
                str += "\n" + zone + ":\n" + mstr.getNom() 
                    + ": " + mstr.getForceDeVie() + ", ";
            }
        }
        return str.substring(0, str.length() - 2);
    } 

    public String ordreNaturelMonstre() {
        Camp<Monstre<?>> camp = bataille.getCampMonstres();
        String str = "";
        // tree set ordered with natural order defined in EtreVivant
        NavigableSet<Monstre<?>> set = new TreeSet<>(camp.getListe());

        for (Iterator<Monstre<?>> iter = set.iterator(); iter.hasNext(); ) {
            Monstre<?> monstre = iter.next();

            str += monstre.getNom() + ", ";
        }
        return str.substring(0, str.length() - 2);
    }
        
    /* this method takes more than 20 lines BUT this is 
     * because of formating (see the while and blank lines) 
     * ==> no refactoring for this method is needed.  */
    /**
     * 
     * @return List of humans in the human camp of the battlefield.
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
                    ;                   // loop until first non-hero is met
                }
                if (iter.hasNext()) {   // add hero after last hero and before first non-hero
                    iter.previous();
                    iter.add(h);
                } else {                // list contains only heroes
                    listeTriee.add(h);  
                }
            }
        }
        return listeTriee;
    }

    //NOTE: The methods tagged _nMod are non modular, badly coded methods.

    // In the init... methods, the degenerate object's name "" will always 
    // be less than the other objects' names.


    public void initMonstresDeFeu_nMod() {
        Monstre<?> sup = new Monstre<>("", 0, null, Domaine.GLACE);
        monstresDeFeu = monstresDomaineSet.headSet(sup, false);
    }

    public void initMonstresDeGlace_nMod() {
        Monstre<?> inf = new Monstre<>("", 0, null, Domaine.GLACE);
        Monstre<?> sup = new Monstre<>("", 0, null, Domaine.TRANCHANT);
        monstresDeGlace = monstresDomaineSet.subSet(inf, true, sup, false);
    }

    public void initMonstresTranchants_nMod() {
        Monstre<?> inf = new Monstre<>("", 0, null, Domaine.TRANCHANT);
        monstresTranchants = monstresDomaineSet.tailSet(inf, true);
    }


    public static String affichageMonstres(NavigableSet<Monstre<?>> monstres) {
        String str = "";
        for (Monstre<?> mstr : monstres) {
            str = monstreDomIDcpy(str, mstr);
        }
        return str.substring(0, str.length() - 2);
    }

    /**
     * 
     * @param str the source string being concatenated.
     * @param mstr 
     * @return the string str concatenated with the name and domain of {@code mstr}.
     */
    private static String monstreDomIDcpy(String str, Monstre<?> mstr) {
        if (mstr.getDomaine() == Domaine.TRANCHANT)
            str += mstr.getNom() + " monstre " + Domaine.TRANCHANT + ", ";
        else
            str += mstr.getNom() + " monstre de " + mstr.getDomaine() + ", ";
        return str;
    }

    // old methods TP3.2.2

    /**
     * Bad coding, not modular (and if i have no ice monster? or if
     * i decide to add a domain between FEU and GLACE?).
     * <p>This method relies on the method {@link #firstMonstreDomaine_old} 
     * but the first monster returned is never updated for the view.</p>
     */
    public void initMonstresDeFeu_nMod_old() {
        Monstre<?> mstr = firstMonstreDomaine_old(Domaine.GLACE);
        monstresDeFeu = monstresDomaineSet.headSet(mstr, false);
    }

    private Monstre<?> firstMonstreDomaine_old(Domaine domaine) {
        for (Monstre<?> mstr : monstresDomaineSet) {
            if (mstr.getDomaine() == domaine) {
                return mstr;
            }
        }
        throw new NoSuchElementException("No " + domaine + " monster.");
    }
    
    
    /* ----------------------------------------------------------------------- */

    public NavigableSet<Monstre<?>> getDomSet() {
        updateMonstresDomaine();
        return monstresDomaineSet;
    }

    public NavigableSet<Monstre<?>> getZoneSet() {
        updateMonstresZone();
        return monstresZoneSet;
    }

    public NavigableSet<Monstre<?>> getMonstresDeFeu() {
        updateMonstresDomaine();
        return monstresDeFeu;
    }

    public NavigableSet<Monstre<?>> getMonstresDeGlace() {
        updateMonstresDomaine();
        return monstresDeGlace;
    }

    public NavigableSet<Monstre<?>> getMonstresTranchants() {
        updateMonstresDomaine();
        return monstresTranchants;
    }

    /* ----------------------------------------------------------------------- */

    
    /**
     * This method works fine (uses the properties of the linkedlist
     * and of the listiterator) but doesn't follow the restrictions.
     * @return List of humans in the human camp of the battlefield.
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

    /**
     * Uses an iterator instead of a foreach loop. 
     */
    @Deprecated
    public String ordreMonstresDomaine_old() {
        updateMonstresDomaine();
        Monstre<?> first = monstresDomaineSet.first();
        Domaine dom = first.getDomaine();
        Iterator<Monstre<?>> itMstr = monstresDomaineSet.iterator();
        String str = dom + ":\n";

        for (Iterator<Monstre<?>> itTest = monstresDomaineSet.iterator(); itTest.hasNext(); ) {
            Monstre<?> monstre = itTest.next();
            Domaine mDom = monstre.getDomaine();
            
            if (mDom == dom) {
                Monstre<?> mstr = itMstr.next();
                str += mstr.getNom() + ", ";
            } else {
                dom = mDom;
                Monstre<?> mstr = itMstr.next();
                str += "\n" + dom + ":\n" + mstr.getNom() + ", ";
            }
        }
        return str.substring(0, str.length() - 2);
    }        

    @Deprecated
    public NavigableSet<Monstre<?>> initMonstresDeDom(Domaine dom) {
        Iterator<Monstre<?>> iter = monstresDomaineSet.iterator();
        Monstre<?> mstrInf = iter.next();

        while (iter.hasNext() && mstrInf.getDomaine() != dom) 
            mstrInf = iter.next();
        Monstre<?> mstrSup = mstrInf;

        while (iter.hasNext() && mstrSup.getDomaine() == dom) 
            mstrSup = iter.next();

        return monstresDomaineSet.subSet(mstrInf, true, mstrSup, false);        
    }

}

    
