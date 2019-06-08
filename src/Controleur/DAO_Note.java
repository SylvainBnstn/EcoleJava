/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Note;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Sylvain
 */
public class DAO_Note extends DAO<Note>{

    public DAO_Note(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Note obj) {
        try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="INSERT INTO note (Id_note,Id_detail_bulletin,Appreciation,Note) "
                    + "VALUES( NULL,'" + obj.getId_detail_bulletin()
                    + "','" + obj.getAppreciation() + "','" 
                    + obj.getNote() + "')";
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Note obj) {
       try {
         
            Statement state;        
            state=connect.createStatement();
            
            String query="DELETE FROM note WHERE Id_note="
                    +obj.getId_note();
            state.executeUpdate(query);

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Note obj) {
        try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE note SET Id_detail_bulletin = '" + obj.getId_detail_bulletin()
                    + "',Appreciation='" + obj.getAppreciation() + "',Note='" + obj.getNote()
                    + "' WHERE Id_note=" + obj.getId_note() ;
            state.executeUpdate(query);

       
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        
                return true;
    }

    @Override
    public Note find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Note> show_all() {
        HashMap<Integer, Note> temp = new HashMap<Integer, Note>();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM note";
           
           result = state.executeQuery(query);
           while(result.next()){
               //Id_note,Id_detail_bulletin,Appreciation,Note
               int id = result.getInt("Id_note");
               int id_detail_bull = result.getInt("Id_detail_bulletin");
               String appreciation = result.getString("Appreciation");
               double note = result.getDouble("Note");
               Note note_temp =new Note(id,id_detail_bull,appreciation,note);
               temp.put(id, note_temp);
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
}
