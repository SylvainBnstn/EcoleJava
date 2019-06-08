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
 * classe niveau
 */
public class Niveau {
    int id_niveau;
    String nom;
    /**
     * Constructeur surchargé
     */
    
    public Niveau(){
        id_niveau=0;
        nom="";
    }
/**
 * Constructeur surchargé
 * @param id_niveau
 * @param nom 
 */
    public Niveau(int id_niveau, String nom) {
        this.id_niveau = id_niveau;
        this.nom = nom;
    }
/**
 * getter id_niveau
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
    
    
}
