package Jogo;

import java.awt.Component;

import javax.swing.JFrame;

public class Tela extends JFrame
{
	public Tela()
	{
		add(new Construcao_Jogo());                         
		setTitle("Space Shooters");							
		setSize(1920,1030);									
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		
	}

	
}
