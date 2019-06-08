/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Classe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Sylvain
 */
public class DAO_Classe extends DAO<Classe> {

    public DAO_Classe(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Classe obj) {
         try {
         
            Statement state;        
            state=connect.createStatement();

            String query="INSERT INTO classe (Id_classe,Id_niveau,Nom,Id_annee) "
                    + "VALUES( NULL,'" + obj.getId_niveau()
                    + "','" + obj.getNom() + "','" + obj.getId_Annee() + "')";
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Classe obj) {
       try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="DELETE FROM classe WHERE Id_classe="
                    +obj.getId_classe();
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Classe obj) {
        try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE classe SET Id_niveau = '" + obj.getId_niveau()
                    + "',Nom='" + obj.getNom() + "',Id_annee='" + obj.getId_Annee()
                    + "' WHERE Id_classe=" + obj.getId_classe() ;
            state.executeUpdate(query);

       
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        
                return true;
    }

    @Override
    public Classe find(int id) {
       Classe classe = new Classe();

        try {
            Statement state;
            state = connect.createStatement();
            ResultSet result;

            String query = "SELECT * FROM classe WHERE Id_classe = " + id;

            result = state.executeQuery(query);
            if (result.first()) {
                classe = new Classe(result.getInt("Id_classe"), result.getInt("Id_niveau"), result.getString("Nom"), result.getInt("Id_annee"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return classe;
    }

    @Override
    public HashMap<Integer, Classe> show_all() {
HashMap<Integer,Classe> temp = new HashMap<Integer, Classe>();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM classe";
           
           result = state.executeQuery(query);
           while(result.next()){
               int id = result.getInt("Id_classe");
               int id_niveau = result.getInt("Id_niveau");
               int id_annee = result.getInt("Id_annee");
               String nom = result.getString("Nom");
               Classe classe =new Classe (id,id_niveau,nom,id_annee);
               temp.put(id, classe);
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
}
