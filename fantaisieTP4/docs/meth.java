/*
// METHODES DE LA CLASSE Camps
public int nbCombattants() {
  return liste.size();
}

public T selectionner() {
  Random randomGenerateur = new Random();
  int numeroCombattant = randomGenerateur.nextInt(liste.size());
  return liste.get(numeroCombattant);
}

// METHODE DE LA CLASSE Grotte

public String afficherPlanGrotte() {
  StringBuilder affichage = new StringBuilder();
  for (Map.Entry<Salle, List<Salle>> entry : planGrotte.entrySet()) {
   Salle salle = entry.getKey();
   List<Salle> acces = planGrotte.get(salle);
   affichage.append("La " + salle + ".\nelle possede " + acces.size() + " acces : ");
   for (Salle access : acces) {
    affichage.append(" vers la salle " + access);
   }
   Bataille bataille = batailles.get(salle);
   Camp<Monstre<?>> camp = bataille.getCampMonstres();
   Monstre<?> monstre = camp.selectionner();
   if (camp.nbCombattants() > 1) {
    affichage.append("\n" + camp.nbCombattants() + " monstres de type ");
   } else {
    affichage.append("\nUn monstre de type ");
   }
   affichage.append(monstre.getNom() + " la protege.\n");
   if (salle.getNumeroSalle() == numeroSalleDecisive) {
    affichage.append("C'est dans cette salle que se trouve la pierre de sang.\n");
   }
   affichage.append("\n");
  }
  return affichage.toString();
}

// MONSTRE DE LA CLASSE TestGestionGrotte

Monstre<Feu> dragotenebre = new Monstre<>("dragotenebre", 200, ZoneDeCombat.AERIEN, Domaine.FEU, new BouleDeFeu(4), new Lave(1), new Eclair(3));
Monstre<Tranchant>[] tableauVampirien = new Monstre[10];
for (int i = 0; i < 10; i++) {
  tableauVampirien[i] = new Monstre<>("vampirien", 10, ZoneDeCombat.AERIEN, Domaine.TRANCHANT, new Morsure(10));
}
Monstre<Glace> marinsangant = new Monstre<>("marinsangant", 150, ZoneDeCombat.AQUATIQUE, Domaine.GLACE, new PicsDeGlace(10), new Tornade(1));
Monstre<Tranchant> guillotimort = new Monstre<>("guillotimort", 80, ZoneDeCombat.TERRESTRE, Domaine.TRANCHANT, new LameAcier(10), new Griffe());
Monstre<Glace> givrogolem = new Monstre<>("givrogolem", 200, ZoneDeCombat.TERRESTRE, Domaine.GLACE, new PicsDeGlace(10), new Tornade(1));
Monstre<Feu> aqualave = new Monstre<>("aqualave", 30, ZoneDeCombat.AQUATIQUE, Domaine.FEU, new Lave(5));
Monstre<Tranchant> requispectre = new Monstre<>("requispectre", 200, ZoneDeCombat.AQUATIQUE, Domaine.TRANCHANT, new Griffe());
Monstre<Glace> soufflemort = new Monstre<>("soufflemort", 120, ZoneDeCombat.AERIEN, Domaine.GLACE, new Tornade(8));
Monstre<Feu> cramombre = new Monstre<>("cramombre", 80, ZoneDeCombat.TERRESTRE, Domaine.FEU, new BouleDeFeu(2), new Lave(1), new Eclair(1));
 */