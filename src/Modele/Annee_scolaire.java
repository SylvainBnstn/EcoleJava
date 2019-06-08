/**
 * Liens avce la base de donnée
 * 
 */
package Modele;

/**
 *
 * @author Sylvain
 * Notre classe annee avce son id  
 */
public class Annee_scolaire {
    private int id_annee_scolaire;
    
    /**
     * Constructeur par default
     */
    public Annee_scolaire(){
        id_annee_scolaire=0;
    }

    /**
     * 
     * Constructeur surcharge
     * @param id_annee_scolaire 
     */
    public Annee_scolaire(int id_annee_scolaire) {
        this.id_annee_scolaire = id_annee_scolaire;
    }

    /**
     * getter de annee 
     * @return id_annee_scolaire
     */
    public int getId_annee_scolaire() {
        return id_annee_scolaire;
    }

    /**
     * 
     * @param id_annee_scolaire 
     * Initialise notre id annee
     */
    public void setId_annee_scolaire(int id_annee_scolaire) {
        this.id_annee_scolaire = id_annee_scolaire;
    }
    
    
}
