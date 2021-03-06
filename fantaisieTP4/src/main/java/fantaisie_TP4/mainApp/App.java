/* package fantaisie_TP4.mainApp;

import java.util.NavigableSet;

import util.lines.*;

import fantaisie_TP4.attaque.pouvoirs.Pouvoir;
import fantaisie_TP4.attaque.pouvoirs.fireSpells.*;
import fantaisie_TP4.attaque.pouvoirs.iceSpells.*;
import fantaisie_TP4.attaque.pouvoirs.sharpSpells.*;
import fantaisie_TP4.bataille.Bataille;
import fantaisie_TP4.bataille.Camp;
import fantaisie_TP4.bataille.Grotte;
import fantaisie_TP4.livre.AideEcrivain;
import fantaisie_TP4.protagoniste.*;


public class App {

    @SuppressWarnings("unchecked")
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
        
        
    }
}
 */