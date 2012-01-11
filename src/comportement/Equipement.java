package comportement;

import java.util.ArrayList;

import partie.Combat;
import action.Action;
import joueur.Joueur;


/**
 * 
 * @author Julien Rouvier
 */
public  class Equipement {
    
    private ArrayList<Action> tabAction;

    
    /**
     * Constructeur
     * @param tabAction : ensemble d'action 
     */
    public Equipement(ArrayList<Action> tabAction) {
        try{
            this.tabAction = (ArrayList<Action>) tabAction.clone();
        } catch(Exception e) {
            System.out.println("Aucune action dans l'equipement");
        }
    }

    /**
     * Equipe un joueur
     * @param joueurImpacte : le joueur a équiper
     * @return out : texte résumant l'action
     */
    public String equipe(Joueur joueurEmetteur, ArrayList<Joueur> joueurDestinataire, Combat combatCible, int phaseTour, Joueur joueurTourEnCours){
        String out = "";
        
        if(tabAction != null){
            out += "--- Equipement ---\n";
            
            for(Joueur joueurImpacte : joueurDestinataire){
	            out += "Un équipement vient de se déclencher sur " + joueurImpacte.getName() + " :\n";
	            for(Action action : tabAction)
	                out += action.action(joueurEmetteur, joueurDestinataire, combatCible, phaseTour, joueurTourEnCours);
	            out += "--- Fin d'equipement ---\n";
            }
        } else {
           out += "Aucun equipement !\n";
        }
        
        return out;
    }	
}