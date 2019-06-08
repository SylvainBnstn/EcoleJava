/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Discipline;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Sylvain
 */
public class DAO_Discipline extends DAO<Discipline> {

    public DAO_Discipline(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Discipline obj) {

     try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="INSERT INTO discipline (Id_discipline,Nom) "
                    + "VALUES( NULL,'" + obj.getNom_discipline()
                    + "')";
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    

    @Override
    public boolean delete(Discipline obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="DELETE FROM discipline WHERE Id_discipline="
                    +obj.getId_discipline();
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Discipline obj) {
             try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE discipline SET Nom = '" + obj.getNom_discipline()
                    + "' WHERE Id_discipline=" + obj.getId_discipline() ;
            state.executeUpdate(query);

       
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        
                return true;  
    }

    @Override
    public Discipline find(int id) {
        Discipline discipline = new Discipline();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM discipline WHERE Id_discipline = " + id;
           
           result = state.executeQuery(query);
           if(result.first()){
               discipline = new Discipline(result.getInt("Id_discipline"),result.getString("Nom"));
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return discipline;
    }
    
    @Override
    public HashMap<Integer, Discipline> show_all(){
        HashMap<Integer,Discipline> temp = new HashMap<Integer, Discipline>();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM discipline";
           
           result = state.executeQuery(query);
           while(result.next()){
               int id = result.getInt("Id_discipline");
               String nom = result.getString("Nom");
               Discipline disc=new Discipline(id,nom);
               temp.put(id, disc);
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
}
