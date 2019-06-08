/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import Controleur.*;
import Modele.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meuni
 */
public class Suppression {
    
     /**
     * ///METHODE CHOIX DE CLASSE OU EFFECTUER UNE suppression
     */
    public static void choix_classe_suppr() {
        JFrame frame_choix_suppr = new JFrame();
        frame_choix_suppr.setSize(900, 900);
        frame_choix_suppr.setLocation(450, 100);
        frame_choix_suppr.setTitle("choix classe suppression ");
        frame_choix_suppr.setVisible(true);

        //Affichage label question dans un deuxieme panel
        Font font = new Font("Courier", Font.BOLD, 20);
        frame_choix_suppr.setFont(font);
        JLabel question = new JLabel("Dans quelle classe voulez vous effectuuer une suppression ?", JLabel.CENTER);
        JPanel p0 = new JPanel();
        p0.add(question);
        frame_choix_suppr.add(p0);

        //affichage des boutons de choix 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));
        JButton button_eleve = new JButton("Eleve");
        JButton button_prof = new JButton("Enseignant ");
        JButton button_bulletin = new JButton("Bulletin");
        JButton button_classe = new JButton("Classe");
        JButton button_niveau = new JButton("Niveau");
        JButton button_annee = new JButton("Annee scolaire");
        JButton button_note = new JButton("Note");
        JButton button_trimestre = new JButton("Trimestre");
        JButton button_discipline = new JButton("Discipline");

        // panel.add(question);
        panel.add(button_eleve);
        panel.add(button_prof);
        panel.add(button_bulletin);
        panel.add(button_classe);
        panel.add(button_niveau);
        panel.add(button_annee);
        panel.add(button_note);
        panel.add(button_trimestre);
        panel.add(button_discipline);

        frame_choix_suppr.add(panel, BorderLayout.CENTER);
        frame_choix_suppr.add(p0, BorderLayout.NORTH);

        //Quand on clique sur Eleve
        button_eleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suppression.suppr_eleve();

            }
        });

        //Quand on clique sur Prof
        button_prof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suppression.suppr_enseignant();

            }
        });

        //Quand on clique sur Bulletin
        button_bulletin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suppression.suppr_bulletin();

            }
        });

        //Quand on clique sur Classe
        button_classe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suppression.suppr_classe();

            }
        });

        //Quand on clique sur Niveau
        button_niveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suppression.suppr_niveau();
               

            }
        });
        //Quand on clique sur Annee Scolaire
        button_annee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suppression.suppr_annee_scolaire();

            }
        });

        //Quand on clique sur trimestre
        button_trimestre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suppression.suppr_trimestre();

            }
        });

        //Quand on clique sur  discipline
        button_discipline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Suppression.suppr_discipline();

            }
        });

        //Quand on clique sur note
        button_note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Suppression.suppr_note();

            }
        });

    } //Fin methode choix_classe_suppr

    /*
    *Methode d'affichage de suppression d'un eleve
     */
    public static void suppr_eleve() {
        HashMap<Integer, Eleve> h_eleve_all = new HashMap<Integer, Eleve>();
        DAO<Eleve> eleve_all = DAO_Factory.getEleveDAO();
        h_eleve_all = eleve_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("suppr eleve ");
        frame_ajout.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1=jTextField1.getText();
                String temp1=id_temp1;
                 int id_eleve_delete = Integer.parseInt(temp1);
                 
                 boolean eleve_delete=false;
                 
                 Eleve eleve = new Eleve(0,"a","a",1,id_eleve_delete,1);

             
                eleve_delete=eleve_all.delete(eleve);
                if(eleve_delete==true){frame_ajout.dispose();
                Suppression.suppr_eleve();}
            }
        });
DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Id_eleve","Nom","Prenom","Classe","Id_personne"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[5]; 
       
       for (int i : h_eleve_all.keySet()){
           table[0]=h_eleve_all.get(i).getId_eleve();
           table[1]=h_eleve_all.get(i).getNom();
           table[2]=h_eleve_all.get(i).getPrenom();
           table[3]=h_eleve_all.get(i).getId_classe();
           table[4]=h_eleve_all.get(i).getId_personne();
                   defmod.addRow(table);
       }
       jTable1.setModel(defmod);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                                        .addComponent(jTextField1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(127, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );

    }

    /*
    *Methode d'affichage de suppression d'un enseignant
     */
    public static void suppr_enseignant() {
        
        HashMap<Integer, Enseignant> h_ens_all = new HashMap<Integer, Enseignant>();
        DAO<Enseignant> enseignant_all = DAO_Factory.getEnseignantDAO();
        h_ens_all = enseignant_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("suppr enseignant ");
        frame_ajout.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1=jTextField1.getText();
                String temp1=id_temp1;
                 int id_ens_delete = Integer.parseInt(temp1);
                 
                 boolean ens_delete=false;
                 //int id_personne,String nom, String prenom, int type, int id_enseignant, int id_classe, int id_discipline
                 Enseignant ens = new Enseignant(0,"a","a",2,id_ens_delete,1,1);

             
                ens_delete=enseignant_all.delete(ens);
                if(ens_delete==true){frame_ajout.dispose();
                Suppression.suppr_enseignant();}
            }
        });

        DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Id_enseignant","Nom","Prenom","Classe","Id_personne","Id_discipline"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[6]; 
       
       for (int i : h_ens_all.keySet()){
           table[0]=h_ens_all.get(i).getId_enseignant();
           table[1]=h_ens_all.get(i).getNom();
           table[2]=h_ens_all.get(i).getPrenom();
           table[3]=h_ens_all.get(i).getId_classe();
           table[4]=h_ens_all.get(i).getId_personne();
           table[5]=h_ens_all.get(i).getId_discipline();
                   defmod.addRow(table);
       }
       jTable1.setModel(defmod);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                                        .addComponent(jTextField1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(127, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );

    }

    /*
    *Methode d'affichage de suppression d'un bulletin
     */
    public static void suppr_bulletin() {
        
                    HashMap<Integer, Bulletin> h_bulletin_all = new HashMap<Integer, Bulletin>();
                    DAO<Bulletin> bulletin_all = DAO_Factory.getBulletinDAO();
         h_bulletin_all = bulletin_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("suppr bulletin ");
        frame_ajout.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1=jTextField1.getText();
                String temp1=id_temp1;
                 int id_bull_delete = Integer.parseInt(temp1);
                 
                 boolean bull_delete=false;
                 
                 Bulletin bull = new Bulletin(id_bull_delete,1,1,"a");

             
                bull_delete=bulletin_all.delete(bull);
                if(bull_delete==true){frame_ajout.dispose();
                Suppression.suppr_bulletin();}
            }
        });

        DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Id_bulletin","Id_eleve","Id_trimestre","Appreciation"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[4]; 
       
       for (int i : h_bulletin_all.keySet()){
           table[0]=h_bulletin_all.get(i).getId_bulletin();
           table[1]=h_bulletin_all.get(i).getId_eleve();
           table[2]=h_bulletin_all.get(i).getId_trimestre();
           table[3]=h_bulletin_all.get(i).getAppreciation();
                   defmod.addRow(table);
       }
       jTable1.setModel(defmod);
       jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                                        .addComponent(jTextField1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(127, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
    }

    /*
    *Methode d'affichage de suppression d'une classe
     */
    public static void suppr_classe() {
        HashMap<Integer, Classe> h_classe_all = new HashMap<Integer, Classe>();
        DAO<Classe> classe_all = DAO_Factory.getClasseDAO();
        h_classe_all = classe_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("suppr classe ");
        frame_ajout.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1=jTextField1.getText();
                String temp1=id_temp1;
                 int id_class_delete = Integer.parseInt(temp1);
                 
                 boolean class_delete=false;
                 
                 Classe classe = new Classe(id_class_delete,1,"a",1);

             
                class_delete=classe_all.delete(classe);
                if(class_delete==true){frame_ajout.dispose();
                Suppression.suppr_classe();}
            }
        });

        DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Classe","Nom","Id_niveau","Annee"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[4]; 
       
       for (int i : h_classe_all.keySet()){
           table[0]=h_classe_all.get(i).getId_classe();
           table[1]=h_classe_all.get(i).getNom();
           table[2]=h_classe_all.get(i).getId_niveau();
           table[3]=h_classe_all.get(i).getId_Annee();
                   defmod.addRow(table);
       }
       jTable1.setModel(defmod);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                                        .addComponent(jTextField1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(127, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
    }

    /*
      *Methode d'affichage de suppression d'un niveau
     */
    public static void suppr_niveau() {
        HashMap<Integer, Niveau> h_niv_all = new HashMap<Integer, Niveau>();
        DAO<Niveau> niveau_all = DAO_Factory.getNiveauDAO();
        h_niv_all = niveau_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("suppr niveau ");
        frame_ajout.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1=jTextField1.getText();
                String temp1=id_temp1;
                 int id_niv_delete = Integer.parseInt(temp1);
                 
                 boolean niv_delete=false;
                 
                 Niveau niv = new Niveau(id_niv_delete,"a");

             
                niv_delete=niveau_all.delete(niv);
                if(niv_delete==true){frame_ajout.dispose();
                Suppression.suppr_niveau();}
            }
        });

        DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Nom","Id_niveau"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[2]; 
       
       for (int i : h_niv_all.keySet()){
           table[0]=h_niv_all.get(i).getNom();
           table[1]=h_niv_all.get(i).getId_niveau();
                   defmod.addRow(table);
       }
       jTable1.setModel(defmod);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                                        .addComponent(jTextField1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(127, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
    }

    /*
      *Methode d'affichage de suppression annee scolaire
     */
    public static void suppr_annee_scolaire() {
                            HashMap<Integer, Annee_scolaire> h_annee_all = new HashMap<Integer, Annee_scolaire>();
                    DAO<Annee_scolaire> annee_all = DAO_Factory.getAnneescolaireDAO();
                    h_annee_all = annee_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("suppr annee scolaire  ");
        frame_ajout.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1=jTextField1.getText();
                String temp1=id_temp1;
                 int id_annee_delete = Integer.parseInt(temp1);
                 
                 boolean annee_delete=false;
                 
                 Annee_scolaire annee = new Annee_scolaire(id_annee_delete);

             
                annee_delete=annee_all.delete(annee);
                if(annee_delete==true){frame_ajout.dispose();
                Suppression.suppr_annee_scolaire();}
            }
        });

       DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Nom","Id_niveau"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[2]; 
       
       for (int i : h_annee_all.keySet()){
           table[0]=h_annee_all.get(i).getId_annee_scolaire();
           table[1]=(h_annee_all.get(i).getId_annee_scolaire()+2018);
                   defmod.addRow(table);
       }
       jTable1.setModel(defmod);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                                        .addComponent(jTextField1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(127, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
    }

    /*
      *Methode d'affichage de supression trimestre
     */
    public static void suppr_trimestre() {
        HashMap<Integer, Trimestre> h_trim_all = new HashMap<Integer, Trimestre>();
        DAO<Trimestre> trimestre_all = DAO_Factory.getTrimestreDAO();
        h_trim_all = trimestre_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("suppr trimestre  ");
        frame_ajout.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1=jTextField1.getText();
                String temp1=id_temp1;
                 int id_trim_delete = Integer.parseInt(temp1);
                 
                 boolean trim_delete=false;
                 
                 Trimestre trim = new Trimestre(id_trim_delete,1,1,1,1);

             
                trim_delete=trimestre_all.delete(trim);
                if(trim_delete==true){frame_ajout.dispose();
                Suppression.suppr_trimestre();}
            }
        });

       DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Numéro du trimestre","Id_trimestre","Mois de début du trimestre","Mois de fin du trimestre","Année du trimestre"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[5]; 
       
       for (int i : h_trim_all.keySet()){
           table[0] = h_trim_all.get(i).getNumero();
           table[1] = h_trim_all.get(i).getId_trimestre();
           table[2] = h_trim_all.get(i).getDebut();
           table[3] = h_trim_all.get(i).getFin();
           table[4] = (h_trim_all.get(i).getId_annee() + 2018);
                   defmod.addRow(table);
       }
       jTable1.setModel(defmod);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                                        .addComponent(jTextField1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(127, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
    }

    /*
      *Methode d'affichage de suppression discipline
     */
    public static void suppr_discipline() {
        HashMap<Integer, Discipline> h_dscp_all = new HashMap<Integer, Discipline>();
        DAO<Discipline> discipline_all = DAO_Factory.getDisciplineDAO();
        h_dscp_all = discipline_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("suppr discipline  ");
        frame_ajout.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               String id_temp1=jTextField1.getText();
                String temp1=id_temp1;
                 int id_disc_delete = Integer.parseInt(temp1);
                 
                 boolean disc_delete=false;
                 
                 Discipline disc = new Discipline(id_disc_delete,"a");

             
                disc_delete=discipline_all.delete(disc);
                if(disc_delete==true){frame_ajout.dispose();
                Suppression.suppr_discipline();}
            }
        });

       DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Nom de la matière","Id_discipline"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[2]; 
       
       for (int i : h_dscp_all.keySet()){
           table[0]=h_dscp_all.get(i).getNom_discipline();
           table[1]=h_dscp_all.get(i).getId_discipline();
                   defmod.addRow(table);
       }
       jTable1.setModel(defmod);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                                        .addComponent(jTextField1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(127, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
    }

    /*
      *Methode d'affichage de supression note
     */
    public static void suppr_note() {
        HashMap<Integer, Note> h_note_all = new HashMap<Integer, Note>();
        DAO<Note> note_all = DAO_Factory.getNoteDAO();
        h_note_all = note_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("suppr note  ");
        frame_ajout.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1=jTextField1.getText();
                String temp1=id_temp1;
                 int id_note_delete = Integer.parseInt(temp1);
                 
                 boolean note_delete=false;
                 //int id_personne, String nom, String prenom, int type, int id_eleve, int id_classe
                 Note note = new Note(id_note_delete,0,"",1);

             
                note_delete=note_all.delete(note);
                if(note_delete==true){frame_ajout.dispose();
                Suppression.suppr_note();}
            }
        });

       DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Id de la note","Id du detail bulletin","Note","Appreciation"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[4]; 
       
       for (int i : h_note_all.keySet()){
           table[0] = h_note_all.get(i).getId_note();
           table[1] = h_note_all.get(i).getId_detail_bulletin();
           table[2] = h_note_all.get(i).getNote();
           table[3] = h_note_all.get(i).getAppreciation();
                   defmod.addRow(table);
       }
       jTable1.setModel(defmod);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                                        .addComponent(jTextField1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(127, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
    }
    
}
