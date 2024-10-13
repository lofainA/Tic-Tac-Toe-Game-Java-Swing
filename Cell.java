package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Cell extends JButton {
	
	int cellSize = 150;
    boolean filled = false;
    
    GamePanel gp;
    
    State state;
    int x, y;

    Cell(GamePanel gp, int x, int y) {
    	this.gp = gp;
    	this.x = x;
    	this.y = y;
    	
    	this.setBackground(Color.WHITE);
        this.setEnabled(true);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(cellSize, cellSize));
        this.addActionListener((ActionEvent e) -> move());
        this.setFont(new Font("Comic Sans", Font.BOLD, 32));
    }

    public void move() {
        this.filled = true;
        this.setEnabled(false);
        
        gp.move++;
        
        if(gp.move % 2 == 0) {
        	this.setText("O");
        	gp.board[x][y] = State.O;
        	gp.checkForWin(x, y, State.O);
        } 
        
        else if(gp.move % 2 != 0) {
        	this.setText("X");
        	gp.board[x][y] = State.X;
        	gp.checkForWin(x, y, State.X);
        }
    }
}
