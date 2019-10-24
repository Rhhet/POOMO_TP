package fantaisie_TP4.mainApp;

import java.util.NavigableSet;

import util.lines.*;

import fantaisie_TP4.attaque.pouvoirs.Pouvoir;
import fantaisie_TP4.attaque.pouvoirs.fireSpells.*;
import fantaisie_TP4.attaque.pouvoirs.iceSpells.*;
import fantaisie_TP4.attaque.pouvoirs.sharpSpells.*;
import fantaisie_TP4.bataille.Bataille;
import fantaisie_TP4.bataille.Camp;
import fantaisie_TP4.livre.AideEcrivain;
import fantaisie_TP4.protagoniste.*;


public class App {

    public static void main(String[] args) {
        
        System.out.println("TP1-2 start\n");
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
        System.out.println("\nTP1-2 end");
        Line.drawHztLine();
        /* ----------------------------  TP3.1  --------------------------------------- */
        System.out.println("\nTP3.1 start\n");
        System.out.println(test.ordreNaturelMonstre());
        System.out.println();

        //test.updateMonstresZone();
        //System.out.println(test.getDomSet());
        System.out.println(test.ordreMonstreDomaine());
        System.out.println("\nTP3.1 end");
        Line.drawHztLine();
        /* ----------------------------  TP3.2  --------------------------------------- */
        System.out.println("\nTP3.2 start\n");

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

        
        /* the view monstres is automatically updated, just need to update the base tree set
         * which is done by calling getMonstresDeFeu() */
        monstres = test.getMonstresDeFeu();
        System.out.println(AideEcrivain.affichageMonstres(monstres));

        Monstre<Glace> givrogolem = new Monstre<>("givrogolem", 200, ZoneDeCombat.TERRESTRE,
                Domaine.GLACE, new PicsDeGlace(10));
        givrogolem.rejoindBataille(bataille);

        monstres = test.getMonstresDeFeu();
        System.out.println(AideEcrivain.affichageMonstres(monstres));
        System.out.println("\nTP3.2 end");
        Line.drawHztLine();
        /* ----------------------------  TP3.2  --------------------------------------- */
        System.out.println("\nTP3.3 start\n");

        Monstre<Feu> aqualave = new Monstre<>("aqualave", 30, ZoneDeCombat.AQUATIQUE,
                Domaine.FEU, new Lave(5));
        Monstre<Tranchant> requispectre = new Monstre<>("requispectre", 200, ZoneDeCombat.AQUATIQUE,
                Domaine.TRANCHANT, new Griffe());
        aqualave.rejoindBataille(bataille);
        requispectre.rejoindBataille(bataille);
        
        
        System.out.println("\n" + test.ordreMonstreDomaine());

        System.out.println("\n" + AideEcrivain.affichageMonstres(test.getMonstresDeFeu()));
        System.out.println("\n" + AideEcrivain.affichageMonstres(test.getMonstresDeGlace()));
        System.out.println("\n" + AideEcrivain.affichageMonstres(test.getMonstresTranchants()));
        System.out.println("\nTP3.3 end");
        Line.drawHztLine();

        System.out.println("TP4 start");

        /* Grotte grotte = new Grotte();

        grotte.ajouterSalle(ZoneDeCombat.TERRESTRE, guillotimort);
        grotte.ajouterSalle(ZoneDeCombat.AERIEN, dragotenebre);
        grotte.ajouterSalle(ZoneDeCombat.TERRESTRE, cramombre);
        grotte.ajouterSalle(ZoneDeCombat.TERRESTRE, givrogolem);
        grotte.ajouterSalle(ZoneDeCombat.AERIEN, tableauVampirien);
        grotte.ajouterSalle(ZoneDeCombat.AQUATIQUE, aqualave);
        grotte.ajouterSalle(ZoneDeCombat.AQUATIQUE, marinsangant);
        grotte.ajouterSalle(ZoneDeCombat.AQUATIQUE, requispectre);
        grotte.ajouterSalle(ZoneDeCombat.AERIEN, soufflemort);

        grotte.configurerAcces(1, 2, 6);
        grotte.configurerAcces(2, 1, 3, 5);
        grotte.configurerAcces(3, 2, 4);
        grotte.configurerAcces(4, 3, 5, 9);
        grotte.configurerAcces(5, 2, 4, 6, 8);
        grotte.configurerAcces(6, 1, 5, 7);
        grotte.configurerAcces(7, 6, 8);
        grotte.configurerAcces(8, 5, 7, 9);
        grotte.configurerAcces(9, 4, 8);

        grotte.setNumeroSalleDecisive(9);

        System.out.println("\n**** TP4 ****");
        System.out.println("Plan de la grotte\n" + grotte.afficherPlanGrotte());
        System.out.println("\nParcours de la grotte\n");
        Salle salle = grotte.premiereSalle();
        System.out.println(salle + "\n");
        if (!grotte.salleDecisive(salle)) {
			do {
				salle = grotte.salleSuivante(salle);
				System.out.println(salle + "\n");
			} while (!grotte.salleDecisive(salle));
			System.out.println("C'est la salle contenant la Pierre de Sang");
        } */

        System.out.println("\nTP4 end");
    }
}
