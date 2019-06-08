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
public class ajout {
    
      /**
     * ///METHODE CHOIX DE CLASSE OU EFFECTUER UN AJOUT
     */
    public static void choix_classe_ajout() {
        JFrame frame_choix_ajout = new JFrame();
        frame_choix_ajout.setSize(900, 900);
        frame_choix_ajout.setLocation(450, 100);
        frame_choix_ajout.setTitle("choix classe ajout");
        frame_choix_ajout.setVisible(true);

        //Affichage label question dans un deuxieme panel
        Font font = new Font("Courier", Font.BOLD, 20);
        frame_choix_ajout.setFont(font);
        JLabel question = new JLabel("Dans quelle classe voulez vous effectuer un ajout ?", JLabel.CENTER);
        JPanel p0 = new JPanel();
        p0.add(question);
        frame_choix_ajout.add(p0);

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

        panel.add(button_eleve);
        panel.add(button_prof);
        panel.add(button_bulletin);
        panel.add(button_classe);
        panel.add(button_niveau);
        panel.add(button_annee);
        panel.add(button_note);
        panel.add(button_trimestre);
        panel.add(button_discipline);

        frame_choix_ajout.add(panel, BorderLayout.CENTER);
        frame_choix_ajout.add(p0, BorderLayout.NORTH);

        //Quand on clique sur Eleve
        button_eleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ajout.ajout_eleve();

            }
        });

        //Quand on clique sur Prof
        button_prof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout.ajout_enseignant();

            }
        });

        //Quand on clique sur Bulletin
        button_bulletin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout.ajout_bulletin();

            }
        });

        //Quand on clique sur Classe
        button_classe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout.ajout_classe();

            }
        });

        //Quand on clique sur Niveau
        button_niveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout.ajout_niveau();

            }
        });
        //Quand on clique sur Annee Scolaire
        button_annee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout.ajout_annee_scolaire();

            }
        });

        //Quand on clique sur trimestre
        button_trimestre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout.ajout_trimestre();

            }
        });

        //Quand on clique sur  discipline
        button_discipline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout.ajout_discipline();

            }
        });

        //Quand on clique sur note
        button_note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout.ajout_note();

            }
        });

    } //Fin methode choix_classe_ajout

    /*
    *Methode d'affichage d'ajout d'un eleve
     */
    public static void ajout_eleve() {
        HashMap<Integer, Eleve> h_eleve_all = new HashMap<Integer, Eleve>();
        DAO<Eleve> eleve_all = DAO_Factory.getEleveDAO();
        h_eleve_all = eleve_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("ajout eleve ");
        frame_ajout.setVisible(true);

        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        javax.swing.JTable jTable2 = new javax.swing.JTable();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField3 = new javax.swing.JTextField();
        javax.swing.JTextField jTextField5 = new javax.swing.JTextField();

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
       jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
            }
        });

       jLabel2.setText("Prenom :");

        jLabel3.setText("Entrez les informations de l'eleve que vous voulez ajouter ");

        jTextField2.setText("jTextField1");

        jLabel4.setText("ID classe");

        jLabel5.setText("Nom : ");

        jTextField3.setText("jTextField1");

        jTextField5.setText("jTextField1");

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
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    /*
    *Methode d'affichage d'ajout d'un enseignant
     */
    public static void ajout_enseignant() {
        HashMap<Integer, Enseignant> h_ens_all = new HashMap<Integer, Enseignant>();
        DAO<Enseignant> enseignant_all = DAO_Factory.getEnseignantDAO();
        h_ens_all = enseignant_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("ajout enseignant ");
        frame_ajout.setVisible(true);

        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        javax.swing.JTable jTable2 = new javax.swing.JTable();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JTextField jTextField1 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField3 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField5 = new javax.swing.JTextField();

DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Id_eleve","Nom","Prenom","Classe","Id_personne","Id_discipline"} ;
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
       jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
            }
        });

       jTextField1.setText("jTextField1");

        jLabel2.setText("Prenom :");

        jLabel3.setText("Entrez les informations de l'enseignant que vous voulez ajouter ");

        jTextField2.setText("jTextField1");

        jLabel4.setText("ID Discipline");

        jLabel5.setText("Nom : ");

        jTextField3.setText("jTextField1");

        jLabel6.setText("ID classe");

        jTextField5.setText("jTextField1");

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
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel6)
                                                .addGap(2, 2, 2)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    /*
    *Methode d'affichage d'ajout d'un bulletin
     */
    public static void ajout_bulletin() {
                            HashMap<Integer, Bulletin> h_bulletin_all = new HashMap<Integer, Bulletin>();
                    DAO<Bulletin> bulletin_all = DAO_Factory.getBulletinDAO();
         h_bulletin_all = bulletin_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("ajout bulletin ");
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
       jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                String id_temp1 =jTextField2.getText();    
                String id_temp2=jTextField3.getText();
                String id_temp3 =jTextField5.getText();   
                String id_temp4=jTextField4.getText();
                
                int id_bulletin_ajout_bulletin = Integer.parseInt(id_temp1);
                int id_trimestre_ajout_bulletin = Integer.parseInt(id_temp2);
                int id_eleve_ajout_bulletin = Integer.parseInt(id_temp3);
                boolean bulletin_ajout=false;
                Bulletin bulletin = new Bulletin(id_bulletin_ajout_bulletin, id_trimestre_ajout_bulletin,id_eleve_ajout_bulletin,id_temp4);

             
                bulletin_ajout=bulletin_all.create(bulletin);
                frame_ajout.dispose();
                ajout.ajout_bulletin();            }
        });

        jLabel2.setText("ID Trimestre :");

        jLabel3.setText("Entrez les informations du bulletin que vous voulez ajouter ");

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
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    /*
    *Methode d'affichage d'ajout d'une classe
     */
    public static void ajout_classe() {
        HashMap<Integer, Classe> h_classe_all = new HashMap<Integer, Classe>();
        DAO<Classe> classe_all = DAO_Factory.getClasseDAO();
        h_classe_all = classe_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("ajout classe ");
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
       jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1 =jTextField2.getText();    
                String id_temp2=jTextField3.getText();
                String id_temp3 =jTextField5.getText();   
                String id_temp4=jTextField4.getText();
                
                int id_classe_ajout_classe = Integer.parseInt(id_temp1);
                int id_niveau_ajout_classe = Integer.parseInt(id_temp2);
                int id_annee_ajout_classe = Integer.parseInt(id_temp4);
                boolean classe_ajout=false;
                Classe classe = new Classe(id_classe_ajout_classe, id_niveau_ajout_classe,id_temp3,id_annee_ajout_classe);

             
                classe_ajout=classe_all.create(classe);
                frame_ajout.dispose();
                ajout.ajout_classe();            }
        });

        jLabel2.setText("ID Niveau :");

        jLabel3.setText("Entrez les informations de la classe que vous voulez ajouter ");

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
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    /*
      *Methode d'affichage d'ajout d'un niveau
     */
    public static void ajout_niveau() {
               
        HashMap<Integer, Niveau> h_niv_all = new HashMap<Integer, Niveau>();
        DAO<Niveau> niveau_all = DAO_Factory.getNiveauDAO();
        h_niv_all = niveau_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("ajout niveau ");
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
       
       String[] nom_col = {"Nom","Id_niveau"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[2]; 
       
       for (int i : h_niv_all.keySet()){
           table[0]=h_niv_all.get(i).getNom();
           table[1]=h_niv_all.get(i).getId_niveau();
                   defmod.addRow(table);
       }
       jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                String id_temp1 =jTextField2.getText();    
                String id_temp2=jTextField1.getText();
             
                
                 int id_niveau_ajout = Integer.parseInt(id_temp1);
                boolean niveau_ajout=false;
              Niveau niveau = new Niveau(id_niveau_ajout,id_temp2);

             
                niveau_ajout=niveau_all.create(niveau);
                frame_ajout.dispose();
                ajout.ajout_niveau();                  }
        });

        jTextField1.setText("Nom");

        jLabel2.setText("Nom : ");

        jLabel3.setText("Entrez les informations du niveau que vous voulez ajouter ");

        jTextField2.setText("id");

        jLabel4.setText("ID : ");

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
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    /*
      *Methode d'affichage d'ajout annee scolaire
     */
    public static void ajout_annee_scolaire() 
    {
                                    HashMap<Integer, Annee_scolaire> h_annee_all = new HashMap<Integer, Annee_scolaire>();
                    DAO<Annee_scolaire> annee_all = DAO_Factory.getAnneescolaireDAO();
                    h_annee_all = annee_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("ajout annee scolaire  ");
        frame_ajout.setVisible(true);

        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTable jTable2 = new javax.swing.JTable();
        JLabel jLabel1 = new javax.swing.JLabel();
        JButton jButton1 = new javax.swing.JButton();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel2 = new javax.swing.JLabel();

               DefaultTableModel defmod = new DefaultTableModel();
       
       String[] nom_col = {"Id_annee","Nom"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[2]; 
       
       for (int i : h_annee_all.keySet()){
           table[0]=h_annee_all.get(i).getId_annee_scolaire();
           table[1]=(h_annee_all.get(i).getId_annee_scolaire()+2018);
                   defmod.addRow(table);
       }
       jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("Rentrez les informations sur l'objet que vous voulez ajouter :");

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_temp1 =jTextField1.getText();    
                
                int id_annee_scolaire_ajout_annee = Integer.parseInt(id_temp1);
                boolean annee_scolaire_ajout=false;
                Annee_scolaire annee_scolaire = new Annee_scolaire(id_annee_scolaire_ajout_annee);

             
                annee_scolaire_ajout=annee_all.create(annee_scolaire);
                frame_ajout.dispose();
                ajout.ajout_annee_scolaire();            }
        });

        jTextField1.setText("");

        jLabel2.setText("ID : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_ajout.getContentPane());
        frame_ajout.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(114, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(158, 158, 158)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(273, 273, 273)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(111, 111, 111)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    /*
      *Methode d'affichage d'ajout trimestre
     */
    public static void ajout_trimestre() {
        HashMap<Integer, Trimestre> h_trim_all = new HashMap<Integer, Trimestre>();
        DAO<Trimestre> trimestre_all = DAO_Factory.getTrimestreDAO();
        h_trim_all = trimestre_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("ajout trimestre  ");
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
        JLabel jLabel7 = new javax.swing.JLabel();
        JTextField jTextField5 = new javax.swing.JTextField();

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
       jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jLabel2.setText("Numero :");

        jLabel3.setText("Entrez les informations du trimestre que vous voulez ajouter ");

        jTextField2.setText("jTextField1");

        jLabel4.setText("Fin");

        jLabel5.setText("ID : ");

        jTextField3.setText("jTextField1");

        jLabel6.setText("Debut");

        jTextField4.setText("jTextField1");

        jLabel7.setText("ID Annee");

        jTextField5.setText("jTextField1");

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
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jLabel7)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel6)
                                                .addGap(2, 2, 2)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(102, 102, 102))))
        );
    }

    /*
      *Methode d'affichage d'ajout discipline
     */
    public static void ajout_discipline() {
        HashMap<Integer, Discipline> h_dscp_all = new HashMap<Integer, Discipline>();
        DAO<Discipline> discipline_all = DAO_Factory.getDisciplineDAO();
        h_dscp_all = discipline_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("ajout discipline  ");
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
       
       String[] nom_col = {"Nom de la matière","Id_discipline"} ;
       defmod.setColumnIdentifiers(nom_col);
       Object[] table = new Object[2]; 
       
       for (int i : h_dscp_all.keySet()){
           table[0]=h_dscp_all.get(i).getNom_discipline();
           table[1]=h_dscp_all.get(i).getId_discipline();
                   defmod.addRow(table);
       }
       jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
                String id_temp1 =jTextField2.getText();    
                String id_temp2=jTextField1.getText();
             
                
                 int id_discipline_ajout = Integer.parseInt(id_temp1);
                boolean discipline_ajout=false;
              Discipline discipline = new Discipline(id_discipline_ajout,id_temp2);

             
                discipline_ajout=discipline_all.create(discipline);
                frame_ajout.dispose();
                ajout.ajout_discipline();              }
        });

        jTextField1.setText("");

        jLabel2.setText("Nom : ");

        jLabel3.setText("Entrez les informations de la discipline que vous voulez ajouter ");

        jTextField2.setText("");

        jLabel4.setText("ID : ");

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
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    /*
      *Methode d'affichage d'ajout note
     */
    public static void ajout_note() {
        HashMap<Integer, Note> h_note_all = new HashMap<Integer, Note>();
        DAO<Note> note_all = DAO_Factory.getNoteDAO();
        h_note_all = note_all.show_all();
        
        JFrame frame_ajout = new JFrame();
        frame_ajout.setSize(900, 900);
        frame_ajout.setLocation(450, 100);
        frame_ajout.setTitle("ajout note  ");
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
        JTextField jTextField5 = new javax.swing.JTextField();

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
       jTable2.setModel(defmod);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                String id_temp1 =jTextField2.getText();    
                String id_temp2=jTextField3.getText();
                String id_temp3 =jTextField1.getText();   
                String id_temp4=jTextField5.getText();
                
                 int id_note_ajout = Integer.parseInt(id_temp1);
          

                int id_detail_bulletin_ajout_note = Integer.parseInt(id_temp2);
                double note_ajout_note = Double.parseDouble(id_temp4);
                boolean note_ajout=false;
                Note note = new Note(id_note_ajout, id_detail_bulletin_ajout_note,id_temp3,note_ajout_note);

             
                note_ajout=note_all.create(note);
                frame_ajout.dispose();
                ajout.ajout_note();          
            }
        });

        jTextField1.setText("");

        jLabel2.setText("ID detail bulletin:");

        jLabel3.setText("Entrez les informations de la note que vous voulez ajouter ");

        jTextField2.setText("");

        jLabel4.setText("Note");

        jLabel5.setText("ID note : ");

        jTextField3.setText("");

        jLabel6.setText("Appreciation");

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
                                                .addGap(143, 143, 143)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel6)
                                                .addGap(2, 2, 2)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

    }
    
}
