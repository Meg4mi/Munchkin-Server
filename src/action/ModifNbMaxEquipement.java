package action;

import java.util.ArrayList;

import partie.Partie;
import joueur.Joueur;

/**
 * Modifie le nombre d'objet que le personnage peut porter.
 * @author Simon Grabit
 *
 */
public class ModifNbMaxEquipement extends Action{

    private int bonusNbMax;
	

    /**
     * Méthode modifiant le nombre maximum d'objet porté par le joueur
     * @param joueurImpacte
     * @return 
     */    
    // TODO : Description méthode + PROTECTION NULL
    @Override
    public String action(Joueur joueurEmetteur,
                    ArrayList<Joueur> joueurDestinataire, Partie partie) {
		
        String out = "";
        out += "On modifie le nombre maximum d'objet portés par un joueur :\n";
        
        getJoueursTemporaire(joueurEmetteur, joueurDestinataire, partie);
        
        // TODO : Demander au joueur (joueur selon paramètre) la carte qu'il veut défausser 
        for(Joueur joueurImpacte : joueurDestinataireTemp){
            out += "Le joueur impliqué est "+joueurImpacte.getName();
            joueurImpacte.getPersonnage().setCapaciteEquipement(joueurImpacte.getPersonnage().getCapaciteEquipement()+bonusNbMax);
        }
        
        return out;
    }

    @Override
    public String action(Joueur joueurEmetteur,
                    ArrayList<Joueur> joueurDestinataire, Partie partie,
                    boolean choixJoueur) {
        boolean ancienChoixJoueur = this.choixJoueur;
        this.choixJoueur = choixJoueur;
        String out = action(joueurEmetteur, joueurDestinataire, partie);
        this.choixJoueur = ancienChoixJoueur;
        return out;
    }
    
    @Override
    public boolean isPosable(Partie partie, Joueur joueur) {
        return true;
    }

    @Override
    public boolean isIntervenable(int phaseTourEnCours) {
        return true;
    }
}