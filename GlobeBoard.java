/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefinal;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
/**
 *
 * @author Buddhima
 */
public class GlobeBoard extends JPanel{
    
       static LocBoard locBoards[] = new LocBoard[9];
       private static String checkG;
       static String currentplayer="O";
       private static int xMarks=0;
       private static int oMarks=0;
       MenuBarNeww m1 = new MenuBarNeww();

    static void clearLboardBorder() {
        for (int i = 0; i < locBoards.length; i++) {
            locBoards[i].setBackground(Color.white);            
        }   
    }
    
    static void togletogglePlayer(){    
            if(currentplayer=="X"){
                currentplayer="O";
            }
            else if(currentplayer=="O"){
                currentplayer="X";
            }
        
    }
    static void calcMarks(){
      

        if(currentplayer=="X"){
                    setxMarks(getxMarks() - 5*1);
                }else if(currentplayer=="O"){
                    setoMarks(getoMarks() - 5*1);
                }
          
           
    }
   
    static void calcMarkWin(){
            if(currentplayer=="X"){
                    setxMarks(getxMarks() + 100);
                }else if(currentplayer=="O"){
                    setoMarks(getoMarks() + 100);
                }
            System.out.println(locBoards[0].oWin);
            
    }
    
    
    public void createLocalBoards() {
        for (int i = 0; i <= 8; i++) {
            locBoards[i] = new LocBoard();
            Border blackline, raisedetched, loweredetched,
                    raisedbevel, loweredbevel, empty,k;
            blackline = BorderFactory.createLineBorder(Color.black);
            raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
            loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
            raisedbevel = BorderFactory.createRaisedBevelBorder(); 
            loweredbevel = BorderFactory.createLoweredBevelBorder();
            
            k = BorderFactory.createBevelBorder(1);
            
            locBoards[i].setBorder(k);
            add(locBoards[i]);
        }
    }
    int alternate = 0;

    
    
    
    public GlobeBoard() {
        setSize(400,400);
        setLayout(new GridLayout(3, 3));
        createLocalBoards();
        
    }
    

    public static void oraganizeLocalBoard(int btnNum) {
        
        
        locBoards[btnNum].setBackground(Color.BLUE);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                locBoards[i].buttons[j].setEnabled(false);
                
            }
        }
        
        for (int j = 0; j < 9; j++) {
            {
                locBoards[btnNum].buttons[j].setEnabled(true);                
            }
            
            
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (((locBoards[btnNum].buttons[j]).getName().equals("clicked"))) 
                locBoards[i].buttons[j].setEnabled(false);                
            }
        }
           
           for (int i = 0; i < 9; i++) {
            if(locBoards[i].winChecker()==true && btnNum == i){
                enableAllBoards();
                
            }
        }
           
           for (int i = 0; i < 9; i++) {
            if(locBoards[i].winChecker()==true && btnNum == i){
             
            }
            
           }    
    checkWho();
    }
        
    public void initializebuttonsG() {
        for (int i = 0; i <= 8; i++) {
            locBoards[i].initializebuttons();
        }
    }
    
    public static void resetButtonsG() {
        for (int i = 0; i <= 8; i++) {
            locBoards[i].resetButtons();
            
           
        }
    }
    
    public static void enableAllBoards(){
          for (int i = 0; i < 9; i++) {
                          for (int j = 0; j < 9; j++) {
                              locBoards[i].buttons[j].setEnabled(true);
                          }
                          
                    }
    }
    

    
    public static void checkWho(){
        if(winCheckerG()==true){
            
            if(getCheckG()=="x"){
                JOptionPane.showMessageDialog(null, "X won");
                for (int i = 0; i < 9; i++) {
                          for (int j = 0; j < 9; j++) {
                              locBoards[i].buttons[j].setEnabled(false);
                          }
                          
                    }
                
            }else if(getCheckG()=="o"){
                JOptionPane.showMessageDialog(null, "O won");
                for (int i = 0; i < 9; i++) {
                          for (int j = 0; j < 9; j++) {
                              locBoards[i].buttons[j].setEnabled(false);
                          }
                          
                    }
            }
        
        }
    
    }

    
     public static boolean winCheckerG() {
            
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

        public static boolean checkCombinations(int a, int b) {
            setCheckG(locBoards[a].getName());
            if (locBoards[a].getName().equals(locBoards[b].getName()) && !locBoards[a].getName().equals("")) {
                return true;
            } else {
                return false;
            }
        }

    /**
     * @return the checkG
     */
    public static String getCheckG() {
        return checkG;
    }

    /**
     * @param checkG the checkG to set
     */
    public static void setCheckG(String checkG) {
        GlobeBoard.checkG = checkG;
    }

    /**
     * @return the xMarks
     */
    public static int getxMarks() {
        return xMarks;
    }

    /**
     * @return the oMarks
     */
    public static int getoMarks() {
        return oMarks;
    }

    /**
     * @param xMarks the xMarks to set
     */
    public static void setxMarks(int xMarks) {
        GlobeBoard.xMarks = xMarks;
    }

    /**
     * @param oMarks the oMarks to set
     */
    public static void setoMarks(int oMarks) {
        GlobeBoard.oMarks = oMarks;
    }
}
    

