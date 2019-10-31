package fantaisie_TP4.mainApp;


import util.lines.*;

import fantaisie_TP4.attaque.pouvoirs.fireSpells.*;
import fantaisie_TP4.attaque.pouvoirs.iceSpells.*;
import fantaisie_TP4.attaque.pouvoirs.sharpSpells.*;
import fantaisie_TP4.bataille.Grotte;
import fantaisie_TP4.bataille.Salle;
import fantaisie_TP4.protagoniste.*;


public class AppTP4 {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        /* ----------------------------   TP4   --------------------------------------- */
        
        Monstre<Feu> dragotenebre = new Monstre<>("dragotenebre", 200, ZoneDeCombat.AERIEN, 
				Domaine.FEU, new BouleDeFeu(4), new Lave(1), new Eclair(3)); 
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
        Monstre<Tranchant>[] tableauVampirien = new Monstre[10];
        for (int i = 0; i < 10; i++) {
			tableauVampirien[i] = new Monstre<>("vampirien", 10, ZoneDeCombat.AERIEN, 
					Domaine.TRANCHANT,new Morsure(10));
        }

        /* ----------------------------  TP4.2  --------------------------------------- */
        Line.drawTitleLine("TP4.2");  

        Grotte grotte = new Grotte();

        
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

        System.out.println(grotte.afficherPlanGrotte());


        System.out.println("Plan grotte:\n" + grotte.afficherPlanGrotte());
        Salle salle = grotte.premiereSalle();
        System.out.println(salle + "\n");
        if (!grotte.salleDecisive(salle)) {
			do {
				salle = grotte.salleSuivante(salle);
				System.out.println(salle + "\n");
			} while (!grotte.salleDecisive(salle));
			System.out.println("C'est la salle contenant la Pierre de Sang");
        } else {
			// first room contains the bloodstone
			System.out.println("C'est la salle contenant la Pierre de Sang");
		}

        Line.drawHztLine();
    }
}