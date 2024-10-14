package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	static JFrame frame =  new JFrame();
	public static void main(String[]args) {
		
		int frameWidth = 450;
        int frameHeight = 600;
        
        GamePanel gp = new GamePanel();
        frame.add(gp);
        
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(frameWidth, frameHeight);
        frame.setTitle("Tic-tac-toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
       
	}
}