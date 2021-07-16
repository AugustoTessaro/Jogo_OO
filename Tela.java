package Jogo;

import javax.swing.JFrame;

public class Tela extends JFrame  // a Tela herda JFrame para podermos usar seus metodos e atributos para a criacao de um frame                          
{                                                            

	public Tela()                                            
	{   
		Jogo jogo = new Jogo(); // instancia um objeto do painel Jogo
		
		add(jogo); // adicionamos no nosso frame Tela uma instancia de painel do jogo
		setTitle("Space Shooters");							
		setSize(1920,1030);									
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		
	}

	
}
