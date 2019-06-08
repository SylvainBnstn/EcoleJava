/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Niveau;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Sylvain
 */
public class DAO_Niveau extends DAO<Niveau>{

    public DAO_Niveau(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Niveau obj) {
        try {
         
            Statement state;        
            state=connect.createStatement();
            String query="INSERT INTO niveau (Id_niveau,Nom) "
                    + "VALUES( NULL,'" + obj.getNom()
                    + "')";
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;  
    }

    @Override
    public boolean delete(Niveau obj) {
       try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="DELETE FROM niveau WHERE Id_niveau="
                    +obj.getId_niveau();
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Niveau obj) {
try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE niveau SET Nom = '" + obj.getNom()
                    + "' WHERE Id_niveau=" + obj.getId_niveau() ;
            state.executeUpdate(query);

       
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        
                return true;
                    }

    @Override
    public Niveau find(int id) {
        Niveau niveau = new Niveau();

        try {
            Statement state;
            state = connect.createStatement();
            ResultSet result;

            String query = "SELECT * FROM niveau WHERE Id_niveau = " + id;

            result = state.executeQuery(query);
            if (result.first()) {
               niveau = new Niveau(result.getInt("Id_niveau"), result.getString("Nom"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return niveau;
    }

    @Override
    public HashMap<Integer, Niveau> show_all() {
        HashMap<Integer, Niveau> temp = new HashMap<Integer, Niveau>();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM niveau";
           
           result = state.executeQuery(query);
           while(result.next()){
               int id = result.getInt("Id_niveau");
               String nom = result.getString("Nom");
               Niveau niv=new Niveau(id,nom);
               temp.put(id, niv);
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
}
