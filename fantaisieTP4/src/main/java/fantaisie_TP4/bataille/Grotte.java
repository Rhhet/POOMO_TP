package fantaisie_TP4.bataille;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import fantaisie_TP4.protagoniste.Monstre;
import fantaisie_TP4.protagoniste.ZoneDeCombat;


public class Grotte {
    private int numeroSalleDecisive;
    private AbstractMap<Salle, Bataille> batailles = new TreeMap<>();
    private AbstractMap<Salle, List<Salle>> planGrotte = new TreeMap<>();

    public Grotte() {

    }

    public void ajouterSalle(ZoneDeCombat zdc, Monstre<?> monstre) {

    }

    public void configurerAcces(int ... arg) {

    }

    public void setNumeroSalleDecisive(int num) {
        numeroSalleDecisive = num;
    }

    public int getPremiereSalle() {
        return 1;
    }

    public Salle salleSuivante() {
        return null;
    }

    public boolean salleDecisive(Salle salle) {
        return salle.getNumeroSalle() == numeroSalleDecisive;
    }

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
}