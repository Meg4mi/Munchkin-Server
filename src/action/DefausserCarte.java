package action;

import java.util.ArrayList;

import carte.Carte;
import joueur.CartesJoueur;
import joueur.Joueur;
import partie.Combat;
import partie.Constante;
import partie.Partie;

/**
 * Classe permettant de defausser un ou plusieurs cartes d'un type spécifique dans un tas spécifique
 * @author Simon Grabit
 */
public class DefausserCarte extends Action{

    private int typeCarte;
    private int nbCarte;
    private int typeTas;
	protected Partie partie;
	protected boolean choixJoueur;
    
    
    /**
     * Constructeur par défaut
     */
    public DefausserCarte() {
    }

    
    /**
     * Constructeur
     * @param typeCarte : type de carte à défausser
     * @param nbCarte : nombre de carte à défausser
     * @param typeTas : type de tas (MAIN ou JEU) depuis lequel se défausser
     */
    public DefausserCarte(int typeCarte, int nbCarte, int typeTas) {
        this.typeCarte = typeCarte;
        this.nbCarte   = nbCarte;
        this.typeTas   = typeTas;
    }
    
    /**
     * Constructeur
     * @param typeCarte : type de carte à défausser
     * @param nbCarte : nombre de carte à défausser
     * @param typeTas : type de tas (MAIN ou JEU) depuis lequel se défausser
     */
    public DefausserCarte(int typeCarte, int nbCarte, int typeTas, boolean choixJoueur) {
        this.typeCarte = typeCarte;
        this.nbCarte   = nbCarte;
        this.typeTas   = typeTas;
        this.choixJoueur = choixJoueur;
        this.partie = partie;
    }

    
    /**
     * Action de défausse des cartes
     * @param joueurImpacte : le joueur devant se défausser
     * @return out : texte résumant l'action
     */
    // TODO : Description méthode + PROTECTION NULL
	@Override
	public String action(Joueur joueurEmetteur,
			ArrayList<Joueur> joueurDestinataire, Partie partie) {
		
		String out = "";
        Carte c    = null;
        CartesJoueur tas;
        int valeur;
        
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
        
        // TODO : Demander au joueur (joueur selon paramètre) la carte qu'il veut défausser 
        for(Joueur joueurImpacte : joueurDestinataireTemp){
	        out += "Une action de défausse de carte est en cours : \n";
	        out += "On défausse " + this.nbCarte + " de type " + this.typeCarte + " dans le tas " + this.typeTas + "\n";
	        
	        if(this.typeTas == Constante.TAS_CHOISIR){  // Si c'est au joueur de choisir (main ou jeu)
	            // TODO : donner la possibilité au joueur de choisir depuis quel tas se défausser
	            valeur = Constante.nbAleatoire(1, 2+1); // On choisit aléatoirement pour lui
	            if(valeur == 1)
	                this.typeTas = Constante.MAIN;
	            else if(valeur == 2)
	                this.typeTas = Constante.JEU;
	            else
	                throw new UnsupportedOperationException("Erreur lors du choix du tas");
	        }
	        
	        if(this.nbCarte == Constante.NB_PAR_DE){            // Le nb de carte est défini par dé
	            this.nbCarte = Constante.nbAleatoire(1, 6+1);
	        }else if(this.nbCarte == Constante.NB_TOUT){        // Toutes les cartes du tas
	            if(this.typeTas == Constante.MAIN)
	                this.nbCarte = joueurImpacte.getMain().getCartes().size();
	            else if(this.typeTas == Constante.JEU)
	                this.nbCarte = joueurImpacte.getJeu().getCartes().size();
	        }
	        
	        // Récupére le tas de carte souhaité
	        if(this.typeTas == Constante.MAIN)
	            tas = joueurImpacte.getMain();
	        else if(this.typeTas == Constante.JEU)
	            tas = joueurImpacte.getJeu();
	        else
	            throw new UnsupportedOperationException("Problème lors du choix du tas de défausse");
	        
	        // Supprime le nombre de cartes souhaité du tas
	        for(int i=0; i<this.nbCarte; i++)
	            if((c = tas.getRandomCarte()) != null) tas.supprimerCarte(c);
        }
        
        return out;
	}
}
