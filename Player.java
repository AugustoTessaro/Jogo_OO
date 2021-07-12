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
		this.x = 50;
		this.y = 50;
	}
	


	public void esteticaPlayer()
	{
		ImageIcon espaco_nave = new ImageIcon("imagem\\nave_pequena.png");
		imagem_nave = espaco_nave.getImage();
		altura = imagem_nave.getHeight(null);
		largura = imagem_nave.getWidth(null);
	}
	
	public void atualizar_imagem_player()
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


	public int getY() {
		return y;
	}


	public Image getImagem_nave() {
		return imagem_nave;
	}


	
