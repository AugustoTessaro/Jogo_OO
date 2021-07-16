package Jogo;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class Personagem  // personagem e uma classe abstrata que representa todos os atributos e metodos que todos os integrantes do jogo possuem
{

	protected int x,y;
	protected Image imagem;
	protected boolean visibilidade;
	protected int largura, altura;

	public Personagem(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.visibilidade = true;
		this.setImagem();
		altura = this.imagem.getHeight(null);
        largura = this.imagem.getWidth(null);
	}
	
	public boolean isVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
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
	public Image getImagem() {
		return imagem;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, largura, altura);
	}
	
	
	public abstract void setImagem();
	
	
		
	

}
