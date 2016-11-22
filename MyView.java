/**
 * View Klasse des LightsOut Games das die grafische Oberfläche darstellt
 * @author Damjan Petrovic
 * @date 22.11.2016
 */

package Matosuschek;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JFrame;

public class MyView extends JFrame{
	private MyController c;
	private MyModel m;
	private JButton[][] Buttons;
	
	public MyView(MyModel m, MyController c){
		this.m = m;
		this.c = c;
		
		//2D-Array Deklarierung
		this.Buttons = new JButton[5][5];
		
		//Erzeugung des Fensters
		this.setTitle("LightsOut Game");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout Layout = new GridLayout(5,5);
		this.setLayout(Layout);
		
		//Initilialisierung der Buttons
		for(int i = 0; i<5; i++){
			for(int j = 0; j<5; j++){
				this.Buttons[i][j] = new JButton();
				Buttons[i][j].setBackground(Color.GREEN);
			}
		}
		
		this.setVisible(true);
	}
	
	
	public JButton[][] getButton(){
		return Buttons;
	}	
}

