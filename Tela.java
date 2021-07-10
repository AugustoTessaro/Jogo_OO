package Jogo;

import java.awt.Color;

import javax.swing.JFrame;

public class Tela extends JFrame
{
	public Tela()
	{
		add(new Construcao_Jogo());
		setTitle("Space Shooters");
		setSize(1920,1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(true);
		setVisible(true);
		getContentPane().setBackground(Color.BLACK);
	}

	public static void main (String []nargs)
	{
		new Tela();
	}
}
