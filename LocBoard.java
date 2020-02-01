/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
/**
 *
 * @author Buddhima
 */
public class LocBoard extends JPanel{
    
    JButton[] buttons = new JButton[9];
    private String XO = "";
    Player players = new Player();
    static boolean xWin=false;
    static boolean oWin=false;
    
    static int alternate = 0;

    public LocBoard() {
        setLayout(new GridLayout(3, 3));
        initializebuttons();
        setName("");
    }

    public void initializebuttons() {
        
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].setName("NotClicked");
            buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 30));
            buttons[i].addActionListener(new buttonListener());
            Border blackline, raisedetched, loweredetched,
                    raisedbevel, loweredbevel, empty;
            raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
            loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
            raisedbevel = BorderFactory.createRaisedBevelBorder();
            loweredbevel = BorderFactory.createLoweredBevelBorder();
            buttons[i].setBorder(raisedbevel);
            add(buttons[i]);           
        }
    }


    public void resetButtons() {
        for (int i = 0; i <= 8; i++) {
            buttons[i].setText("");
        }
    }

  
    private class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            GlobeBoard.clearLboardBorder();
            winChecker();
            
            
            JButton btn = (JButton) e.getSource(); 


                GlobeBoard.togletogglePlayer();
                btn.setText(GlobeBoard.currentplayer);
                
                
            GlobeBoard.calcMarks();    

            if (winChecker() == true) {
                if (btn.getText().equals("O")) {
                    setName("O");
                    removeAll();
                    GlobeBoard.calcMarkWin();
                       oWin=true;

                       
                       setLayout(new BorderLayout());
                       ImageIcon icon = new ImageIcon("src\\o.png");
                      
                      
                       JLabel label = new JLabel(icon,JLabel.CENTER);
                       add(label);
                    
                      
                    
        
                    
                }
                else if(btn.getText().equals("X")){
                      setName("X");
                      GlobeBoard.calcMarkWin();
                      xWin=true;
                    removeAll();


                      setLayout(new BorderLayout());
                       ImageIcon icon = new ImageIcon("src\\x.png");
                      
                      JLabel label = new JLabel(icon,JLabel.CENTER);
                      
                    add(label);
                    
                }

            }

            
            int btnNumber = 0;
            for (int i = 0; i < 9; i++) {
                if (btn == buttons[i]) {
                    btnNumber = i;
                }
            }
            btn.setName("clicked");
         
            btn.setEnabled(false);

            GlobeBoard.oraganizeLocalBoard(btnNumber);
            

        }
     
    }
    
    
    public boolean winChecker() {
            

          
            if (checkCombinations(0, 1) && checkCombinations(1, 2)) 
            {
                return true;
            } else if (checkCombinations(3, 4) && checkCombinations(4, 5)) {
                return true;
            } else if (checkCombinations(6, 7) && checkCombinations(7, 8)) {
                return true;
            } 
            else if (checkCombinations(0, 3) && checkCombinations(3, 6)) {
                return true;
            } else if (checkCombinations(1, 4) && checkCombinations(4, 7)) {
                return true;
            } else if (checkCombinations(2, 5) && checkCombinations(5, 8)) {
                return true;
            } 
            else if (checkCombinations(0, 4) && checkCombinations(4, 8)) {
                return true;
            } else if (checkCombinations(2, 4) && checkCombinations(4, 6)) {
                return true;
            } else {
                return false;
            }

        }

        public boolean checkCombinations(int a, int b) {
            if (buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("")) {
                return true;
            } else {
                return false;
            }
        }

    /**
     * @return the XO
     */
    public String getXO() {
        return XO;
    }

    /**
     * @param XO the XO to set
     */
    public void setXO(String XO) {
        this.XO = XO;
    }

  

 
    
}
    

