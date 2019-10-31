package fantaisie_TP4.bataille;

import fantaisie_TP4.attaque.pouvoirs.Pouvoir;
import fantaisie_TP4.protagoniste.Homme;
import fantaisie_TP4.protagoniste.Monstre;


public class Bataille {
    /* in <? extends Pouvoir> :  "extends Pouvoir" may be useless but added
     * for completeness         */
    
    private Camp<Homme> campHumains = new Camp<>();
    private Camp<Monstre<? extends Pouvoir>> campMonstres = new Camp<>(); 
    /* use of a bounded wildcard argument <? extends Pouvoir>
     * can't specify a type T that won't be defined before
     * (such as Bataille<T extends Pouvoir>)                */

     
    public void ajouter(Homme homme) {
        campHumains.ajouter(homme);
    }

    
    public void ajouter(Monstre<? extends Pouvoir> monstre) {
        campMonstres.ajouter(monstre);
    }

    public void eliminer(Homme homme) {
        campHumains.eliminer(homme);
    }
    
    public void eliminer(Monstre<? extends Pouvoir> monstre) {
        campMonstres.eliminer(monstre);
    }

    /*  getters  */

    public Camp<Homme> getCampHumains() {
        return campHumains;
    }

    public Camp<Monstre<? extends Pouvoir>> getCampMonstres() {
        return campMonstres;
    }
}