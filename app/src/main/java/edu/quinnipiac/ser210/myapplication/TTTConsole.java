package edu.quinnipiac.ser210.myapplication;

import java.util.Scanner;
/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 * @author relkharboutly
 * @date 1/5/2017
 */

public class TTTConsole {
                                                     
      public static Scanner in = new Scanner(System.in); // the input Scanner
 
   public static TicTacToe TTTboard = new TicTacToe();
   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
      
	   int guessLoc;
	   int currentState = TicTacToe.PLAYING;
	   String userInput;
	   //game loop
	   do {
		 System.out.println("Enter the number slot you want to mark off.");
		 do {
			 guessLoc = in.nextInt();
			 if (TTTboard.board[guessLoc/5][guessLoc%5] != TicTacToe.EMPTY) System.out.println("Slot taken: pick another spot.");
		 } while (TTTboard.board[guessLoc/5][guessLoc%5] != TicTacToe.EMPTY);
		 TTTboard.setMove(0, guessLoc);
         TTTboard.printBoard();
         // Print message if game-over
         currentState = TTTboard.checkForWinner();
         
         if (currentState == ITicTacToe.CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == ITicTacToe.NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == ITicTacToe.TIE) {
            System.out.println("It's a TIE! Bye!");
         }
         
         TTTboard.setMove(1, TTTboard.getComputerMove());
         TTTboard.printBoard();
         // Print message if game-over
         currentState = TTTboard.checkForWinner();
         
         if (currentState == ITicTacToe.CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == ITicTacToe.NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == ITicTacToe.TIE) {
            System.out.println("It's a TIE! Bye!");
         }
     
         //user can break the loop. remove this line when you finish implementation.
         //userInput = in.next();
         
      } while ((currentState == ITicTacToe.PLAYING) /*&& (!userInput.equals("q"))*/); // repeat if not game-over
   }
 
     
}