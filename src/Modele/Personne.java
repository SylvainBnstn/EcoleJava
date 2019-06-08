/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Liens avce la BDD
 */
package Modele;

/**
 *
 * @author Sylvain
 * notre clase personne
 */
public class Personne {
    int id_personne;
    String nom;
    String prenom;
    int type;
    /**
     * constructeur par default
     */
    public Personne(){
        this.id_personne=0;
        this.nom="";
        this.prenom="";
        this.type=0;
    }
/**
 * Constructeur surchargé
 * @param id_personne
 * @param nom
 * @param prenom
 * @param type 
 */
    public Personne(int id_personne, String nom, String prenom, int type) {
        this.id_personne = id_personne;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }
/**
 * getter de id_personne
 * @return id_personne
 */
    public int getId_personne() {
        return id_personne;
    }
/**
 * setter de id_personne
 * @param id_personne 
 */
    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }
/**
 * getter de nom
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
 * getter de prenom
 * @return prenom
 */
    public String getPrenom() {
        return prenom;
    }
/**
 * setter de prenom
 * @param prenom 
 */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
/**
 * getter de type
 * @return type
 */
    public int getType() {
        return type;
    }
/**
 * setter de type
 * @param type 
 */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * Affiche nom prenom et type
     * @return nom prenom et type
     * 
     */
    @Override
    public String toString() 
    {
        return "Personne : " + nom + prenom + type;
    }
    
}
