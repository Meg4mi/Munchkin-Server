package comportement;

import action.Action;
import java.util.ArrayList;

import partie.Partie;
import joueur.Joueur;


/**
 * Classe permettant de déclencher les incidents fâcheux
 * @author Rémi Marenco
 */
public class IncidentFacheux extends Comportement{

    /**
     * Constructeur
     * On définit les actions que va faire l'incident fâcheux
     * @param tab : Ensemble d'actions de l'incident fâcheux
     */
    public IncidentFacheux(ArrayList<Action> tabAction){
    	super(tabAction);
    }

    
    /**
     * Application de l'ensemble des actions de l'incident fâcheux sur le joueur
     * @param joueurEmetteur
     * @param joueurDestinataire
     * @param partie
     */
    @Override
    public String action(Joueur joueurEmetteur,
                    ArrayList<Joueur> joueurDestinataire, Partie partie) {
            String out = "";
        if(tabAction != null && !(tabAction.isEmpty())){
            out += "--- Incident fâcheux ---\n";
            out += "Il y a " + tabAction.size() + "actions !";
            for(Action action : tabAction)
                    out += "\nAction : !" + action.action(joueurEmetteur, joueurDestinataire, partie);
            out += "--- Fin d'incident fâcheux ---\n";
        } else {
            out += "Aucune incident fâcheux !!\n";
        }
        return out;
    }


    @Override
    public String action(Joueur joueurEmetteur,
                    ArrayList<Joueur> joueurDestinataire, Partie partie,
                    boolean choixJoueur) {
        String out = "";
        if(tabAction != null && !(tabAction.isEmpty()))
        {
                out += "--- Incident fâcheux ---\n";
                out += "Il y a " + tabAction.size() + "actions !";
                for(Action action : tabAction)
                        out += "\nAction : !" + action.action(joueurEmetteur, joueurDestinataire, partie, choixJoueur);
                out += "--- Fin d'incident fâcheux ---\n";
        } else {
                out += "Aucune incident fâcheux !!\n";
        }
        return out;
    }
}
