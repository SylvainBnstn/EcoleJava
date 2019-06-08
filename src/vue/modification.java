/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import Controleur.*;
import Modele.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.lang.Integer;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.*;

/**
 *
 * @author meuni
 */
public class modification {

    /**
     * ///METHODE CHOIX DE CLASSE OU EFFECTUER UNE Modification
     */
    public static void choix_classe_modif() {
        JFrame frame_choix_modif = new JFrame();
        frame_choix_modif.setSize(900, 900);
        frame_choix_modif.setLocation(450, 100);
        frame_choix_modif.setTitle("choix classe modification");
        frame_choix_modif.setVisible(true);

        //Affichage label question dans un deuxieme panel
        Font font = new Font("Courier", Font.BOLD, 20);
        frame_choix_modif.setFont(font);
        JLabel question = new JLabel("Dans quelle classe voulez vous effectuer une modification ?", JLabel.CENTER);
        JPanel p0 = new JPanel();
        p0.add(question);
        frame_choix_modif.add(p0);

        //affichage des boutons de choix 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));
        JButton button_eleve = new JButton("Eleve");
        JButton button_prof = new JButton("Enseignant ");
        JButton button_bulletin = new JButton("Bulletin");
        JButton button_classe = new JButton("Classe");
        JButton button_niveau = new JButton("Niveau");
        JButton button_detail_bulletin = new JButton("Detail bulletin");
        JButton button_note = new JButton("Note");
        JButton button_trimestre = new JButton("Trimestre");
        JButton button_discipline = new JButton("Discipline");

        panel.add(button_eleve);
        panel.add(button_prof);
        panel.add(button_bulletin);
        panel.add(button_classe);
        panel.add(button_niveau);
        panel.add(button_detail_bulletin);
        panel.add(button_note);
        panel.add(button_trimestre);
        panel.add(button_discipline);

        frame_choix_modif.add(panel, BorderLayout.CENTER);
        frame_choix_modif.add(p0, BorderLayout.NORTH);

        //Quand on clique sur Eleve
        button_eleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.modif_eleve();

            }
        });

        //Quand on clique sur Prof
        button_prof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.modif_enseignant();

            }
        });

        //Quand on clique sur Bulletin
        button_bulletin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.modif_bulletin();

            }
        });

        //Quand on clique sur Classe
        button_classe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.modif_classe();

            }
        });

        //Quand on clique sur Niveau
        button_niveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.modif_niveau();

            }
        });
        //Quand on clique sur Annee Scolaire
        button_detail_bulletin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.modif_detail_bulletin();

            }
        });

        //Quand on clique sur trimestre
        button_trimestre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.modif_trimestre();

            }
        });

        //Quand on clique sur  discipline
        button_discipline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.modif_discipline();

            }
        });

        //Quand on clique sur note
        button_note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.modif_note();

            }
        });

    } //Fin methode choix_classe_modif

    /*
    *Methode d'affichage de modification d'un eleve
     */
    public static void modif_eleve() {
        HashMap<Integer, Eleve> h_eleve_all = new HashMap<Integer, Eleve>();
        DAO<Eleve> eleve_all = DAO_Factory.getEleveDAO();
        h_eleve_all = eleve_all.show_all();

        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("modif eleve ");
        frame_ajout.setVisible(true);

        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTable jTable2 = new javax.swing.JTable();
        JButton jButton1 = new javax.swing.JButton();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JTextField jTextField2 = new javax.swing.JTextField();
        JLabel jLabel5 = new javax.swing.JLabel();
        JTextField jTextField3 = new javax.swing.JTextField();
        JLabel jLabel4 = new javax.swing.JLabel();
        JTextField jTextField5 = new javax.swing.JTextField();
        JTextField jTextField6 = new javax.swing.JTextField();
        JLabel jLabel7 = new javax.swing.JLabel();

        DefaultTableModel defmod = new DefaultTableModel();

        String[] nom_col = {"Id_eleve", "Nom", "Prenom", "Classe", "Id_personne"};
        defmod.setColumnIdentifiers(nom_col);
        Object[] table = new Object[5];

        for (int i : h_eleve_all.keySet()) {
            table[0] = h_eleve_all.get(i).getId_eleve();
            table[1] = h_eleve_all.get(i).getNom();
            table[2] = h_eleve_all.get(i).getPrenom();
            table[3] = h_eleve_all.get(i).getId_classe();
            table[4] = h_eleve_all.get(i).getId_personne();
            defmod.addRow(table);
        }
        jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
            }
        });

       jLabel2.setText("Nom :");

        jLabel3.setText("Entrez les informations du bulletin que vous voulez modifier ");
        jLabel3.setToolTipText("");

        jTextField2.setToolTipText("");
        jTextField2.setName("id_eleve"); // NOI18N

        jLabel5.setText("ID eleve :");

        jTextField3.setToolTipText("");

        jLabel4.setText("Prenom :");

        jTextField5.setToolTipText("");

        jTextField6.setToolTipText("");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField6ActionPerformed(evt);
            }
        });

        jLabel7.setText("Id Classe :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    /*
    *Methode d'affichage de modif d'un enseignant
     */
    public static void modif_enseignant() {
        HashMap<Integer, Enseignant> h_ens_all = new HashMap<Integer, Enseignant>();
        DAO<Enseignant> enseignant_all = DAO_Factory.getEnseignantDAO();
        h_ens_all = enseignant_all.show_all();

        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("modif enseignant ");
        frame_ajout.setVisible(true);

        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTable jTable2 = new javax.swing.JTable();
        JButton jButton1 = new javax.swing.JButton();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
       JTextField jTextField2 = new javax.swing.JTextField();
         JLabel jLabel5 = new javax.swing.JLabel();
       JTextField jTextField3 = new javax.swing.JTextField();
       JLabel jLabel4 = new javax.swing.JLabel();
       JTextField jTextField5 = new javax.swing.JTextField();
       JTextField jTextField6 = new javax.swing.JTextField();
       JLabel jLabel7 = new javax.swing.JLabel();
       JLabel jLabel8 = new javax.swing.JLabel();
       JTextField jTextField7 = new javax.swing.JTextField();

        DefaultTableModel defmod = new DefaultTableModel();

        String[] nom_col = {"Id_eleve", "Nom", "Prenom", "Classe", "Id_personne", "Id_discipline"};
        defmod.setColumnIdentifiers(nom_col);
        Object[] table = new Object[6];

        for (int i : h_ens_all.keySet()) {
            table[0] = h_ens_all.get(i).getId_enseignant();
            table[1] = h_ens_all.get(i).getNom();
            table[2] = h_ens_all.get(i).getPrenom();
            table[3] = h_ens_all.get(i).getId_classe();
            table[4] = h_ens_all.get(i).getId_personne();
            table[5] = h_ens_all.get(i).getId_discipline();
            defmod.addRow(table);
        }
        jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
            }
        });

       jLabel2.setText("Nom :");

        jLabel3.setText("Entrez les informations du bulletin que vous voulez modifier ");
        jLabel3.setToolTipText("");

        jTextField2.setToolTipText("");
        jTextField2.setName("id_eleve"); // NOI18N

        jLabel5.setText("ID enseignant :");

        jTextField3.setToolTipText("");

        jLabel4.setText("Prenom :");

        jTextField5.setToolTipText("");

        jTextField6.setToolTipText("");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField6.ActionPerformed(evt);
            }
        });

        jLabel7.setText("Id Discipline :");

        jLabel8.setText("Id Classe :");

        jTextField7.setToolTipText("");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
    }

    /*
    *Methode d'affichage de modif d'un bulletin
     */
        public static void modif_bulletin() {
        HashMap<Integer, Bulletin> h_bulletin_all = new HashMap<Integer, Bulletin>();
        DAO<Bulletin> bulletin_all = DAO_Factory.getBulletinDAO();
        h_bulletin_all = bulletin_all.show_all();

        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("modif bulletin ");
        frame_ajout.setVisible(true);

        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        javax.swing.JTable jTable2 = new javax.swing.JTable();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField3 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField4 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField5 = new javax.swing.JTextField();

        DefaultTableModel defmod = new DefaultTableModel();

        String[] nom_col = {"Id_bulletin", "Id_eleve", "Id_trimestre", "Appreciation"};
        defmod.setColumnIdentifiers(nom_col);
        Object[] table = new Object[4];

        for (int i : h_bulletin_all.keySet()) {
            table[0] = h_bulletin_all.get(i).getId_bulletin();
            table[1] = h_bulletin_all.get(i).getId_eleve();
            table[2] = h_bulletin_all.get(i).getId_trimestre();
            table[3] = h_bulletin_all.get(i).getAppreciation();
            defmod.addRow(table);
        }
        jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1 =jTextField2.getText();    
                String id_temp2=jTextField3.getText();
                String id_temp3 =jTextField4.getText();   
                String id_temp4=jTextField5.getText();
                
                int id_bulletin_update_bulletin = Integer.parseInt(id_temp1);
                int id_trimestre_update_bulletin = Integer.parseInt(id_temp2);
                int id_eleve_update_bulletin = Integer.parseInt(id_temp3);
                boolean bulletin_update=false;
                Bulletin bulletin = new Bulletin(id_bulletin_update_bulletin, id_trimestre_update_bulletin,id_eleve_update_bulletin,id_temp4);

             
                bulletin_update=bulletin_all.update(bulletin);
                frame_ajout.dispose();
                modification.modif_bulletin();
                
            }
        });

        jLabel2.setText("ID Trimestre :");

        jLabel3.setText("Entrez les informations du bulletin que vous voulez modifier ");

        jTextField2.setText("");

        jLabel5.setText("ID bulletin :");

        jTextField3.setText("");

        jLabel4.setText("ID eleve :");

        jTextField4.setText("");

        jLabel6.setText("Appreciation :");

        jTextField5.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(320, 320, 320)
                                                .addComponent(jLabel3)
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    /**
    *Methode d'affichage de modif d'une classe
     */
    public static void modif_classe() {
        HashMap<Integer, Classe> h_classe_all = new HashMap<Integer, Classe>();
        DAO<Classe> classe_all = DAO_Factory.getClasseDAO();
        h_classe_all = classe_all.show_all();

        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("modif classe ");
        frame_ajout.setVisible(true);

        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        javax.swing.JTable jTable2 = new javax.swing.JTable();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField3 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField4 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField5 = new javax.swing.JTextField();

        DefaultTableModel defmod = new DefaultTableModel();

        String[] nom_col = {"Classe", "Nom", "Id_niveau", "Annee"};
        defmod.setColumnIdentifiers(nom_col);
        Object[] table = new Object[4];

        for (int i : h_classe_all.keySet()) {
            table[0] = h_classe_all.get(i).getId_classe();
            table[1] = h_classe_all.get(i).getNom();
            table[2] = h_classe_all.get(i).getId_niveau();
            table[3] = h_classe_all.get(i).getId_Annee();
            defmod.addRow(table);
        }
        jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1 =jTextField3.getText();    
                String id_temp2=jTextField2.getText();
                String id_temp3 =jTextField4.getText();   
                String id_temp4=jTextField5.getText();
                
                int id_classe_update_classe = Integer.parseInt(id_temp1);
                int id_niveau_update_classe = Integer.parseInt(id_temp2);
                int id_annee_update_classe = Integer.parseInt(id_temp4);
                boolean classe_update=false;
                Classe classe = new Classe(id_classe_update_classe, id_niveau_update_classe,id_temp3,id_annee_update_classe);

             
                classe_update=classe_all.update(classe);
                frame_ajout.dispose();
                modification.modif_classe();
            }
        });

        jLabel2.setText("ID Niveau :");

        jLabel3.setText("Entrez les informations de la classe que vous voulez modifier ");

        jTextField2.setText("");

        jLabel5.setText("ID classe :");

        jTextField3.setText("");

        jLabel4.setText("Nom :");

        jTextField4.setText("");

        jLabel6.setText("ID annee :");

        jTextField5.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(320, 320, 320)
                                                .addComponent(jLabel3)
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    /**
      *Methode d'affichage de modif d'un niveau
     */
    public static void modif_niveau() {
        HashMap<Integer, Niveau> h_niv_all = new HashMap<Integer, Niveau>();
        DAO<Niveau> niveau_all = DAO_Factory.getNiveauDAO();
        h_niv_all = niveau_all.show_all();

        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("modif niveau ");
        frame_ajout.setVisible(true);

        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTable jTable2 = new javax.swing.JTable();
        JButton jButton1 = new javax.swing.JButton();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JTextField jTextField2 = new javax.swing.JTextField();
        JLabel jLabel4 = new javax.swing.JLabel();

        DefaultTableModel defmod = new DefaultTableModel();

        String[] nom_col = {"Id niveau", "Nom"};
        defmod.setColumnIdentifiers(nom_col);
        Object[] table = new Object[2];

        for (int i : h_niv_all.keySet()) {
            table[0] =h_niv_all.get(i).getId_niveau();
            table[1] = h_niv_all.get(i).getNom();
            defmod.addRow(table);
        }
        jTable2.setModel(defmod);

        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1 =jTextField2.getText();    
                String id_temp2=jTextField1.getText();
             
                
                 int id_niveau_update = Integer.parseInt(id_temp1);
                boolean niveau_update=false;
              Niveau niveau = new Niveau(id_niveau_update,id_temp2);

             
                niveau_update=niveau_all.update(niveau);
                frame_ajout.dispose();
                modification.modif_niveau();           
            }
        });

        jTextField1.setText("");

        jLabel2.setText("Nom : ");

        jLabel3.setText("Entrez les nouvelles informations du niveau que vous voulez modifier");

        jTextField2.setText("");

        jLabel4.setText("ID du niveau: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(158, 158, 158)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addComponent(jLabel4)
                                        .addContainerGap(1399, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(320, 320, 320)
                                                .addComponent(jLabel3)
                                                .addGap(154, 154, 154)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(40, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(492, 492, 492)
                                        .addComponent(jLabel4)
                                        .addContainerGap(751, Short.MAX_VALUE)))
        );
    }

    /**
      *Methode d'affichage de modif detail bulletin
     */
    public static void modif_detail_bulletin() {
        HashMap<Integer, Detail_bulletin> h_det_bull_all = new HashMap<Integer, Detail_bulletin>();
        DAO<Detail_bulletin> detail_bult_all = DAO_Factory.getDetailbulletinDAO();
        h_det_bull_all = detail_bult_all.show_all();
        
       JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("modif detail bulletin  ");
        frame_ajout.setVisible(true);

        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTable jTable2 = new javax.swing.JTable();
        JButton jButton1 = new javax.swing.JButton();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JTextField jTextField2 = new javax.swing.JTextField();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        JTextField jTextField3 = new javax.swing.JTextField();
        JLabel jLabel6 = new javax.swing.JLabel();
        JTextField jTextField4 = new javax.swing.JTextField();

        DefaultTableModel defmod = new DefaultTableModel();

        String[] nom_col = {"Id du detail bulletin", "Id bulletin", "Id enseignant", "Appreciation"};
        defmod.setColumnIdentifiers(nom_col);
        Object[] table = new Object[4];

        for (int i : h_det_bull_all.keySet()) {
            table[0] = h_det_bull_all.get(i).getId_detail_bulletin();
            table[1] = h_det_bull_all.get(i).getId_bulletin();
            table[2] = h_det_bull_all.get(i).getId_enseignant();
            table[3] = h_det_bull_all.get(i).getAppreciation();
            defmod.addRow(table);
        }
        jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1 =jTextField3.getText();    
                String id_temp2=jTextField1.getText();
                String id_temp3 =jTextField2.getText();   
                String id_temp4=jTextField4.getText();
                
                 int id_detail_bulletin_update = Integer.parseInt(id_temp1);
                 int id_bulletin_update_detail_bulletin = Integer.parseInt(id_temp2);
                int id_enseignant_update_detail_bulletin = Integer.parseInt(id_temp3);
                boolean detail_bulletin_update=false;
                Detail_bulletin detail_bulletin = new Detail_bulletin(id_detail_bulletin_update, id_bulletin_update_detail_bulletin,id_enseignant_update_detail_bulletin,id_temp4);

             
                detail_bulletin_update=detail_bult_all.update(detail_bulletin);
                frame_ajout.dispose();
                modification.modif_detail_bulletin();
            }
        });

        jTextField1.setText("BULETIN");

        jLabel2.setText("ID bulletin:");
        

        jLabel3.setText("Entrez les informations du detail bulletin que vous voulez modifier ");

        jTextField2.setText("Id enseignant");

        jLabel4.setText("Appreciation :");

        jLabel5.setText("ID detail bulletin : ");

        jTextField3.setText("id detail bulletin");

        jLabel6.setText("ID enseignant :");

        jTextField4.setText("Appreciation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(143, 143, 143)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(320, 320, 320)
                                                .addComponent(jLabel3)
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel6)
                                                .addGap(2, 2, 2)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

    }

    /**
      *Methode d'affichage de modif trimestre
     */
    public static void modif_trimestre() {
       
    }

    /**
      *Methode d'affichage de modif discipline
     */
    public static void modif_discipline() {
        HashMap<Integer, Discipline> h_dscp_all = new HashMap<Integer, Discipline>();
        DAO<Discipline> discipline_all = DAO_Factory.getDisciplineDAO();
        h_dscp_all = discipline_all.show_all();

        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("modif discipline  ");
        frame_ajout.setVisible(true);

        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        javax.swing.JTable jTable2 = new javax.swing.JTable();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField3 = new javax.swing.JTextField();

        DefaultTableModel defmod = new DefaultTableModel();

        String[] nom_col = {"Id_discipline", "Nom de la matière"};
        defmod.setColumnIdentifiers(nom_col);
        Object[] table = new Object[2];

        for (int i : h_dscp_all.keySet()) {
            table[0] = h_dscp_all.get(i).getId_discipline();
            table[1] =h_dscp_all.get(i).getNom_discipline();

            defmod.addRow(table);
        }
        jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1 =jTextField2.getText();    
                String id_temp2=jTextField3.getText();
              
                
          

                int id_classe_update = Integer.parseInt(id_temp1);
                
                boolean discipline_update=false;
                Discipline discipline = new Discipline(id_classe_update, id_temp2);

             
                discipline_update=discipline_all.update(discipline);
                frame_ajout.dispose();
                modification.modif_discipline();            }
        });

        jLabel2.setText("Nom :");

        jLabel3.setText("Entrez les informations de la discipline que vous voulez modifier ");

        jTextField2.setText("");

        jLabel5.setText("ID discipline :");

        jTextField3.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(320, 320, 320)
                                                .addComponent(jLabel3)
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(71, 71, 71)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    /**
      *Methode d'affichage de modif note
     */
    public static void modif_note() {
        HashMap<Integer, Note> h_note_all = new HashMap<Integer, Note>();
        DAO<Note> note_all = DAO_Factory.getNoteDAO();
        h_note_all = note_all.show_all();

        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("modif note  ");
        frame_ajout.setVisible(true);

        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTable jTable2 = new javax.swing.JTable();
        JButton jButton1 = new javax.swing.JButton();
        JTextField jTextField_idnote = new javax.swing.JTextField();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JTextField jTextField_iddbull = new javax.swing.JTextField();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        JTextField jTextField_appre = new javax.swing.JTextField();
        JLabel jLabel6 = new javax.swing.JLabel();
        JTextField jTextField_note = new javax.swing.JTextField();

        DefaultTableModel defmod = new DefaultTableModel();

        String[] nom_col = {"Id de la note", "Id du detail bulletin", "Note", "Appreciation"};
        defmod.setColumnIdentifiers(nom_col);
        Object[] table = new Object[4];

        for (int i : h_note_all.keySet()) {
            table[0] = h_note_all.get(i).getId_note();
            table[1] = h_note_all.get(i).getId_detail_bulletin();
            table[2] = h_note_all.get(i).getNote();
            table[3] = h_note_all.get(i).getAppreciation();
            defmod.addRow(table);
        }
        jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1 =jTextField_idnote.getText();    
                String id_temp2=jTextField_iddbull.getText();
                String id_temp3 =jTextField_appre.getText();   
                String id_temp4=jTextField_note.getText();
                String temp1=id_temp1;
                
                 int id_note_update = Integer.parseInt(temp1);
          

                int id_detail_bulletin_update_note = Integer.parseInt(id_temp2);
                double note_update_note = Double.parseDouble(id_temp4);
                boolean note_update=false;
                Note note = new Note(id_note_update, id_detail_bulletin_update_note,id_temp3,note_update_note);

             
                note_update=note_all.update(note);
                frame_ajout.dispose();
                modification.modif_note();
            }
        });

        jTextField_idnote.setText("");

        jLabel2.setText("ID detail bulletin:");

        jLabel3.setText("Entrez les informations de la note que vous voulez modifier ");

        jTextField_iddbull.setText("");

        jLabel4.setText("Note");

        jLabel5.setText("ID : ");

        jTextField_appre.setText("");

        jLabel6.setText("Appreciation");

        jTextField_note.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(143, 143, 143)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jTextField_idnote, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField_iddbull, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jTextField_appre, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jTextField_note, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(320, 320, 320)
                                                .addComponent(jLabel3)
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField_idnote, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField_iddbull, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel6)
                                                .addGap(2, 2, 2)
                                                .addComponent(jTextField_appre, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField_note, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

}
