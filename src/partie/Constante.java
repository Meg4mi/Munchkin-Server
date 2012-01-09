package partie;

import carte.Donjon;
import carte.Tresor;
import joueur.Classe;
import joueur.Elfe;
import joueur.Guerrier;
import joueur.Halfelin;
import joueur.Humain;
import joueur.Magicien;
import joueur.Nain;
import joueur.Pretre;
import joueur.Race;
import joueur.Voleur;

import java.util.Random;

/**
 * // TODO : Commenter
 * @author Julien Rouvier
 */
public class Constante {
    
    /**
     * Type de pioche
     */
    public static final int NB_PAR_DE           = -1;
    public static final int NB_TOUT             = -2;
    public static final int NB_TOUT_CONCERNE    = -3;
    
    public static final Class TRESOR = Tresor.class;
    public static final Class DONJON = Donjon.class;
    
    /**
     * Type de sexe
     */
    public static final int SEXE_M = 1;
    public static final int SEXE_F = 2;
    
    /**
     * Races
     */
    public static final Race RACE_HUMAINE   = new Humain();
    public static final Race RACE_ELFE      = new Elfe();
    public static final Race RACE_NAIN      = new Nain();
    public static final Race RACE_HALFELIN  = new Halfelin();
    
    /**
     * Classes
     */
    public static final Classe CLASSE_PRETRE    = new Pretre();
    public static final Classe CLASSE_VOLEUR    = new Voleur();
    public static final Classe CLASSE_GUERRIER  = new Guerrier();
    public static final Classe CLASSE_MAGICIEN  = new Magicien();
    
    public static final int CARTE_OBJET     = 1;
    public static final int CARTE_SORT      = 2;
    public static final int CARTE_RACE      = 3;
    public static final int CARTE_CLASSE    = 4;
    
    public static final int MAIN        = 1;
    public static final int JEU         = 2;
    public static final int TAS_CHOISIR = 3;
    
    /**
     * TYPE D'ACTION
     */
    
    public static final int ACTION_POSERCARTE   = 1;
    public static final int ACTION_AIDER        = 2;
    public static final int ACTION_RACE         = 3;
    public static final int ACTION_POURRIR      = 4;
    public static final int ACTION_DEFAUSSER    = 5;
    
     /**
     * Constante Son
     */
    public static final int SOUND_INCIDENTFACHEUX   = 101;
    public static final int SOUND_COMBATGAGNE       = 102;
    public static final int SOUND_COMBATPERDU       = 103;
    public static final int SOUND_MONSTREFORT       = 104;
    public static final int SOUND_MORT              = 105;
    public static final int SOUND_RIRES             = 106;
    
    /**
     * Génère un nombre aléatoire entre min inclus et max exlus
     */
    public static int nbAleatoire(int min, int max){
    	int valeur;
    	Random r = new Random();
        if(max != min)
            valeur = min + r.nextInt(Math.abs(max - min));
        else
            valeur = 0;
        return valeur;
    }
    
}
