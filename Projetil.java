package Jogo;

import javax.swing.ImageIcon;

public class Projetil extends Personagem 
{
	private static final int LARGURA_MAX = 1100;
	private static final int VELOCIDADE = 4;
	
	public Projetil(int x, int y) {
		super(x, y);
		
	}

	public void movimentarTiro()
	{
		this.x += VELOCIDADE;
		if(this.x > LARGURA_MAX)
		{
			this.visibilidade = false;
		}
		
	}

	@Override
	public void setImagem() 
	{
		var tiro = new ImageIcon("imagem\\TIRO.png");
		this.imagem = tiro.getImage();
	
		
	}

}
