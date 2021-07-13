package Jogo;

import java.awt.Image;


import javax.swing.ImageIcon;

public class Projetil 
{
	private Image imagem_tiro;
	private int x, y;
	private boolean visibilidade_tiro;
	
	private static final int Largura_Tela = 1920;
	private static final int Velocidade_tiro = 2;
	
	
	public Projetil(int x, int y)
	{
		this.x = x;
		this.y = y;
		
		var tiro = new ImageIcon("imagem\\TIRO.png");
		imagem_tiro = tiro.getImage();
		
		visibilidade_tiro = true;
		
	}
	
	public void movimentar_tiro()
	{
		this.x += Velocidade_tiro;
		if(this.x > Largura_Tela)
		{
			visibilidade_tiro = false;
		}
		
	}


	public boolean Visibilidade_tiro() {
		return visibilidade_tiro;
	}


	public void setVisibilidade_tiro(boolean visibilidade_tiro) {
		this.visibilidade_tiro = visibilidade_tiro;
	}


	public Image getImagem_tiro() {
		return imagem_tiro;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	

}
