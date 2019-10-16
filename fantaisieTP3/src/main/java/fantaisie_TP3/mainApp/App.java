package fantaisie_TP3.mainApp;

import java.util.NavigableSet;

import fantaisie_TP3.attaque.pouvoirs.Pouvoir;
import fantaisie_TP3.attaque.pouvoirs.fireSpells.*;
import fantaisie_TP3.attaque.pouvoirs.iceSpells.*;
import fantaisie_TP3.attaque.pouvoirs.sharpSpells.*;
import fantaisie_TP3.bataille.Bataille;
import fantaisie_TP3.bataille.Camp;
import fantaisie_TP3.livre.AideEcrivain;
import fantaisie_TP3.protagoniste.*;


public class App {

    public static void main(String[] args) {
        
        Monstre<Feu> dragotenebre = new Monstre<>("dragotenebre", 200, ZoneDeCombat.AERIEN, 
                                                  Domaine.FEU, new BouleDeFeu(4), new Lave(1), 
                                                  new Eclair(3));
        Monstre<Tranchant> vampirien = new Monstre<>("vampirien", 10, ZoneDeCombat.AERIEN,
                                                     Domaine.TRANCHANT, new Morsure(10));                                          
        Monstre<Glace> marinsangant = new Monstre<>("marinsangant", 150, ZoneDeCombat.AQUATIQUE,
                                                    Domaine.GLACE, new PicsDeGlace(10), new Tornade(1));
        Monstre<Tranchant> guillotimort = new Monstre<>("guillotimort", 80, ZoneDeCombat.TERRESTRE,
                                                        Domaine.TRANCHANT, new LameAcier(10), new Griffe());

        Homme thomas = new Homme("Thomas");           
        Homme louis = new Homme("Louis");                 
        Heros arthur = new Heros("Arthur"); 
        Heros archibald = new Heros("Archibald");           
        Homme alain = new Homme("Alain");
        
        Bataille bataille = new Bataille();

        thomas.rejoindBataille(bataille);
        louis.rejoindBataille(bataille);
        arthur.rejoindBataille(bataille);
        archibald.rejoindBataille(bataille);
        alain.rejoindBataille(bataille);
        dragotenebre.rejoindBataille(bataille);
        vampirien.rejoindBataille(bataille);
        marinsangant.rejoindBataille(bataille);
        guillotimort.rejoindBataille(bataille);

        Camp<Homme> campHumains = bataille.getCampHumains();
        Camp<Monstre<? extends Pouvoir>> campMonstres = bataille.getCampMonstres();
        //yes "extends Pouvoir" is useless but makes it clearer

        System.out.println("camp humains:\n" + campHumains);
        System.out.println("\ncamp monstres:\n" + campMonstres);
        
        System.out.println();
        AideEcrivain test = new AideEcrivain(bataille);
        System.out.println(test.visualiserForcesHumaines());

        /* ----------------------------  TP3.1  --------------------------------------- */

        System.out.println(test.ordreNaturelMonstre());
        System.out.println();

        //test.updateMonstresZone();
        //System.out.println(test.getDomSet());
        System.out.println(test.ordreMonstreDomaine());
        System.out.println();

        /* ----------------------------  TP3.2  --------------------------------------- */
        
        //test.initMonstresDeFeu_nMod_old();
        test.initMonstresDeFeu_nMod();
        test.initMonstresDeGlace_nMod();
        test.initMonstresTranchants_nMod();

        NavigableSet<Monstre<?>> monstres = test.getMonstresDeFeu();

        System.out.println(AideEcrivain.affichageMonstres(monstres));
        
        Monstre<Glace> soufflemort = new Monstre<>("soufflemort", 120, ZoneDeCombat.AERIEN,
                Domaine.GLACE, new Tornade(8));
        Monstre<Feu> cramombre = new Monstre<>("cramombre", 80, ZoneDeCombat.TERRESTRE,
                Domaine.FEU, new BouleDeFeu(2), new Lave(1));

        soufflemort.rejoindBataille(bataille);
        cramombre.rejoindBataille(bataille);

        test.updateMonstresDomaine();
        /* the view monstres is automatically updated, just need to update the base tree set
         * which is done by calling updateMonstresDomaine() or getMonstresDeFeu() but the latter
         * re-initializes the view which isn't needed.  */
        //monstres = test.getMonstresDeFeu();
        System.out.println(AideEcrivain.affichageMonstres(monstres));

        Monstre<Glace> givrogolem = new Monstre<>("givrogolem", 200, ZoneDeCombat.TERRESTRE,
                Domaine.GLACE, new PicsDeGlace(10));
        givrogolem.rejoindBataille(bataille);

        test.updateMonstresDomaine();
        System.out.println(AideEcrivain.affichageMonstres(monstres));

        Monstre<Feu> aqualave = new Monstre<>("aqualave", 30, ZoneDeCombat.AQUATIQUE,
                Domaine.FEU, new Lave(5));
        Monstre<Tranchant> requispectre = new Monstre<>("requispectre", 200, ZoneDeCombat.AQUATIQUE,
                Domaine.TRANCHANT, new Griffe());
        aqualave.rejoindBataille(bataille);
        requispectre.rejoindBataille(bataille);
        
        test.updateMonstresDomaine();

        System.out.println("\n" + test.ordreMonstreDomaine());

        System.out.println("\n" + AideEcrivain.affichageMonstres(test.getMonstresDeFeu()));
        System.out.println("\n" + AideEcrivain.affichageMonstres(test.getMonstresDeGlace()));
        System.out.println("\n" + AideEcrivain.affichageMonstres(test.getMonstresTranchants()));
    }
}
