/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 1/5/2017
 */
package edu.quinnipiac.ser210.myapplication;

public class TicTacToe implements ITicTacToe {
		 
	   // The game board and the game status
	   private static final int ROWS = 5, COLS = 5; // number of rows and columns
	   public int[][] board = new int[ROWS][COLS]; // game board in 2D array
	   private static final int HUMAN_PLAYER = 0;
	   private static final int COMPUTER_PLAYER = 1;
	   private int token;
	   private int computerChoice;
	   private boolean slotOpen;
	  
	/**
	 * clear board and set current player   
	 */
	public TicTacToe(){
		for (int[] row: board) {
			for (int slot: row) {
				slot = EMPTY;
			}
		}
	}
	@Override
	public void clearBoard() {
		for (int[] row: board) {
			for (int slot: row) {
				slot = EMPTY;
			}
		}

	}

	@Override
	public void setMove(int player, int location) {
		
		if (player == HUMAN_PLAYER) {
			token = CROSS;
		} else token = NOUGHT;
		
		if (board[location/5][location%5]!=EMPTY) {
			slotOpen = false;
			System.out.println("Slot taken: pick another spot.");
		} else {
			slotOpen = true;
			board[location/5][location%5] = token;
		}
	}

	@Override
	public int getComputerMove() {
		do {
			computerChoice = (int) (24*Math.random());
			if (board[computerChoice/5][computerChoice%5]!=EMPTY) slotOpen = false;
				else slotOpen = true;
		} while (!slotOpen);
		return computerChoice;
	}

	@Override
	public int checkForWinner() {
		//horizontal checks
		for (int[] row: board) {
			if (row[1]!=EMPTY&&row[1]==row[2]&&row[2]==row[3]&&(row[0]==row[1]||row[3]==row[4])) {
				if(row[1]==CROSS) return ITicTacToe.CROSS_WON;
						else return ITicTacToe.NOUGHT_WON; 
			}
		}
		//vertical checks
		for(int i = 0; i < 5; i++) {
			if (board[1][i]!=EMPTY&&board[1][i]==board[2][i]&&board[2][i]==board[3][i]&&(board[0][i]==board[1][i]||board[3][i]==board[4][i])) {
				if(board[1][i]==CROSS) return ITicTacToe.CROSS_WON;
				else return ITicTacToe.NOUGHT_WON; 
			}
		}
		//diagonal checks
		if (board[1][1]!=EMPTY&&board[1][1]==board[2][2]&&board[2][2]==board[3][3]&&(board[0][0]==board[1][1]||board[3][3]==board[4][4])) {
			if(board[1][1]==CROSS) return CROSS_WON;
			else return NOUGHT_WON; 
		}
		if (board[2][2]!=EMPTY&&board[1][3]==board[2][2]&&board[2][2]==board[3][1]&&(board[0][4]==board[1][3]||board[3][1]==board[4][0])) {
			if(board[1][1]==CROSS) return CROSS_WON;
			else return NOUGHT_WON; 
		}
		if (board[0][1]!=EMPTY&&board[0][1]==board[1][2]&&board[1][2]==board[2][3]&&board[2][3]==board[3][4]) {
			if(board[1][1]==CROSS) return CROSS_WON;
			else return NOUGHT_WON; 
		}
		if (board[1][0]!=EMPTY&&board[1][0]==board[2][1]&&board[2][1]==board[3][2]&&board[3][2]==board[4][3]) {
			if(board[1][1]==CROSS) return CROSS_WON;
			else return NOUGHT_WON; 
		}
		if (board[0][3]!=EMPTY&&board[0][3]==board[1][2]&&board[1][2]==board[2][1]&&board[2][1]==board[3][0]) {
			if(board[1][1]==CROSS) return CROSS_WON;
			else return NOUGHT_WON; 
		}
		if (board[1][4]!=EMPTY&&board[1][4]==board[2][3]&&board[2][3]==board[3][2]&&board[3][2]==board[4][1]) {
			if(board[1][1]==CROSS) return CROSS_WON;
			else return NOUGHT_WON; 
		}
		//check to see if full
		for(int[] row:board) {
			for (int slot:row) {
				if (slot == EMPTY) return PLAYING;
			}
		}
		return TIE;
	}
	
	  /**
	   *  Print the game board 
	   */
	   public  void printBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[row][col]); // print each of the cells
	            if (col != COLS - 1) {
	               System.out.print("|");   // print vertical partition
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("-------------------"); // print horizontal partition
	         }
	      }
	      System.out.println();
	   }
	 
	   /**
	    * Print a cell with the specified "content" 
	    * @param content either CROSS, NOUGHT or EMPTY
	    */
	   public  void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case CROSS:  System.out.print(" X "); break;
	      }
	   }

}
