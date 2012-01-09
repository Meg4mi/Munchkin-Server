package action;

import java.util.ArrayList;

import joueur.Classe;
import joueur.Joueur;
import joueur.Race;

public class ModifNbMaxEquipement extends Action{

    private int bonusNbMax;
	
    
    /**
     * Constructeur
     * @param bonusNbMax
     */
    public ModifNbMaxEquipement(int bonusNbMax) {
        super();
        this.bonusNbMax = bonusNbMax;
    }

    /**
     * Méthode modifiant le nombre maximum d'objet porté par le joueur
     * @param joueurImpacte
     * @return 
     */
    @Override
    public String action(Joueur joueurImpacte) {

        String out = "";
        out += "On modifie le nombre maximum d'objet portés par un joueur :\n";
        out += "Le joueur impliqué est "+joueurImpacte.getName();
        
        joueurImpacte.getPersonnage().setCapaciteEquipement(joueurImpacte.getPersonnage().getCapaciteEquipement()+bonusNbMax);
        
        return out;
    }
}