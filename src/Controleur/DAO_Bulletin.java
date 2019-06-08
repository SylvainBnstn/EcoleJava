/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Bulletin;
import Modele.Detail_bulletin;
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
public class DAO_Bulletin extends DAO<Bulletin> {

    public DAO_Bulletin(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Bulletin obj) {
        try {

            Statement state;
            state = connect.createStatement();

            String query = "INSERT INTO bulletin (Id_bulletin,Id_trimestre,Id_eleve,Appreciation) "
                    + "VALUES( NULL,'" + obj.getId_trimestre()
                    + "','" + obj.getId_eleve() + "','" + obj.getAppreciation() + "')";
            state.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Bulletin obj) {
        try {
            Statement state;
            state = connect.createStatement();



            Statement state3;
            state3 = connect.createStatement();

            Statement state4;
            state4 = connect.createStatement();


            ResultSet result2;
            ResultSet result3;

            String query2 = "SELECT Id_detail_bulletin FROM detail_bulletin WHERE Id_bulletin = " + obj.getId_bulletin();
            result2 = state3.executeQuery(query2);
            while (result2.next()) {
                int id_detail_bulletin = result2.getInt("Id_detail_bulletin");

                query2 = "SELECT Id_note FROM note WHERE Id_detail_bulletin = " + id_detail_bulletin;
                result3 = state4.executeQuery(query2);
                boolean note_delete = false;

                while (result3.next()) {
                    int id_note_delete = result3.getInt("Id_note");
                    DAO<Note> note_all = DAO_Factory.getNoteDAO();
                    Note note = new Note(id_note_delete, 0, "", 1);
                    note_delete = note_all.delete(note);
                }

                DAO<Detail_bulletin> dbull_all = DAO_Factory.getDetailbulletinDAO();
                Detail_bulletin db = new Detail_bulletin(id_detail_bulletin, obj.getId_bulletin(), 1, "");
                boolean db_delete = dbull_all.delete(db);

            }
            String query = "DELETE FROM bulletin WHERE Id_bulletin="
                    + obj.getId_bulletin();
            state.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    

    @Override
    public boolean update(Bulletin obj) {
        try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE bulletin SET Id_trimestre = '" + obj.getId_trimestre()
                    + "',Id_eleve='" + obj.getId_eleve() + "',Appreciation='" + obj.getAppreciation()
                    + "' WHERE Id_bulletin=" + obj.getId_bulletin() ;
            state.executeUpdate(query);

       
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        
                return true;
    }

    @Override
    public Bulletin find(int id) {
        Bulletin bulletin = new Bulletin();

        try {
            Statement state;
            state = connect.createStatement();
            ResultSet result;

            String query = "SELECT * FROM bulletin WHERE Id_bulletin = " + id;

            result = state.executeQuery(query);
            if (result.first()) {
                bulletin = new Bulletin(result.getInt("Id_bulletin"), result.getInt("Id_trimestre"), result.getInt("Id_eleve"), result.getString("Appreciation"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return bulletin;
    }

    @Override
    public HashMap<Integer, Bulletin> show_all() {
        HashMap<Integer,Bulletin> temp = new HashMap<Integer, Bulletin>();
        try{
           Statement state;        
           state=connect.createStatement();
           ResultSet result;
           
           String query = "SELECT * FROM bulletin";
           
           result = state.executeQuery(query);
           while(result.next()){
               int id = result.getInt("Id_bulletin");
               int id_trimestre = result.getInt("Id_trimestre");
               int id_eleve = result.getInt("Id_eleve");
               String appreciation = result.getString("Appreciation");
               Bulletin bulletin =new Bulletin (id,id_trimestre,id_eleve,appreciation);
               temp.put(id, bulletin);
           }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
}
