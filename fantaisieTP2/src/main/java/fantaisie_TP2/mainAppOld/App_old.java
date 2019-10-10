/*package fantaisie_TP2.mainAppOld;


import fantaisie_TP2.attaque.pouvoirs.Pouvoir;
import fantaisie_TP2.attaque.pouvoirs.fireSpells.*;
import fantaisie_TP2.attaque.pouvoirs.iceSpells.Glace;
import fantaisie_TP2.attaque.pouvoirs.iceSpells.PicsDeGlace;
import fantaisie_TP2.attaque.pouvoirs.iceSpells.Tornade;
import fantaisie_TP2.attaque.pouvoirs.sharpSpells.Morsure;
import fantaisie_TP2.attaque.armes.*;
import fantaisie_TP2.protagoniste.Domaine;
import fantaisie_TP2.protagoniste.Monstre;
import fantaisie_TP2.protagoniste.ZoneDeCombat;



public class App_old {

    public static void main(String[] args) {
         //partie 1 - 2 tests 

        Arc bow = new Arc(0);
        Morsure bite = new Morsure(85);

        System.out.println(bow.toString());
        System.out.println();
        System.out.println(bite.toString());
        System.out.println();

        // partie 3 

        var bdf1 = new BouleDeFeu(1000);
        var bdf2 = new BouleDeFeu(100_000);
        var dragon = new Monstre<Feu>("Ebonhorn", 125_050, ZoneDeCombat.AERIEN, 
                                        Domaine.FEU, bdf1, bdf2);

        System.out.println(dragon.toString());   
        System.out.println();
       
        
        var lava = new Lave(100);
        var lightning = new Eclair(100);
        var bdf = new BouleDeFeu(900);
        //bdf.regenererPouvoir();
        var dragotenebre = new Monstre<Feu>("Twilight Drake", 200, ZoneDeCombat.AERIEN,
                                            Domaine.FEU, lava, lightning, bdf);
                                            
        System.out.println(dragotenebre.toString());  
        System.out.println();
             
        Feu att1 = dragotenebre.getAttaques()[0];    

        int degTot = 0;
        while (att1.getNbUtilPV() > 80) {
            att1.utiliser();
            degTot += att1.getPointDeDegat();
        }

        //lava utilisé 20 fois
        System.out.println(dragotenebre.toString());       
        System.out.println(dragotenebre.getNom() + " a fait " + degTot + " degats.");
        System.err.println("\n\n\n");

 
        // partie 4  

        var pw1 = new Lave(30);
        var pw2 = new BouleDeFeu(100);
        var pw3 = new Eclair(45);

        var monster = new Monstre<Feu>("test", 1500, ZoneDeCombat.TERRESTRE, 
                                                        Domaine.FEU, pw1, pw2, pw3);

        System.out.println(monster + "\n");       
        monster.entreEnCombat();

        //this power is random thanks to GestionAttaque implementation of next()
        Pouvoir mst_pw = monster.attaque();
        System.out.println(mst_pw);
        //use the power mst_pw 12 times
        for (int i = 0; i < 12; i++)
            mst_pw.utiliser();
        System.out.println(mst_pw.getNbUtilPV());
    }
}*/


/* IS PRINTED FOR PART 4 (without the last line):
                --test--
PV: 1500  --  Domaine: FEU  --  Zone de Combat: TERRESTRE
                 ->Attaques<-
Lave [Deg: 80, Utilisable?: true (30)],
Boule de feu [Deg: 20, Utilisable?: true (100)],
Eclair [Deg: 50, Utilisable?: true (45)]

Le pouvoir Lave est encore utilisable.
Le pouvoir Boule de feu est encore utilisable.
Le pouvoir Eclair est encore utilisable.
Nom: Boule de feu
Pts deg: 20
Operationnel: true */
