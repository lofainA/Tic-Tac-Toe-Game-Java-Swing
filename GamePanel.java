package main;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	int n = 3;
	int move = 0;
	
	ButtonGroup cells = new ButtonGroup();
	State[][] board = new State[n][n];
	JPanel gameBoard = new JPanel();
	JLabel titleCard = new JLabel("Tic-Tac-Toe");
	JButton restart = new JButton("Restart");
	
	GamePanel() {
		
		titleCard.setFont(new Font("Dialog", Font.PLAIN, 32));
		this.add(titleCard);
		
		gameBoard.setLayout(new GridLayout(n,n));
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = State.Blank;
				Cell cell = new Cell(this, i, j);
				gameBoard.add(cell);
				cells.add(cell);
			}
		}
		
		this.add(gameBoard);
		
		restart.addActionListener(e -> restart());
		this.add(restart);
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
		
		// match draw
		if(move == n*n) {
			titleCard.setText("ITS A TIEEE");
		}
	}
	
	public void disableAll() {
		for(int i = 0; i < n * n; i++) {
			gameBoard.getComponent(i).setEnabled(false);;
		}
	}
	
	public void restart() {
		
		// make the buttons of the button group an iterable
		Enumeration<AbstractButton> buttons = cells.getElements();
		
		// reset text of all buttons
		while(buttons.hasMoreElements()) {
			AbstractButton btn = buttons.nextElement();
			btn.setText("");
			btn.setEnabled(true);
		}
		
		// reset values of board matrix to state blank
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = State.Blank;
				System.out.println(board[i][j]);
			}
		}

		titleCard.setText("Tic-Tac-Toe"); // reset title card text
		move = 0; // reset move count to zero
	}
}
