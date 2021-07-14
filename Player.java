package Jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player implements Movimentos 
{
    private int x;
    private int y;
    private int dy;
    private Image imagem_nave;
    private boolean Visibilidade_player;
   

	private List <Projetil> projetil;
    private int altura , largura;


    public Player()
    {
        this.x = 50;
        this.y = 50;
    }


    public void esteticaPlayer()
    {
    	
        var espaco_nave = new ImageIcon("imagem\\nave_pequena.png");
        imagem_nave = espaco_nave.getImage();
        
        altura = imagem_nave.getHeight(null);
        largura = imagem_nave.getWidth(null);
       
        projetil = new ArrayList<Projetil>();
    }

    
    public void atirar()
    {
    	this.projetil.add(new Projetil(x + largura,y + altura/2));
    }
    
    
    public List<Projetil> getProjetil() {
		return projetil;
	}



	public void atualizar_imagem_player()
    {
    	if(dy == -3){
            var testeY = y + dy;

            if(testeY > 0){
                y = testeY;
            }
            else{
                y = 0;
            }
        }

        if(dy == 3){
            var testeY = y + dy;

            if(testeY + 125 < 1030){
                y = testeY;
            }
            else {
                y = 1030 - 125;
            }
        }
    }



    @Override
    public void KeyPressed(KeyEvent tecla)
    {
        int cod_tecla = tecla.getKeyCode();

        if(cod_tecla == KeyEvent.VK_W)
        {
            dy = -3;
        }

        if(cod_tecla == KeyEvent.VK_S)
        {
            dy = 3;
        }
        
        if(cod_tecla == KeyEvent.VK_SPACE)
        {
        	atirar();
        }

    }



    @Override
    public void KeyReleased(KeyEvent tecla) 
    {
        int cod_tecla = tecla.getKeyCode();

        if(cod_tecla == KeyEvent.VK_W || cod_tecla == KeyEvent.VK_S)
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
    
    public Rectangle getBounds()
	{
		return new Rectangle(x, y, largura, altura);
	}
    
    
    public boolean isVisibilidade_player() 
    {
		return Visibilidade_player;
	}

	public void setVisibilidade_player(boolean visibilidade_player) 
	{
		Visibilidade_player = visibilidade_player;
	}
	
}