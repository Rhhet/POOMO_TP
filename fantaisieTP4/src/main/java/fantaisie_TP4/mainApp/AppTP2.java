package fantaisie_TP4.mainApp;


import util.lines.*;

import fantaisie_TP4.attaque.pouvoirs.Pouvoir;
import fantaisie_TP4.attaque.pouvoirs.fireSpells.*;
import fantaisie_TP4.attaque.pouvoirs.iceSpells.*;
import fantaisie_TP4.attaque.pouvoirs.sharpSpells.*;
import fantaisie_TP4.bataille.Bataille;
import fantaisie_TP4.bataille.Camp;
import fantaisie_TP4.livre.AideEcrivain;
import fantaisie_TP4.protagoniste.*;

public class AppTP2 {

    public static void main(String[] args) {

        Line.drawTitleLine("TP2");
        
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
        Line.drawHztLine();
    }
}