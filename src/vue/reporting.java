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
/**
 *
 * @author meuni
 */
public class reporting {
    
     /**
     * METHODE PAGE REPORTING
     */
    public static void reporting() {
        JFrame frame_reporting = new JFrame();
        frame_reporting.setSize(900, 900);
        frame_reporting.setLocation(450, 100);
        frame_reporting.setTitle("reporting");
        frame_reporting.setVisible(true);

        //Affichage des graphiques 
        //affichage d'une phrase d'introduction que l'on place dans un JPANEL puis sur la JFRAME
        JScrollPane panel = new JScrollPane();
        JLabel phrase = new JLabel("Voici ci dessous divers diagrammes", JLabel.CENTER);
        panel.add(phrase);
        frame_reporting.add(panel);

    }


    
}
