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
 * Classe trimestre
 */
public class Trimestre {
    int id_trimestre;
    int numero;
    int debut;
    int fin;
    int id_annee;
    /**
     * Constructeur par default
     */
    public Trimestre(){
        this.id_trimestre=0;
        this.numero=0;
        this.debut=0;
        this.fin=0;
        this.id_annee=0;
    }
/**
 * Constructeur surchargé
 * @param id_trimestre
 * @param numero
 * @param debut
 * @param fin
 * @param id_annee 
 */
    public Trimestre(int id_trimestre, int numero, int debut, int fin, int id_annee) {
        this.id_trimestre = id_trimestre;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.id_annee = id_annee;
    }

    /**
     * getter de id_trimestre
     * @return id_trimestre
     */
    public int getId_trimestre() {
        return id_trimestre;
    }
/**
 * setter de id_trimestre
 * @param id_trimestre 
 */
    public void setId_trimestre(int id_trimestre) {
        this.id_trimestre = id_trimestre;
    }
    /**
     * getter de numero
     * @return numero
     */

    public int getNumero() {
        return numero;
    }
/**
 * setter de numero
 * @param numero 
 */
    public void setNumero(int numero) {
        this.numero = numero;
    }
/**
 * getter de debut
 * @return debut
 */
    public int getDebut() {
        return debut;
    }
/**
 * setter de debut
 * @param debut 
 */
    public void setDebut(int debut) {
        this.debut = debut;
    }
/**
 * getter de fin
 * @return fin
 */
    public int getFin() {
        return fin;
    }
/**
 * setter de fin
 * @param fin 
 */
    public void setFin(int fin) {
        this.fin = fin;
    }
/**
 * getter de id_annee
 * @return id_annee
 */
    public int getId_annee() {
        return id_annee;
    }
/**
 * setter de id_annee
 * @param id_annee 
 */
    public void setId_annee(int id_annee) {
        this.id_annee = id_annee;
    }
    
    
    
}
