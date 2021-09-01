package Jogo;

import javax.swing.ImageIcon;

public class Asteroide extends Personagem
{
	
	public Asteroide(int x, int y) {
		super(x, y);
	}

	private static final int VELOCIDADE= 2;
	
	

	public void movimentarAsteroide()
	{	
		this.x -= VELOCIDADE;
	}	

	@Override
	public void setImagem() 
	{
		var imagemAsteroide = new ImageIcon("imagem\\Meteoro.png");
		this.imagem = imagemAsteroide.getImage();
	}
} alberto
