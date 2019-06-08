/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Bulletin;
import Modele.Detail_bulletin;
import Modele.Enseignant;
import Modele.Note;
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
public class DAO_Enseignant extends DAO<Enseignant>{

    public DAO_Enseignant(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Enseignant obj) {

        try {
         Personne personne = new Personne(obj.getId_personne(),obj.getNom(),obj.getPrenom(), obj.getType());
         DAO<Personne> p = DAO_Factory.getPersonneDAO();
        if(p.create(personne))
        {
             System.out.println("L'enseignant est ajoute dans la classe personne");
        }
            Statement state;        
            state=connect.createStatement();
            ResultSet result;
            //association de la personne créé à l'enseignant
            String query="SELECT Id_personne FROM personne WHERE Nom = '"+ obj.getNom() +"' AND Prenom = '"+ obj.getPrenom() +"'";
            result = state.executeQuery(query);
            
           if(result.next()){
                int id = result.getInt("Id_personne");
                query = "INSERT INTO enseignant (Id_enseignant,Id_classe,Id_discipline,Id_personne) "
                        + "VALUES( 0,'" + obj.getId_classe()
                        + "','" + obj.getId_discipline() + "','" + id + "')";
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
    public boolean delete(Enseignant obj) {
        try {
            Statement state;
            state = connect.createStatement();

            Statement state2;
            state2 = connect.createStatement();

            Statement state5;
            state5 = connect.createStatement();

            ResultSet result;


            String query2 = "SELECT Id_personne FROM enseignant WHERE Id_enseignant = " + obj.getId_enseignant();
            result = state2.executeQuery(query2);
            if (result.next()) {
                int id = result.getInt("Id_personne");
                String query6 = "DELETE FROM enseignant WHERE Id_enseignant=" + obj.getId_enseignant();
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
    public boolean update(Enseignant obj) {
        Enseignant temp = new Enseignant();
        DAO<Enseignant> e = DAO_Factory.getEnseignantDAO();
        temp = e.find(obj.getId_enseignant());
       Personne personne = new Personne();
       DAO<Personne> p = DAO_Factory.getPersonneDAO();
       personne = p.find(temp.getId_personne());

            try {
            Statement state;
            state = connect.createStatement();

            String query = "UPDATE enseignant SET Id_classe = '" + obj.getId_classe()+"', Id_discipline = '"+ obj.getId_discipline()
                    +  "' WHERE Id_enseignant=" + obj.getId_enseignant() ;
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
    public Enseignant find(int id) {
        Enseignant enseignant = new Enseignant();

        try {
 
                Statement state;
                Statement state2;

                state = connect.createStatement();
                state2 = connect.createStatement();

                ResultSet result;

                String query = "SELECT * FROM enseignant WHERE Id_enseignant = " + id;

                result = state.executeQuery(query);

                if (result.first()) {


                    ResultSet result2;

                    int id_temp_eleve = result.getInt("Id_personne");
                    String query2 = "SELECT * FROM personne WHERE Id_personne= " + id_temp_eleve;
                    result2 = state2.executeQuery(query2);

                    if (result2.first()&&result2.getInt("Type") == 2) {

                        Enseignant enseignant2 = new Enseignant(result2.getInt("Id_personne"), result2.getString("Nom"), result2.getString("Prenom"), result2.getInt("Type"), result.getInt("Id_enseignant"), result.getInt("Id_classe"), result.getInt("Id_discipline"));
                        enseignant = enseignant2;
                    }

                }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return enseignant;
    }

    @Override
    public HashMap<Integer, Enseignant> show_all() {
        HashMap<Integer, Enseignant> temp = new HashMap<Integer, Enseignant>();
        try {
            Statement state;
            state = connect.createStatement();
            Statement state2 = connect.createStatement();
            ResultSet result;
            ResultSet result2;

            String query = "SELECT * FROM enseignant";
            result = state.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("Id_enseignant");
                int id_classe = result.getInt("Id_classe");
                int id_discipline = result.getInt("Id_discipline");
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
                    Enseignant ens = new Enseignant(id_personne, nom, prenom, type, id, id_classe, id_discipline);
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
