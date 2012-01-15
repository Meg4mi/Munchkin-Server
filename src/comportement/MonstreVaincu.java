package comportement;

import java.util.ArrayList;

import partie.Partie;
import action.Action;
import joueur.Joueur;


/**
 * Applique un ensemble d'action lorsqu'un monstre est vaincu
 * @author Simon Grabit
 */
public class MonstreVaincu extends Comportement{    
    /**
     * Constructeur
     * @param tabAction 
     */
    public MonstreVaincu(ArrayList<Action> tabAction){
        super(tabAction);
    }
	
    
    /**
     * Action lorsqu'un monstre est vaincu
     * @param joueurImpacte : joueur ayant vaincu le monstre
     * @return 
     */
	@Override
	public String action(Joueur joueurEmetteur,
			ArrayList<Joueur> joueurDestinataire, Partie partie) {
		String out = "";

        if(tabAction == null) {
            out += "Aucune condition sur ce monstre\n";
        } else {
            out += "--- Monstre Vaincu ---\n";
            for(Joueur joueurImpacte : joueurDestinataire){
	            out += "Une action monstre vaincu vient de se déclencher sur " + joueurImpacte.getName() + " :\n";
	            for(Action action : tabAction)
	                out += action.action(joueurEmetteur, joueurDestinataire, partie);
            }
            out += "\n--- Fin de monstre vaincu ---";
        }
        out += "\n";    
        return out;
	}
}
