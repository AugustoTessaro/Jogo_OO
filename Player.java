package Jogo;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player implements Movimentos 
{
	private int x;
	private int y;
	private int dy;
	private Image imagem_nave;
	private int altura , largura;
	
	
	public Player()
	{
		this.x = 100;
		this.y = 100;
	}
	
	
	public void esteticaPlayer()
	{
		ImageIcon espaco_nave = new ImageIcon("imagem\\nave.png");
		imagem_nave = espaco_nave.getImage();
		altura = imagem_nave.getHeight(null);
		largura = imagem_nave.getWidth(null);
	}
	
	public void atualizar_imagem()
	{
		y += dy;
	}


	@Override
	public void KeyPressed(KeyEvent tecla)
	{
		int cod_tecla = tecla.getKeyCode();
		
		if(cod_tecla == KeyEvent.VK_UP)
		{
			dy = -3;
		}
		
		if(cod_tecla == KeyEvent.VK_DOWN)
		{
			dy = 3;
		}
		
	}


	@Override
	public void KeyReleased(KeyEvent tecla) 
	{
		int cod_tecla = tecla.getKeyCode();
		
		if(cod_tecla == KeyEvent.VK_UP)
		{
			dy = -0;
		}
		
		if(cod_tecla == KeyEvent.VK_DOWN)
		{
			dy = 0;
		}
		
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Image getImagem_nave() {
		return imagem_nave;
	}


	public void setImagem_nave(Image espaco_nave) {
		this.imagem_nave = espaco_nave;
	}
	
	
	
	
}