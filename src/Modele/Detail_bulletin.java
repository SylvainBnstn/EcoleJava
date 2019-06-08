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
 * notre classe detail bulletin
 */

public class Detail_bulletin {
    int id_detail_bulletin;
    int id_bulletin;
    int id_enseignant;
    String appreciation;
    /**
     * Constructeur par default
     */
    public Detail_bulletin(){
        id_detail_bulletin=0;
        id_bulletin=0;
        id_enseignant=0;
        appreciation="";
    }
    /**
     * Constructeur surcharge
     * @param id_detail_bulletin
     * @param id_bulletin
     * @param id_enseignant
     * @param appreciation 
     */
    public Detail_bulletin(int id_detail_bulletin, int id_bulletin, int id_enseignant, String appreciation) {
        this.id_detail_bulletin = id_detail_bulletin;
        this.id_bulletin = id_bulletin;
        this.id_enseignant = id_enseignant;
        this.appreciation = appreciation;
    }

    /**
     * gette de id detaill bulletin
     * @return id_detail_bulletin
     */
    public int getId_detail_bulletin() {
        return id_detail_bulletin;
    }
/**
 * setter de id_detail_bulletin
 * @param id_detail_bulletin 
 */
    public void setId_detail_bulletin(int id_detail_bulletin) {
        this.id_detail_bulletin = id_detail_bulletin;
    }
/**
 * getter de id_bulletin
 * @return id_bulletin
 */
    public int getId_bulletin() {
        return id_bulletin;
    }
/**
 * setter de id_bulletin
 * @param id_bulletin 
 */
    public void setId_bulletin(int id_bulletin) {
        this.id_bulletin = id_bulletin;
    }
/**
 * gette de id_enseignant
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
     * affiche notre id_detail_bulletin
     * @return id_detail_bulletin
     */
        @Override
     public String toString() 
    {
        return "Detail bulletin :" + id_detail_bulletin;
    }
}
