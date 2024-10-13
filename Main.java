package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[]args) {
		
		int frameWidth = 450;
        int frameHeight = 540;
        
		JFrame frame =  new JFrame();
		
		Container panel = frame.getContentPane();
        panel.setBackground(Color.BLACK);
        
        GamePanel gp = new GamePanel();
        frame.add(gp);
        
        frame.setSize(frameWidth, frameHeight);
        frame.setTitle("Tic-tac-toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
	}
}