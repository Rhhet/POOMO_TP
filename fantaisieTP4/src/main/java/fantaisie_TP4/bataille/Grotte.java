package fantaisie_TP4.bataille;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import fantaisie_TP4.protagoniste.Monstre;
import fantaisie_TP4.protagoniste.ZoneDeCombat;


public class Grotte {
    private int numeroSalleDecisive;
    private Map<Salle, Bataille> batailles = new HashMap<>();
    private HashMap<Salle, List<Salle>> planGrotte = new LinkedHashMap<>();
    private Set<Salle> sallesExplorees = new HashSet<>();


    public void ajouterSalle(ZoneDeCombat zdc, Monstre<?> ... monstre) {
        Salle salle = new Salle(planGrotte.size() + 1, zdc);
        Bataille newBataille = new Bataille();
        List<Salle> salleList = new ArrayList<>();
        
        for (Monstre<?> mstr : monstre) {
            if (mstr.getZDC() == zdc)
                mstr.rejoindBataille(newBataille);
        }
        planGrotte.put(salle, salleList);
        batailles.put(salle, newBataille);
    }

    public void configurerAcces(int numSalleOrig, int ... sallesAcces) {
        Salle salleOrig = trouverSalle(numSalleOrig);
        List<Salle> salles = planGrotte.get(salleOrig);
        for (int numSalle : sallesAcces) {
            Salle salleToAdd = trouverSalle(numSalle);
            salles.add(salleToAdd);
        }
    }

    private Salle trouverSalle(int numSalle) {
        Set<Salle> salles = planGrotte.keySet();
        //int index = 0;
        for (Salle salle : salles) {
            if (salle.getNumeroSalle() == numSalle)
                return salle;
            //index++;
        }
        throw new NoSuchElementException();
    }

    public void setNumeroSalleDecisive(int num) {
        numeroSalleDecisive = num;
    }

    public Salle premiereSalle() {
        Salle firstSalle = trouverSalle(1);
        sallesExplorees.add(firstSalle);
        return firstSalle;
    }

    public Salle salleSuivante(Salle curSalle) {
        List<Salle> salleAcces = planGrotte.get(curSalle);
        Salle dstSalle;
        salleAcces.removeAll(sallesExplorees);
        if (salleAcces.isEmpty()) 
            salleAcces = planGrotte.get(curSalle);
        dstSalle = getRandomSalle(salleAcces);
        return dstSalle;
    }

    private Salle getRandomSalle(List<Salle> listSalle) {
        Random rand = new Random();
        return listSalle.get(rand.nextInt(listSalle.size()));
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

    /*   getters   */

    public Map<Salle, Bataille> getBatailles() {
        return batailles;
    }

    public HashMap<Salle, List<Salle>> getPlanGrotte() {
        return planGrotte;
    }

    public Set<Salle> getSallesExplorees() {
        return sallesExplorees;
    }
}