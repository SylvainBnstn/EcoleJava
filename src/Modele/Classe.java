/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Liens avce notre BDD
 */
package Modele;

/**
 *
 * @author Sylvain
 * Notre lcasse classe
 */
public class Classe {
    int id_classe;
    int id_niveau;
    String nom;
    int id_annee;
    /**
     * Constructeur par default
     */
    
    public Classe(){
        this.id_classe=0;
        this.id_niveau=0;
        this.nom="";
        this.id_annee=0;
    }
/**
 * Constructeur surchargé
 * @param id_classe
 * @param id_niveau
 * @param nom
 * @param id_annee 
 */
    public Classe(int id_classe, int id_niveau, String nom, int id_annee) {
        this.id_classe = id_classe;
        this.id_niveau = id_niveau;
        this.nom = nom;
        this.id_annee = id_annee;
    }

    /**
     * getter de notre id_classe
     * @return id_classe
     */
    public int getId_classe() {
        return id_classe;
    }
/**
 * Setter de notre id_classe
 * @param id_classe 
 */
    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }
/**
 * getter de notre id_niveau
 * @return id_niveau
 */
    public int getId_niveau() {
        return id_niveau;
    }
    /**
     * setter de id_niveau
     * @param id_niveau 
     */

    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }
/**
 * getter du nom de la classe
 * @return nom
 */
    public String getNom() {
        return nom;
    }
/**
 * setter de nom
 * @param nom 
 */
    public void setNom(String nom) {
        this.nom = nom;
    }
/**
 * getter de id_annee
 * @return id_annee
 */
    public int getId_Annee() {
        return id_annee;
    }
/**
 * setter de id_annee
 * @param id_annee 
 */
    public void setId_annee(int id_annee) {
        this.id_annee = id_annee;
    }
    /**
     * affiche le nom de notre classe
     * @return nom
     */
    @Override
    public String toString() 
    {
        return "Annee" + nom + toString();
    }
}
