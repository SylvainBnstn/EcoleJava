/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Liens avce laBDD
 */
package Modele;

/**
 *
 * @author Sylvain
 * Classe note
 */
public class Note {
    int id_note;
    int id_detail_bulletin;
    String appreciation;
    double note;
    
    /**
     * Constructeur par default
     */
    public Note(){
        this.id_note=0;
        this.id_detail_bulletin=0;
        this.appreciation="";
        this.note=0;
    }
    
    /**
     * Constructeur surchargé
     * @param id_note
     * @param id_detail_bulletin
     * @param appreciation
     * @param note 
     */

    public Note(int id_note, int id_detail_bulletin, String appreciation, double note) {
        this.id_note = id_note;
        this.id_detail_bulletin = id_detail_bulletin;
        this.appreciation = appreciation;
        this.note = note;
    }
/**
 * getter de id_note
 * @return id_note
 */
    public int getId_note() {
        return id_note;
    }
/**
 * setter de id_note
 * @param id_note 
 */
    public void setId_note(int id_note) {
        this.id_note = id_note;
    }
/**
 * getter de id_detail_bulletin
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
 * getter de note
 * @return note
 */
    public double getNote() {
        return note;
    }
    
/**
 * setter de note
 * @param note 
 */
    public void setNote(double note) {
        this.note = note;
    }
    
    
}
