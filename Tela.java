package Jogo;

import javax.swing.JFrame;

public class Tela extends JFrame                             // Classe tela que herda a classe Jframe, essa classe � usada para definir como ser� o frame do jogo
{                                                            
	public Tela()                                            
	{                                                        
		add(new Construcao_Jogo());                          // A classe Main s� � capaz de executar todo o jogo porque na metodo Tela adicionamos o metodo construtor da classe Construcao_Jogo que � onde todos os objetos s�o instanciados 
		setTitle("Space Shooters");							
		setSize(1920,1030);									
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		
	}

	
}
