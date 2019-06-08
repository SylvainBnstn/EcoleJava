/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author meuni
 */
public class Graphique {

    /**
     * @param args the command line arguments
     */
    //création d'une méthode choix graphique ou console
   

  

    public static void main(String[] args) {
        // TODO code application logic here
        UIManager.put("Button.font", new Font("Arial",Font.BOLD,20));
        Graphique graphique = new Graphique();
        interface_graphique.choix();
        //interface_graphique.connexion();

        // Menu
    }

}
