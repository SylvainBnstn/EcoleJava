/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Personne;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Sylvain
 */
public class DAO_Personne extends DAO<Personne> {

    public DAO_Personne(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Personne obj) {
        try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="INSERT INTO personne (Id_personne,Nom,Prenom,Type) "
                    + "VALUES( NULL,'" + obj.getNom()
                    + "','" + obj.getPrenom() + "','" + obj.getType() +"')";
               state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Personne obj) {
      try {
            Statement state;        
            state=connect.createStatement();
            
            Statement state2;
            state2 = connect.createStatement();
            
            Statement state3;
            state3 = connect.createStatement();
            
            ResultSet result;
            
            String query2 = "SELECT type FROM personne WHERE Id_personne = " + obj.getId_personne() ;
            result = state2.executeQuery(query2);
            if (result.next()) {
                int type = result.getInt("Type");
                if(type==1){
                    String query="DELETE FROM eleve WHERE Id_personne="+obj.getId_personne();
                            state.executeUpdate(query);
                            String query3="DELETE FROM personne WHERE Id_personne="+obj.getId_personne();
                            state3.executeUpdate(query3);
                }
                if(type==2){
                    String query="DELETE FROM enseignant WHERE Id_personne="+obj.getId_personne();
                            state.executeUpdate(query);
                            String query3="DELETE FROM personne WHERE Id_personne="+obj.getId_personne();
                            state3.executeUpdate(query3);
                }
                            
            }

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Personne obj) {
         try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE personne SET Nom = '" + obj.getNom()
                    + "',Prenom='" + obj.getPrenom() + "',Type='" + obj.getType()
                    + "' WHERE Id_personne=" + obj.getId_personne() ;
            state.executeUpdate(query);

       
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        
                return true;
    }

    @Override
    public Personne find(int id) {
        Personne personne = new Personne();

        try {
            Statement state;
            state = connect.createStatement();
            ResultSet result;

            String query = "SELECT * FROM personne WHERE Id_personne = " + id;

            result = state.executeQuery(query);
            if (result.first()) {
                personne = new Personne(result.getInt("Id_personne"), result.getString("Nom"), result.getString("Prenom"), result.getInt("Type"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return personne;

    }

    @Override
    public HashMap<Integer, Personne> show_all() {
               HashMap<Integer,Personne> temp = new HashMap<Integer, Personne>();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM personne";
           
           result = state.executeQuery(query);
           while(result.next()){
               int id_personne = result.getInt("Id_personne");
               String nom = result.getString("Nom");
               String prenom = result.getString("Prenom");
               int type = result.getInt("Type");
               Personne pers=new Personne (id_personne,nom,prenom,type);
               temp.put(id_personne, pers);
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
}
