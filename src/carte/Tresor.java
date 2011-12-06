package carte;


/**
 * Classe Trésor.
 * Hérite de la classe Carte.
 * @author Rémi Marenco
 */
public class Tresor extends Carte {
        /**
         * Constructeur de la classe Tresor.
         * Enregistre les paramètres de la classe carte ainsi que l'équipement
         * @param nom
         * @param description
         * @param equipement
         */
	public Tresor(String nom, String description, int id) {
            this.nom = nom;
            this.description = description;
            this.id = id;
	}
}
