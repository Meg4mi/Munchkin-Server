package carte;

import comportement.classes.Condition;
import comportement.classes.IncidentFacheux;

/**
 * Classe Monstre.
 * Permet de créer des monstres.
 * Hérite de la classe Donjon
 * @author Rémi Marenco
 */
public class Monstre extends Donjon {
    protected int puissance;
    // TODO : Comportement monstre vaincu

    /**
     * Constructeur de la classe Monstre. Hérite de la classe Donjon
     * @param nom
     * @param description
     * @param condition
     * @param incidentFacheux
     */
    public Monstre(String nom, String description, Condition condition, IncidentFacheux incidentFacheux, int puissance) {
        super(nom, description);
        this.condition = condition;
        this.incidentFacheux = incidentFacheux;
        this.puissance = puissance;
    }
    
    public boolean appliquerIncidentsFacheux(){
        
        return true;
    }

}
