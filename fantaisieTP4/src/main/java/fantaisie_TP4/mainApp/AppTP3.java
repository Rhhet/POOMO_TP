package fantaisie_TP4.mainApp;

import java.util.NavigableSet;

import util.lines.*;

import fantaisie_TP4.attaque.pouvoirs.fireSpells.*;
import fantaisie_TP4.attaque.pouvoirs.iceSpells.*;
import fantaisie_TP4.attaque.pouvoirs.sharpSpells.*;
import fantaisie_TP4.bataille.Bataille;
import fantaisie_TP4.livre.AideEcrivain;
import fantaisie_TP4.protagoniste.*;

public class AppTP3 {
    
    public static void main(String[] args) {

        /* ----------------------------   TP3   --------------------------------------- */
        
        Monstre<Feu> dragotenebre = new Monstre<>("dragotenebre", 200, ZoneDeCombat.AERIEN, 
                                                  Domaine.FEU, new BouleDeFeu(4), new Lave(1), 
                                                  new Eclair(3));
        Monstre<Tranchant> vampirien = new Monstre<>("vampirien", 10, ZoneDeCombat.AERIEN,
                                                     Domaine.TRANCHANT, new Morsure(10));                                          
        Monstre<Glace> marinsangant = new Monstre<>("marinsangant", 150, ZoneDeCombat.AQUATIQUE,
                                                    Domaine.GLACE, new PicsDeGlace(10), new Tornade(1));
        Monstre<Tranchant> guillotimort = new Monstre<>("guillotimort", 80, ZoneDeCombat.TERRESTRE,
                                                        Domaine.TRANCHANT, new LameAcier(10), new Griffe());
		Monstre<Glace> soufflemort = new Monstre<>("soufflemort", 120, ZoneDeCombat.AERIEN,
                Domaine.GLACE, new Tornade(8));
        Monstre<Feu> cramombre = new Monstre<>("cramombre", 80, ZoneDeCombat.TERRESTRE,
                Domaine.FEU, new BouleDeFeu(2), new Lave(1));
		Monstre<Feu> aqualave = new Monstre<>("aqualave", 30, ZoneDeCombat.AQUATIQUE,
                Domaine.FEU, new Lave(5));
        Monstre<Tranchant> requispectre = new Monstre<>("requispectre", 200, ZoneDeCombat.AQUATIQUE,
                Domaine.TRANCHANT, new Griffe());
		Monstre<Glace> givrogolem = new Monstre<>("givrogolem", 200, ZoneDeCombat.TERRESTRE,
                Domaine.GLACE, new PicsDeGlace(10));


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

        /* ----------------------------  TP3.1  --------------------------------------- */
        Line.drawTitleLine("TP3.1");
        AideEcrivain test = new AideEcrivain(bataille);


        System.out.println(test.ordreNaturelMonstre());
        System.out.println();

        //test.updateMonstresZone();
        //System.out.println(test.getDomSet());
        System.out.println(test.ordreMonstreDomaine());
        Line.drawHztLine();

        /* ----------------------------  TP3.2  --------------------------------------- */
        Line.drawTitleLine("TP3.2");

        //test.initMonstresDeFeu_nMod_old();
        test.initMonstresDeFeu_nMod();
        test.initMonstresDeGlace_nMod();
        test.initMonstresTranchants_nMod();

        NavigableSet<Monstre<?>> monstres = test.getMonstresDeFeu();

        System.out.println(AideEcrivain.affichageMonstres(monstres));
        
        
        soufflemort.rejoindBataille(bataille);
        cramombre.rejoindBataille(bataille);

        
        /* the view monstres is automatically updated, just need to update the base tree set
         * which is done by calling getMonstresDeFeu() */
        monstres = test.getMonstresDeFeu();
        System.out.println(AideEcrivain.affichageMonstres(monstres));

        
        givrogolem.rejoindBataille(bataille);

        monstres = test.getMonstresDeFeu();
        System.out.println(AideEcrivain.affichageMonstres(monstres));
        Line.drawHztLine();

        /* ----------------------------  TP3.3  --------------------------------------- */

        Line.drawTitleLine("TP3.3");
        
        aqualave.rejoindBataille(bataille);
        requispectre.rejoindBataille(bataille);
        
        
        System.out.println("\n" + test.ordreMonstreDomaine());

        System.out.println("\n" + AideEcrivain.affichageMonstres(test.getMonstresDeFeu()));
        System.out.println("\n" + AideEcrivain.affichageMonstres(test.getMonstresDeGlace()));
        System.out.println("\n" + AideEcrivain.affichageMonstres(test.getMonstresTranchants()));
        Line.drawHztLine();
        


    }
}