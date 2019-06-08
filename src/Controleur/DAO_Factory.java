/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

//CTRL + SHIFT + O pour générer les imports

import java.sql.Connection;
import java.sql.*;
import java.util.logging.*;

public class DAO_Factory {
    
        /**
     * constante static containing the connection variable of the class
     */
    protected static final Connection conn;

    /**
     * this is a specific way to init final variable throwing exceptions
     */
    static {
        Connection tmp = null;

        try {
            // subscribe to your DriverManager as we use mysql-connector add this :
            Class.forName("com.mysql.jdbc.Driver");
            // get the connection variable
            // jdbc:mysl:// is the protocol URI (like http:// is for http)
            // localhost cause we are from a wamp server
            // ecole is the name of database
            // second parameter the id for connecting to the mysql db ( on phpmyadmin)
            // thirs parameter is the password
            String username = "root";
            String password = "";
            tmp = DriverManager.getConnection("jdbc:mysql://localhost/ecole", username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAO_Factory.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn = tmp;
    }

    public static DAO getAnneescolaireDAO() {
        return new DAO_Annee_scolaire(conn);
    }
    
    public static DAO getBulletinDAO(){
        return new DAO_Bulletin(conn);
    }
    
    public static DAO getClasseDAO(){
        return new DAO_Classe(conn);
    }
    
    public static DAO getDetailbulletinDAO(){
        return new DAO_Detail_bulletin(conn);
    }
    
    public static DAO getDisciplineDAO(){
        return new DAO_Discipline(conn);
    }
    
    public static DAO getEleveDAO(){
        return new DAO_Eleve(conn);
    }
    
    public static DAO getEnseignantDAO(){
        return new DAO_Enseignant(conn);
    }
    
    public static DAO getNiveauDAO(){
        return new DAO_Niveau(conn);
    }
    
    public static DAO getNoteDAO(){
        return new DAO_Note(conn);
    }

    public static DAO getPersonneDAO(){
        return new DAO_Personne(conn);
    }
    
    public static DAO getTrimestreDAO(){
        return new DAO_Trimestre(conn);
    }
}
