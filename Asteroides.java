package Jogo;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Asteroides 
{
	private Image asteroide;
	private int x,y;
	private boolean visibilidade_asteroide;
	private  int Velocidade_asteroide = 3;
	
	private static final int Largura_Tela = 1920;
	
	
	public void Asteroide()
	{
		
		this.x = x;
		this.y = y;
		
		var img_provisoria = new ImageIcon();
		asteroide = img_provisoria.getImage();
		
		visibilidade_asteroide = true;
		
	}
	
	public void movimento_asteroide()
	{
		this.x += Velocidade_asteroide;
		if(this.x > Largura_Tela)
		{
			visibilidade_asteroide = false;
		}
		
	}

	
	
}
