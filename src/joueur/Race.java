package joueur;


/**
 * Classe abstraite étendue par toutes les races
 * @author Julien Rouvier
 */
public abstract class Race {
	
    /**
     * Constructeur
     */
    public Race(){

    }

    
    /**
     * 
     * @param personnage 
     */
    public abstract void modifPersonnage(Personnage personnage);

    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return this.getClass().toString();
    }
}
