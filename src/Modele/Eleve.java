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
 * Classe eleve qui herite de notre classe personne
 */
public class Eleve extends Personne{
    int id_eleve;
    int id_classe;

    /**
     * Constructeur par default
     */
    public Eleve(){
        this.id_eleve=0;
        this.id_classe=0;

    }
/**
 * Constructeur surchargé
 * @param id_personne
 * @param nom
 * @param prenom
 * @param type
 * @param id_eleve
 * @param id_classe 
 */
    public Eleve(int id_personne, String nom, String prenom, int type, int id_eleve, int id_classe) {
        super(id_personne, nom, prenom, type);
        this.id_eleve = id_eleve;
        this.id_classe = id_classe;
    }
/**
 * getter de id_eleve
 * @return id_eleve
 */
    public int getId_eleve() {
        return id_eleve;
    }
/**
 * setter de id_eleve
 * @param id_eleve 
 */
    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }
/**
 * getter id_classe
 * @return id_clase
 */
    public int getId_classe() {
        return id_classe;
    }
/**
 * setter id_classe
 * @param id_classe 
 */
    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }
/**
 * Affiche notre id_eleve
 * @return id_eleve
 */
    @Override
    public String toString() 
    {
        return "Eleve" + "no" + id_eleve + super.toString();
    }
    
    
}
