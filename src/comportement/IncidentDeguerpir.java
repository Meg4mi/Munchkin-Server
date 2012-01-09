package comportement;

import java.util.ArrayList;
import action.Action;
import joueur.Joueur;


/**
 * Incident qui intervient lorqu'un personnage déguerpit d'un combat
 * @author Simon Grabit
 */
public class IncidentDeguerpir {

    public ArrayList<Action> tabAction;

    /**
     * Constructeur
     * @param tabAction 
     */
    public IncidentDeguerpir(ArrayList<Action> tabAction) {
        try {
                this.tabAction = (ArrayList<Action>) tabAction.clone();
        } catch(Exception e){
                System.out.println("Aucune action dans l'incident déguerpir");
        }
    }

    /**
     * Applique un incident lors d'un déguerpissage
     * @param joueurImpacte
     * @return 
     */
    public String actionIncidentDeguerpir(Joueur joueurImpacte, java.lang.StackTraceElement[] nomPhase, Joueur joueurEnCours){
        String out = "";
        out += "--- Incident de fuite ---\n";
        out += "Le joueur a fuit mais subit des incidents\n";
        for(Action action : tabAction)
            out += action.action(joueurImpacte, nomPhase, joueurEnCours);
        out += "--- Fin d'incident fuite ---\n";
        return out;
    }
}
