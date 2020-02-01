/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefinal;

/**
 *
 * @author Buddhima
 */
public class Player {
    private static String player1=null;
    private static String player2=null;
    private int Xmarks;
    private int Omarks;

    /**
     * @return the player1
     */
    public static String getPlayer1() {
        return player1;
    }

    /**
     * @return the player2
     */
    public static String getPlayer2() {
        return player2;
    }

    /**
     * @return the Xmarks
     */
    public int getXmarks() {
        return Xmarks;
    }

    /**
     * @return the Omarks
     */
    public int getOmarks() {
        return Omarks;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    /**
     * @param Xmarks the Xmarks to set
     */
    public void setXmarks(int Xmarks) {
        this.Xmarks = Xmarks;
    }

    /**
     * @param Omarks the Omarks to set
     */
    public void setOmarks(int Omarks) {
        this.Omarks = Omarks;
    }

    
    
    
}
