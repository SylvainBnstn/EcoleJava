/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import vue.*;
import Modele.*;
import Controleur.*;
import vue.recherche;

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

/**
 *
 * @author meuni
 */
public class interface_graphique {

    /**
     * METHODE DE CHOIX CONSOLE OU GRAPHIQUE
     */
    public static void choix() {

        //Creation de notre JFrame
        JFrame frame_choix = new JFrame();
        frame_choix.setSize(900, 900);
        frame_choix.setLocation(450, 100);
        frame_choix.setTitle("choix");
        frame_choix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //affichage des boutons choix graphique ou choix console
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        JButton console = new JButton("Console");
        console.setBackground(Color.LIGHT_GRAY);
        //button1.setPreferredSize(new Dimension(400, 70));

        JButton graphique = new JButton("Graphique");
        graphique.setBackground(Color.PINK);
        frame_choix.setVisible(true);
        //button2.setPreferredSize(new Dimension(400, 70));

        panel.add(console);

        panel.add(graphique);

        frame_choix.add(panel);
        
        frame_choix.setVisible(true);

        //Quand on clique sur graphique, ça ouvre la page de connexion a la BDD
        graphique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_choix.dispose();
                interface_graphique.connexion();
            } 
        });
        //Quand on clique sur console
        console.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame_choix.dispose();
                Console.console();
            } 
        });

    }

    /**
     * METHODE création connexion
     */
    public static void connexion() {

        //Creation d'une JFrame
        JFrame frame_connexion = new JFrame();
        frame_connexion.setSize(900, 900);
        frame_connexion.setLocation(450, 100);
        frame_connexion.setTitle("connexion");
        frame_connexion.setVisible(true);
        frame_connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //connexion_label.setLocation(453, 2000);
        //panel.setLayout(new GridLayout(1,9));
        //panel.setLayout(new BoxLayout(panel,1));
        //Creation des login, password, etc...
        JLabel serveur = new JLabel("serveur");
        JTextField serveurTexte = new JTextField(12);

        JLabel nomBDD = new JLabel("nom base de donnees");
        JTextField nomBDDTexte = new JTextField(12);

        JLabel loginBDD = new JLabel("login base de donnees");
        JTextField loginBDDTexte = new JTextField(12);

        JLabel mdpBDD = new JLabel("Entrez votre mot de passe ");
        JPasswordField mdpBDDTexte = new JPasswordField(12);
        
        

        //ajout des affichages dans le premier panel
        JPanel panel = new JPanel();
        panel.add(serveur);
        panel.add(serveurTexte);

        panel.add(nomBDD);
        panel.add(nomBDDTexte);

        panel.add(loginBDD);
        panel.add(loginBDDTexte);

        panel.add(mdpBDD);
        panel.add(mdpBDDTexte);

        frame_connexion.add(panel);

        //Bouton de connexion 
        JButton connect = new JButton("Connexion a la BDD");
        panel.add(connect);

        //Affichage label connexion dans un deuxieme panel
        Font font = new Font("Courier", Font.BOLD, 20);
        frame_connexion.setFont(font);
        JLabel connexion_label = new JLabel("CONNEXION : ");
        JPanel p0 = new JPanel();
        p0.add(connexion_label);
        frame_connexion.add(p0);

        //Positionnement et mise en forme des panels
        panel.setBackground(Color.PINK);
        p0.setBackground(Color.LIGHT_GRAY);
        frame_connexion.add(p0, BorderLayout.NORTH);
        frame_connexion.add(panel, BorderLayout.CENTER);

        //Quand on clique sur connexion, ça ouvre la page d'accueil
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serveur_name = serveurTexte.getText();
                String name_bdd = nomBDDTexte.getText();
                String log_bdd = loginBDDTexte.getText();
                String pass_bdd = mdpBDDTexte.getText();
                frame_connexion.dispose();
                interface_graphique.accueil();
            }
        });

    }

    /**
     * METODE QUI INSTANCIE LA PAGE D'ACCUEIL
     */
    public static void accueil() {
        JFrame frame_accueil = new JFrame();
        frame_accueil.setSize(900, 900);
        frame_accueil.setLocation(450, 100);
        frame_accueil.setTitle("accueil");
        frame_accueil.setVisible(true);
        frame_accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //affichage des boutons choix graphique ou choix console
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        JButton recherche1 = new JButton("Recherche");
        JButton maj = new JButton("Mise a jour ");
        JButton reporting1 = new JButton("Reporting");

        panel.add(recherche1);
        panel.add(maj);
        panel.add(reporting1);

        frame_accueil.add(panel);

        //Affichage label connexion dans un deuxieme panel
        Font font = new Font("Courier", Font.BOLD, 20);
        frame_accueil.setFont(font);
        JLabel question = new JLabel(" Que voulez vous faire ?");
        JPanel p0 = new JPanel();
        p0.add(question);
        frame_accueil.add(p0);

        //Positionnement et mise en forme des panels
        panel.setBackground(Color.PINK);
        p0.setBackground(Color.LIGHT_GRAY);
        frame_accueil.add(p0, BorderLayout.NORTH);
        frame_accueil.add(panel, BorderLayout.CENTER);

        //Quand on clique sur Recherche
        recherche1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche.choix_classe_recherche();
              
               
                
                

            }
        });

        //Quand on clique sur Mise a jour
        maj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interface_graphique.choix_maj();

            }
        });

        //Quand on clique sur Reporting
        reporting1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reporting.reporting();
                

            }
        });

    } //Fin methode  accueil

    /**
     * METHODE CHOIX DE MISE A JOUR
     */
    public static void choix_maj() {
        JFrame frame_choix = new JFrame();
        frame_choix.setSize(900, 900);
        frame_choix.setLocation(450, 100);
        frame_choix.setTitle("choix mise a jour");
        frame_choix.setVisible(true);

        JLabel question = new JLabel("Quel type de mise a jour voulez vous faire ? ", JLabel.CENTER);

        //affichage des boutons de choix 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        JButton button_ajout = new JButton("Ajout");
        JButton button_suppr = new JButton("Suppression ");
        JButton button_modif = new JButton("Modification");

        panel.add(question);
        panel.add(button_ajout);
        panel.add(button_suppr);
        panel.add(button_modif);

        frame_choix.add(panel);

        //Quand on clique sur Ajout
        button_ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout.choix_classe_ajout();
            }
        });

        //Quand on clique sur Supression
        button_suppr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suppression.choix_classe_suppr();

            }
        });

        //Quand on clique sur Modification
        button_modif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modification.choix_classe_modif();

            }
        });

    } //Fin methode choix_maj
    
    

}
