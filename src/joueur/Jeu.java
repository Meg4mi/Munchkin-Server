package joueur;

import carte.Carte;
import java.util.ArrayList;

public class Jeu extends CartesJoueur{
    
    @Override
    public boolean ajouterCarte(Carte c) {
        if(super.ajouterCarte(c)){
            // Appliquer la classe, la race, etc...
            
            
            return true;
        }else{
            return false;
        }
    }
    
    public boolean atteintMaxEquipement(){
       for(int i = 0; i<this.cartes.size(); i++){
          
       } 
       return false;
    }

    public ArrayList<Carte> getJeu() {
        return this.cartes;
    }    
}
