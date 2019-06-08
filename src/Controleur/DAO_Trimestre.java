/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Trimestre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Sylvain
 */
public class DAO_Trimestre extends DAO<Trimestre>{

    public DAO_Trimestre(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Trimestre obj) {
        try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="INSERT INTO trimestre (IdTrimestre,Numero,Debut,Fin,Id_annee) "
                    + "VALUES( NULL,'" + obj.getNumero()
                    + "','" + obj.getDebut() + "','" 
                    + obj.getFin() +"','" 
                    + obj.getId_annee()+ "')";
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Trimestre obj) {
       try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="DELETE FROM trimestre WHERE Idtrimestre="
                    +obj.getId_trimestre();
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Trimestre obj) {
        try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE trimestre SET Numero = '" + obj.getNumero()
                    + "',Debut='" + obj.getDebut() 
                    + "',Fin='" + obj.getFin()+ "',Id_annee='"  
            + obj.getId_annee()+"' WHERE IdTrimestre=" + obj.getId_trimestre() ;
            state.executeUpdate(query);

       
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        
                return true;  
    }

    @Override
    public Trimestre find(int id) {
        Trimestre trimestre = new Trimestre();

        try {
            Statement state;
            state = connect.createStatement();
            ResultSet result;

            String query = "SELECT * FROM trimestre WHERE IdTrimestre = " + id;

            result = state.executeQuery(query);
            if (result.first()) {
                trimestre = new Trimestre(result.getInt("IdTrimestre"), result.getInt("Numero"), result.getInt("Debut"), result.getInt("Fin"), result.getInt("Id_annee"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return trimestre;
    }

    @Override
    public HashMap<Integer, Trimestre> show_all() {
       HashMap<Integer, Trimestre> temp = new HashMap<Integer, Trimestre>();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM trimestre";
           
           result = state.executeQuery(query);
           while(result.next()){
               int id = result.getInt("IdTrimestre");
               int numero = result.getInt("Numero");
               int debut = result.getInt("Debut");
               int fin = result.getInt("Fin");
               int id_annee = result.getInt("Id_annee");
               Trimestre trim=new Trimestre(id,numero,debut,fin,id_annee);
               temp.put(id, trim);
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
}
