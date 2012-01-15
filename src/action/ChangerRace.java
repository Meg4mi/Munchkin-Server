package action;

import java.util.ArrayList;

import partie.Combat;
import partie.Partie;
import joueur.Joueur;
import joueur.Race;

/**
 * Classe permettant de modifier la race d'un joueur
 * @author Rémi Marenco
 */
public class ChangerRace extends Action {
    
    protected Race race;
    protected boolean choixJoueur;
	protected Partie partie;
    
    /**
     * Constructeur par défaut
     * @param race : nouvelle race
     */
    public ChangerRace(Race race) {
        this.race = race;
    }
    
    /**
     * Méthode permettant de changer la race d'un joueur choisi par le joueur émetteur
     * @param race
     * @param choixJoueur => True pour que le joueur cible soit choisi par le joueur émetteur
     * @param partie
     */
    public ChangerRace(Race race, boolean choixJoueur) {
        this.race = race;
        this.choixJoueur = choixJoueur;
        this.partie = partie;
    }

    /**
     * Action permettant le changement de race
     * @param joueurImpacte : joueur qui subit le changement de race
     * @return out : texte résumant l'action 
     */
    // TODO : Description méthode + PROTECTION NULL
	@Override
	public String action(Joueur joueurEmetteur,
			ArrayList<Joueur> joueurDestinataire, Partie partie) {
		
		String out = "";
		
		// Création d'une nouvelle ArrayList pour éviter de modifier les paramètres...possible de les passer en final
		ArrayList<Joueur> joueurDestinataireTemp = (ArrayList<Joueur>) joueurDestinataire.clone();
		
		// On demande ici la liste des joueurs destinataires au joueur émetteur si choix est a true
        if(choixJoueur)
        {
        	// Si on avait spécifié null, on doit créer l'arraylist
        	if(joueurDestinataireTemp == null)
        	{
        		joueurDestinataireTemp = new ArrayList<Joueur>();
        	}
        	
        	// On renvoi les joueurs destinataires par une demande au joueur initiateur
        	joueurDestinataireTemp.add(demandeChoixJoueur(partie, joueurEmetteur));
        }
		
		for(Joueur joueurImpacte : joueurDestinataireTemp){
			out = joueurImpacte.getName() + " passe de la race " + joueurImpacte.getPersonnage().getRace();
	        joueurImpacte.getPersonnage().setRace(this.race);
	        out += " à la race " + joueurImpacte.getPersonnage().getRace();
		}
        return out;
	}
}