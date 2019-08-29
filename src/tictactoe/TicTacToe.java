/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Bhavnani's
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TicTacToe implements ActionListener {
private JButton buttons[] = new JButton[9];
private JFrame window = new JFrame("Tic Tac Toe");
private boolean win = false;
private int count = 0;
private int Xwins = 0, Owins = 0;
private String letter = "";
private int[][] winCombinations = new int[][] {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //vertical wins
        {0, 4, 8}, {2, 4, 6}                     //diagonal wins
};
String name1 = JOptionPane.showInputDialog("Please enter first player's name");
String name2 = JOptionPane.showInputDialog("Please enter second player's name");

public TicTacToe(){
    JOptionPane.showMessageDialog(null,"Remember Player 1 is X and Player 2 is O.");
    window.setSize(300,300);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(new GridLayout(3,3));
    window.setVisible(true);


      for(int i=0; i<=8; i++){
          buttons[i] = new JButton();
          window.add(buttons[i]);
          buttons[i].addActionListener(this);
//          buttons[i].setBackground(Color.MAGENTA);
  }
////      for (JButton button: buttons) {
////           button.setBackground(Color.BLUE);
////        }

}

public void actionPerformed(ActionEvent event) {
        count++;
        if(count % 2 == 0){
            letter = "O";

        }else{
            letter = "X";
        }
         JButton pressedButton = (JButton)event.getSource(); 
         pressedButton.setText(letter);
         pressedButton.setEnabled(false);
         //pressedButton.setBackground(Color.WHITE);


    //Determine who won
    for(int i=0; i<=7; i++){
        if( buttons[winCombinations[i][0]].getText().equals(buttons[winCombinations[i][1]].getText()) && 
                buttons[winCombinations[i][1]].getText().equals(buttons[winCombinations[i][2]].getText()) && 
                buttons[winCombinations[i][0]].getText() != ""){
                win = true;
            }
        }
        if(win == true){
            if(letter == "X"){
                JOptionPane.showMessageDialog(null, name1 + " wins the game!");
            }else{
                JOptionPane.showMessageDialog(null, name2 + " wins the game!");
            }
            playAgain();
        }else if(count == 9 && win == false){
            JOptionPane.showMessageDialog(null, "The game is tied!");
            playAgain();
        }
    } 

public void playAgain(){
    if(letter == "X"){
        Xwins++;
    }else{
        Owins++;
    }
    JOptionPane.showMessageDialog(null, name1 + " has won this many times: " + Xwins);
    JOptionPane.showMessageDialog(null, name2 + " has won this many times: " + Owins);
    int response = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

    if(response == JOptionPane.YES_OPTION){
        reset();
    }else{
        System.exit(0);
    }
}

  public void reset() {
      for(int i = 0; i<=8; i++) {
              buttons[i].setText("");
              buttons[i].setEnabled(true); 
      }
      win = false;
      count = 0;
  }  

public static void main(String[] args){
    TicTacToe play = new TicTacToe();
   }
}
