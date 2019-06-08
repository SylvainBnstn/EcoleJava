/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.*;
import Modele.Eleve;
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
public class DAO_Eleve extends DAO<Eleve> {

    public DAO_Eleve(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Eleve obj) {

        try {

            Personne personne = new Personne(obj.getId_personne(), obj.getNom(), obj.getPrenom(), obj.getType());
            DAO<Personne> p = DAO_Factory.getPersonneDAO();
            if (p.create(personne)) {
                System.out.println("L eleve est ajoute dans la classse personne");
            }
            Statement state;
            state = connect.createStatement();
            ResultSet result;
            //association de la personne créé à l'enseignant
            String query = "SELECT Id_personne FROM personne WHERE Nom = '" + obj.getNom() + "' AND Prenom = '" + obj.getPrenom() + "'";
            result = state.executeQuery(query);

            if (result.next()) {
                int id = result.getInt("Id_personne");
                query = "INSERT INTO eleve (Id_eleve,Id_classe,Id_personne) "
                        + "VALUES( NULL,'" + obj.getId_classe()
                        + "','" + id + "')";
                state.executeUpdate(query);
                System.out.print(obj.getId_personne());
            } else {
                System.out.println("Personne inexistante dans la base de donnée...");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Eleve obj) {
        try {
            Statement state;
            state = connect.createStatement();

            Statement state2;
            state2 = connect.createStatement();

            Statement state3;
            state3 = connect.createStatement();

            Statement state4;
            state4 = connect.createStatement();

            Statement state5;
            state5 = connect.createStatement();

            ResultSet result;
            ResultSet result1;
            ResultSet result2;
            ResultSet result3;

            String query2 = "SELECT Id_personne FROM eleve WHERE Id_eleve = " + obj.getId_eleve();
            result = state2.executeQuery(query2);
            if (result.next()) {
                int id = result.getInt("Id_personne");

                query2 = "SELECT Id_bulletin FROM bulletin WHERE Id_eleve = " + obj.getId_eleve();
                result1 = state2.executeQuery(query2);
                while (result1.next()) {
                    int id_bulletin = result1.getInt("Id_bulletin");

                    query2 = "SELECT Id_detail_bulletin FROM detail_bulletin WHERE Id_bulletin = " + id_bulletin;
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
                        Detail_bulletin db = new Detail_bulletin(id_detail_bulletin, id_bulletin, 1, "");
                        boolean db_delete = dbull_all.delete(db);

                    }
                    DAO<Bulletin> bull_all = DAO_Factory.getBulletinDAO();
                    Bulletin bull = new Bulletin(id_bulletin, 1, 1, "");
                    boolean bull_delete = bull_all.delete(bull);
                }
                String query6 = "DELETE FROM eleve WHERE Id_eleve=" + obj.getId_eleve();
                state5.executeUpdate(query6);

                String query3 = "DELETE FROM personne WHERE Id_personne=" + id;
                state5.executeUpdate(query3);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Eleve obj) {
       Eleve temp = new Eleve();
        DAO<Eleve> e = DAO_Factory.getEleveDAO();
        temp = e.find(obj.getId_eleve());
       Personne personne = new Personne();
       DAO<Personne> p = DAO_Factory.getPersonneDAO();
       personne = p.find(temp.getId_personne());

            try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE eleve SET Id_classe = '" + obj.getId_classe()
                    +  "' WHERE Id_eleve=" + obj.getId_eleve() ;
            state.executeUpdate(query);
            
            Statement state2;
            state2 = connect.createStatement();
            System.out.println(personne.getId_personne());
            System.out.println(obj.getNom());

            String query2 = "UPDATE personne SET Nom = '" + obj.getNom() +"' ,Prenom ='"+obj.getPrenom()
                    +  "' WHERE Id_personne=" + personne.getId_personne() ;
            state2.executeUpdate(query2);

       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        
                return true;
    }

    @Override
    public Eleve find(int id) {
        Eleve eleve = new Eleve();

        try {
 
                Statement state;
                Statement state2;

                state = connect.createStatement();
                state2 = connect.createStatement();

                ResultSet result;

                String query = "SELECT * FROM eleve WHERE Id_eleve = " + id;

                result = state.executeQuery(query);

                if (result.first()) {


                    ResultSet result2;

                     int id_temp_eleve = result.getInt("Id_personne");
                    String query2 = "SELECT * FROM personne WHERE Id_personne= " + id_temp_eleve;
                    result2 = state2.executeQuery(query2);

                    if (result2.first()&&result2.getInt("Type") == 1) {

                        Eleve eleve2 = new Eleve(result2.getInt("Id_personne"), result2.getString("Nom"), result2.getString("Prenom"), result2.getInt("Type"), result.getInt("Id_eleve"), result.getInt("Id_classe"));
                        eleve = eleve2;
                    }

                }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return eleve;
    }

    @Override
    public HashMap<Integer, Eleve> show_all() {
        HashMap<Integer, Eleve> temp = new HashMap<Integer, Eleve>();
        try {
            Statement state;
            state = connect.createStatement();
            Statement state2 = connect.createStatement();
            ResultSet result;
            ResultSet result2;

            String query = "SELECT * FROM eleve";
            result = state.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("Id_eleve");
                int id_classe = result.getInt("Id_classe");
                int id_personne = result.getInt("Id_personne");
                String nom;
                String prenom;
                int type;
                String query2 = "SELECT * FROM personne WHERE Id_personne = " + id_personne;
                result2 = state2.executeQuery(query2);
                while (result2.next()) {
                    nom = result2.getString("Nom");
                    prenom = result2.getString("Prenom");
                    type = result2.getInt("Type");
                    Eleve ens = new Eleve(id_personne, nom, prenom, type, id, id_classe);
                    temp.put(id, ens);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }
    
}
