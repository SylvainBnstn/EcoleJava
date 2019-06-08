/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Annee_scolaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Sylvain
 */
public class DAO_Annee_scolaire extends DAO<Annee_scolaire> {

    public DAO_Annee_scolaire(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Annee_scolaire obj) {
        try {
         
            Statement state;        
            state=connect.createStatement();
            String query="INSERT INTO annee (Id_annee)"
                    + "VALUES( NULL)";
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;  
    }


    @Override
    public boolean delete(Annee_scolaire obj) {
        try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="DELETE FROM annee WHERE Id_annee="
                    +obj.getId_annee_scolaire();
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Annee_scolaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Annee_scolaire find(int id) {
        
        Annee_scolaire annee = new Annee_scolaire();
        try {
            ResultSet result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM annee WHERE Id_annee = " + id);
            //si on trouve l'annee dans la table
            if(result.first())
            annee = new Annee_scolaire(id);         
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    return annee;
        
    }

    @Override
    public HashMap<Integer, Annee_scolaire> show_all() {
        HashMap<Integer,Annee_scolaire> temp = new HashMap<Integer, Annee_scolaire>();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM annee";
           
           result = state.executeQuery(query);
           while(result.next()){
               int id = result.getInt("Id_annee");
               Annee_scolaire annee_sco =new Annee_scolaire (id);
               temp.put(id, annee_sco);
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
    
}
