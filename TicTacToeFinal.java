/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefinal;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
/**
 *
 * @author DAMITH DILANKA
 */
public class TicTacToeFinal extends JFrame {
    
     public TicTacToeFinal(){
        super("TIC TAC TOE");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,200);

         JPanel jpanel = new JPanel();
     

         MenuBarNeww panel1 = new  MenuBarNeww();
         panel1.setBackground(Color.GREEN);
         jpanel.setLayout(new BoxLayout(jpanel,BoxLayout.LINE_AXIS));
         panel1.setMaximumSize(new java.awt.Dimension(100,Integer.MAX_VALUE));
         jpanel.add(new GlobeBoard());
         jpanel.add( panel1);
        
        
        getContentPane().add(jpanel);
        setBounds(200,200,600,500);
   
   
        
        
        setVisible(true);

    }
    public static void main(String[] args) {
        
        OpeningWindow o = new OpeningWindow();
        
        
    }
        
    
    
}
