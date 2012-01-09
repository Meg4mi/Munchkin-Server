package comportement;

import java.util.ArrayList;
import action.Action;
import joueur.Joueur;


/**
 * // TODO : Commenter
 * @author Julien Rouvier
 */
public class Sortilege {
    
    private ArrayList<Action> tabAction;

    
    /**
     * Constructeur
     * @param tabAction 
     */
    public Sortilege(ArrayList<Action> tabAction) {
    	try {
            this.tabAction = (ArrayList<Action>) tabAction.clone();
        } catch(Exception e) {
            System.out.println("Aucune action dans le sort");
        }
    }

    
    /**
     * Action lors d'un sortilège
     * @param joueurImpacte : joueur recevant le sortilège
     * @return out : texte résumant l'action
     */
    public String actionSortilege(Joueur joueurImpacte){
        String out = "";
        if(tabAction == null){
            out += "Aucune sortilège à appliquer";
        } else {
            out += "----- Sortilège -----\n";
            out += "Un sortilège s'applique sur " + joueurImpacte.getName() + " :";
            for(Action action : tabAction)
                out += action.action(joueurImpacte);
            out += "\n";
            out += "--- Fin sortilège ---";
        }
        out += "\n";
        return out;
    }
}
