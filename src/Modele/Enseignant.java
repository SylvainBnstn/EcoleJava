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
 * classe enseignant qui herite de la classe personne
 */
public class Enseignant  extends Personne {
    int id_enseignant;
    int id_classe;
    int id_discipline;
    /**
     * Constructeur par default
     */
    public Enseignant(){
        this.id_enseignant=0;
        this.id_classe=0;
        this.id_discipline=0;
    }
/**
 * Constructeur surchargé
 * @param id_personne
 * @param nom
 * @param prenom
 * @param type
 * @param id_enseignant
 * @param id_classe
 * @param id_discipline 
 */
    public Enseignant(int id_personne,String nom, String prenom, int type, int id_enseignant, int id_classe, int id_discipline) {
        super(id_personne,nom,prenom,type);
        this.id_enseignant = id_enseignant;
        this.id_classe = id_classe;
        this.id_discipline = id_discipline;
    }
/**
 * getter de id_enseignant
 * @return id_enseignant
 */
    public int getId_enseignant() {
        return id_enseignant;
    }
/**
 * setter de id_enseignant
 * @param id_enseignant 
 */
    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }
/**
 * getter de id_classe
 * @return id_classe
 */
    public int getId_classe() {
        return id_classe;
    }
/**
 * setter de id_classe
 * @param id_classe 
 */
    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
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
 * affiche l'id enseignant
 * @return id_enseignant
 */
    @Override
    public String toString() 
    {
        return "Enseignant" + id_enseignant + super.toString();
    }
    
}
