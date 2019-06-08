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
 * cLASSE DISCIPLINE
 */
public class Discipline {
    int id_discipline;
    String nom_discipline;
    
    /**
     * Constructeur par default
     */
    public Discipline(){
        this.id_discipline = 0;
        this.nom_discipline = "";
    }
/**
 * Constructeur surchargé
 * @param id_discipline
 * @param nom_discipline 
 */
    public Discipline(int id_discipline, String nom_discipline) {
        this.id_discipline = id_discipline;
        this.nom_discipline = nom_discipline;
    }
/**
 * getter de id_discipline
 * @return id_discipline
 */
    public int getId_discipline() {
        return id_discipline;
    }
/**
 * setter de id_discipline
 * @param id_discipline 
 */
    public void setId_discipline(int id_discipline) {
        this.id_discipline = id_discipline;
    }
/**
 * getter de nom_discipline
 * @return nom_discipline
 */
    public String getNom_discipline() {
        return nom_discipline;
    }
/**
 * setter de nom discipline
 * @param nom_discipline 
 */
    public void setNom_discipline(String nom_discipline) {
        this.nom_discipline = nom_discipline;
    }
    
    
}
