package Jogo;

import javax.swing.JFrame;

public class Tela extends JFrame                             // Classe tela que herda a classe Jframe, essa classe é usada para definir como será o frame do jogo
{                                                            
	public Tela()                                            
	{                                                        
		add(new Construcao_Jogo());                          // A classe Main só é capaz de executar todo o jogo porque na metodo Tela adicionamos o metodo construtor da classe Construcao_Jogo que é onde todos os objetos são instanciados 
		setTitle("Space Shooters");							
		setSize(1920,1030);									
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		
	}

	
}
