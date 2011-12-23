package comportement;

import action.Action;

import java.util.ArrayList;
import joueur.Joueur;


/**
 * Classe permettant de déclencher les incidents fâcheux
 * @author Rémi Marenco
 */
public class IncidentFacheux {

    /**
     * Vecteur d'action. Permet de définir un ensemble d'action à effectuer sur un incident fâcheux
     */
    public ArrayList<Action> tabAction;

    /**
     * Constructeur de la classe.
     * On définit les actions que va faire l'incident fâcheux
     * @param tab => Ensemble d'actions de l'incident fâcheux
     */
    public IncidentFacheux(ArrayList<Action> tabAction)
    {
    	try
		{
			this.tabAction = (ArrayList<Action>) tabAction.clone();
		}
		catch(Exception e)
		{
			System.out.println("Aucune action dans l'incident fâcheux");
		}
    }

    /**
     * Application de l'ensemble des actions de l'incident fâcheux sur le joueur
     * @param joueurImpacte
     */
    public String actionIncidentFacheux(Joueur joueurImpacte)
    {
        String out = "";
        if(tabAction != null || !(tabAction.isEmpty()))
        {
            out += "--- Incident facheux ---\n";
            out += "Un incident facheux vient de se déclencher sur " + joueurImpacte.getName() + " :\n";
            out += "Il y a " + tabAction.size();
            for(Action action : tabAction)
            {
                out += "\nAction : !";
                out += action.action(joueurImpacte);
            }
            out += "--- Fin d'incident facheux ---\n";
        }
        else
        {
            out += "Aucune incident fâcheux !!\n";
        }

        return out;
    }

}
