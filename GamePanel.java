package main;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	int n = 3;
	int move = 0;
	
	State[][] board = new State[n][n];
	JPanel gameBoard = new JPanel();
	JLabel titleCard = new JLabel("Tic-Tac-Toe");
	
	GamePanel() {
		
		titleCard.setFont(new Font("Dialog", Font.PLAIN, 32));
		this.add(titleCard);
		
		gameBoard.setLayout(new GridLayout(n,n));
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = State.Blank;
				Cell cell = new Cell(this, i, j);
				gameBoard.add(cell);
			}
		}
		
		this.add(gameBoard);
	}
	
	public void checkForWin(int x, int y, State s) {
		// column win
		for(int i = 0; i < n; i++) {
			if(board[x][i] != s) {
				break;
			}
			if(i == n - 1) {
				titleCard.setText(s + " WON !!");
				disableAll();
				return;
			}
		}
		
		// row win
		for(int i = 0; i < n; i++) {
			if(board[i][y] != s) {
				break;
			}
			
			if(i == n - 1) {
				titleCard.setText(s + " WON !!");
				disableAll();
				return;
			}
		}
		
		// diagonal win
		if(x == y) {
			for(int i = 0; i < n; i++) {
				if(board[i][i] != s) {
					break;
				}
				if(i == n - 1) {
					titleCard.setText(s + " WON !!");
					disableAll();
					return;
				}
			}
		}
		
		// anti-diagonal win
		if(x + y == n - 1) {
			for(int  i = 0; i < n; i++) {
				if(board[i][n-i-1] != s) {
					break;
				}
				if(i == n - 1) {
					titleCard.setText(s + " WON !!");
					disableAll();
					return;
				}
			}
		}
		
		
		if(move == n*n) {
			titleCard.setText("ITS A TIEEE");
		}
	}
	
	public void disableAll() {
		for(int i = 0; i < n * n; i++) {
			gameBoard.getComponent(i).setEnabled(false);;
		}
	}
}
