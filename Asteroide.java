package Jogo;

import java.awt.Image;
import java.awt.Rectangle;


import javax.swing.ImageIcon;

public class Asteroide 
{
	private Image imagem_asteroide;
	private int x, y;
	private int largura, altura;
	private boolean visibilidade_asteroide;
	
	//private static final int Largura_Tela = 1920;
	private static final int Velocidade_asteroide = 2;
	
	
	public Asteroide(int x, int y)
	{
		this.x = x;
		this.y = y;
		
	}
	
	public void estetica_asteroide()
	{
		var tiro = new ImageIcon("imagem\\Meteoro.png");
		imagem_asteroide = tiro.getImage();
		
		this.largura = imagem_asteroide.getHeight(null);
		this.largura = imagem_asteroide.getWidth(null);
		
		visibilidade_asteroide = true;
	}
	
	public void movimentar_asteroide()
	{
		
		this.x -= Velocidade_asteroide;
		
	}	
	


	public boolean Visibilidade_asteroide() {
		return visibilidade_asteroide;
	}


	public void setVisibilidade_asteroide(boolean visibilidade_asteroide) {
		this.visibilidade_asteroide = visibilidade_asteroide;
	}


	public Image getImagem_asteroide() {
		return imagem_asteroide;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, largura, altura);
	}

	
	

}
