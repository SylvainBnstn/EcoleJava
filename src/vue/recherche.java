/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import vue.*;

/**
 *
 * @author meuni
 */
public class recherche {
    
    
    /**
     * METHODE CHOIX DE CLASSE A RECHERCHER
     */
    public static void choix_classe_recherche() {
        JFrame frame_choix = new JFrame();
        frame_choix.setSize(900, 900);
        frame_choix.setLocation(450, 100);
        frame_choix.setTitle("choix classe");
        frame_choix.setVisible(true);

        //Affichage label question dans un deuxieme panel
        Font font = new Font("Courier", Font.BOLD, 20);
        frame_choix.setFont(font);
        JLabel question = new JLabel("Dans quelle classe voulez vous effectuer la recherche ?", JLabel.CENTER);
        JPanel p0 = new JPanel();
        p0.add(question);
        frame_choix.add(p0);

        //affichage des boutons de choix 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));
        JButton button_eleve = new JButton("Eleve");
        JButton button_prof = new JButton("Enseignant ");
        JButton button_bulletin = new JButton("Bulletin");
        JButton button_classe = new JButton("Classe");
        JButton button_niveau = new JButton("Niveau");
        JButton button_annee = new JButton("Anne scolaire");
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

        frame_choix.add(panel, BorderLayout.CENTER);
        frame_choix.add(p0, BorderLayout.NORTH);

        //Quand on clique sur Eleve
        button_eleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche.recherche_eleve();

            }
        });

        //Quand on clique sur Prof
        button_prof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("coucou2");
                recherche.recherche_enseignant();

            }
        });

        //Quand on clique sur Bulletin
        button_bulletin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche.recherche_bulletin();

            }
        });

        //Quand on clique sur Classe
        button_classe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche.recherche_classe();

            }
        });

        //Quand on clique sur niveau
        button_niveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche.recherche_niveau();

            }
        });

        //Quand on clique sur annee
        button_annee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche.recherche_annee();

            }
        });

        //Quand on clique sur trimestre
        button_trimestre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche.recherche_trimestre();

            }
        });

        //Quand on clique sur discipline
        button_discipline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche.recherche_discipline();

            }
        });

    } //Fin methode choix_classe

    /**
     * METHODE d'affichage du resultat de la recherche d'un eleve
     */
    static void recherche_eleve() {

        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche eleve");
        frame_recherche.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Recherche");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
                recherche.recherche_eleve_trouvee();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez rechercher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_recherche.getContentPane());
        frame_recherche.getContentPane().setLayout(layout);
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

    static void recherche_eleve_trouvee() {

        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche enseignant");
        frame_recherche.setVisible(true);
    }

    /**
     * METHODE d'affichage du resultat de la recherche d'un enseignant
     */
    static void recherche_enseignant() {

        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche enseignant");
        frame_recherche.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Rechercher");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
                recherche.recherche_enseignant_trouvee();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez supprimer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_recherche.getContentPane());
        frame_recherche.getContentPane().setLayout(layout);
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

    static void recherche_enseignant_trouvee() {
        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche bulletin");
        frame_recherche.setVisible(true);
    }

    /**
     * Methode de Recherche d'un bulletin
     */
    static void recherche_bulletin() {

        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche bulletin");
        frame_recherche.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Recherche");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
                recherche.recherche_bulletin_trouvee();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez rechercher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_recherche.getContentPane());
        frame_recherche.getContentPane().setLayout(layout);
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

    static void recherche_bulletin_trouvee() {
        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche bulletin");
        frame_recherche.setVisible(true);
    }

    static void recherche_classe() {

        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche classe");
        frame_recherche.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Recherche");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
                recherche.recherche_classe_trouvee();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez rechercher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_recherche.getContentPane());
        frame_recherche.getContentPane().setLayout(layout);
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

    static void recherche_classe_trouvee() {
        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche classe");
        frame_recherche.setVisible(true);
    }

    /**
     * Methode de recherche niveau
     */
    static void recherche_niveau() {

        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche niveau");
        frame_recherche.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Rechercher");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
                recherche.recherche_niveau_trouvee();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez rechercher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_recherche.getContentPane());
        frame_recherche.getContentPane().setLayout(layout);
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

    static void recherche_niveau_trouvee() {
        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche niveau");
        frame_recherche.setVisible(true);
    }

    /**
     * Methode de recherche pour une annee
     */
    static void recherche_annee() {

        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche annee");
        frame_recherche.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Rechercher");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
                recherche.recherche_annee_trouvee();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez rechercher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_recherche.getContentPane());
        frame_recherche.getContentPane().setLayout(layout);
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

    static void recherche_annee_trouvee() {
        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche bulletin");
        frame_recherche.setVisible(true);
    }

    /**
     * Recherche d'un trimestre
     */
    static void recherche_trimestre() {

        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche trimestre");
        frame_recherche.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Rechercher");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
                recherche.recherche_trimestre_trouvee();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez rechercher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_recherche.getContentPane());
        frame_recherche.getContentPane().setLayout(layout);
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

    static void recherche_trimestre_trouvee() {
        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche trimestre");
        frame_recherche.setVisible(true);
    }

    /**
     * Recherche d'une discipline
     */
    static void recherche_discipline() {

        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche disciline");
        frame_recherche.setVisible(true);

        JButton supprimer = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();

        supprimer.setText("Recherche");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
                recherche.recherche_discipline_trouvee();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rentrez l'ID de l'objet que vous souhaitez rechercher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_recherche.getContentPane());
        frame_recherche.getContentPane().setLayout(layout);
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

    static void recherche_discipline_trouvee() {
        JFrame frame_recherche = new JFrame();
        frame_recherche.setSize(900, 900);
        frame_recherche.setLocation(450, 100);
        frame_recherche.setTitle("recherche discipline");
        frame_recherche.setVisible(true);
    }

    
}
