/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefinal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Buddhima
 */
public class OpeningWindow extends JFrame{
    Player player = new Player();
    String name1=null;
    String name2=null;
    
    public OpeningWindow(){
       // super("")
        JButton b = new JButton("Start");
  
        JTextField t1 = new JTextField(30);
        JTextField t2 = new JTextField(30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               name1 = t1.getText();
               name2= t2.getText();
                player.setPlayer1(name1);
                player.setPlayer2(name2);
                new TicTacToeFinal();
                dispose();
            }
        
    }); 
        
        
        add(t1);
        add(t2);
        add(b);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
