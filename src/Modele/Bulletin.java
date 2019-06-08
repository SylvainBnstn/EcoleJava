/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Liens avec la base de donnée
 */
package Modele;

/**
 *
 * @author Sylvain
 * La classe de notre bulletin
 */
public class Bulletin {

    int id_bulletin;
    int id_trimestre;
    int id_eleve;
    String appreciation;

    /**
     * Constructeur par default
     */
    public Bulletin() {
        this.id_bulletin = 0;
        this.id_trimestre = 0;
        this.id_eleve = 0;
        this.appreciation = "";
    }
    /**
     * 
     * @param id_bulletin
     * @param id_trimestre
     * @param id_eleve
     * @param appreciation 
     * Constructeur surcharge
     */
    public Bulletin(int id_bulletin, int id_trimestre, int id_eleve, String appreciation) {
        this.id_bulletin = id_bulletin;
        this.id_trimestre = id_trimestre;
        this.id_eleve = id_eleve;
        this.appreciation = appreciation;
    }
/**
 * gette de id_bulletin
 * @return id_bulletin
 */
    public int getId_bulletin() {
        return id_bulletin;
    }
    /**
     * Setter de id_bulletin
     * @param id_bulletin 
     */

    public void setId_bulletin(int id_bulletin) {
        this.id_bulletin = id_bulletin;
    }
/**
 * getter de id_trimestre
 * @return id_trimestre
 */
    public int getId_trimestre() {
        return id_trimestre;
    }
/**
 * Setter de id_trimestre
 * @param id_trimestre 
 */
    public void setId_trimestre(int id_trimestre) {
        this.id_trimestre = id_trimestre;
    }
    /**
     * getter de id_eleve
     * @return id_eleve
     */

    public int getId_eleve() {
        return id_eleve;
    }
    
    /**
     * setter id_eleve
     * @param id_eleve 
     */

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }
/**
 * getter de appreciation
 * @return appreciation
 */
    public String getAppreciation() {
        return appreciation;
    }
/**
 * setter de appreciation
 * @param appreciation 
 */
    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }
/**
 * affiche notre id_eleve
 * @return id_eleve
 */
    @Override
    public String toString() {
        return "Bulletin" + id_eleve;
    }
}
