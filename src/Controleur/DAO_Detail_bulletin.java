/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Detail_bulletin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Sylvain
 */
public class DAO_Detail_bulletin extends DAO<Detail_bulletin> {

    public DAO_Detail_bulletin(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Detail_bulletin obj) {
       try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="INSERT INTO detail_bulletin (Id_detail_bulletin,Id_bulletin,Id_enseignant,Appreciation) "
                    + "VALUES( NULL,'" + obj.getId_bulletin()
                    + "','" + obj.getId_enseignant() + "','" + obj.getAppreciation() +"')";
               state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;      
    }

    @Override
    public boolean delete(Detail_bulletin obj) {
       try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="DELETE FROM detail_bulletin WHERE Id_detail_bulletin="
                    +obj.getId_detail_bulletin();
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Detail_bulletin obj) {
         try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE detail_bulletin SET Id_bulletin = '" + obj.getId_bulletin()
                    + "',Id_enseignant='" + obj.getId_enseignant() + "',Appreciation='" + obj.getAppreciation()
                    + "' WHERE Id_detail_bulletin=" + obj.getId_detail_bulletin() ;
            state.executeUpdate(query);

       
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        
                return true; 
    }

    @Override
    public Detail_bulletin find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Detail_bulletin> show_all() {
        HashMap<Integer,Detail_bulletin> temp = new HashMap<Integer, Detail_bulletin>();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM detail_bulletin";
           
           result = state.executeQuery(query);
           while(result.next()){
               int id = result.getInt("Id_detail_bulletin");
               int id_bull = result.getInt("Id_bulletin");
               int id_enseignant = result.getInt("Id_enseignant");
               String appre = result.getString("Appreciation");
               Detail_bulletin bull =new Detail_bulletin (id,id_bull,id_enseignant,appre);
               temp.put(id, bull);
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
}
