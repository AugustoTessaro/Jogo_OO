package Jogo;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Player extends Personagem implements Movimentos 
{
    
    private int dy;
	private List <Projetil> projeteis; // projetil compoe jogador
 
	
    public Player()
    {
    	super(50, 50);
        projeteis = new ArrayList<Projetil>();
    }

    public void atirar()
    {
    	this.projeteis.add(new Projetil(x + largura,y + altura/2));
    }
    
    
    public List<Projetil> getProjeteis() {
		return projeteis;
	}

	public void atualizarImagemPlayer()
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
    public void keyPressed(KeyEvent tecla)
    {
        int codTecla = tecla.getKeyCode();

        if(codTecla == KeyEvent.VK_W)
        {
            dy = -3;
        }

        if(codTecla == KeyEvent.VK_S)
        {
            dy = 3;
        }
        
        if(codTecla == KeyEvent.VK_SPACE)
        {
        	atirar();
        }

    }
    	
    @Override
    public void keyReleased(KeyEvent tecla) 
    {
        int codTecla = tecla.getKeyCode();

        if(codTecla == KeyEvent.VK_W || codTecla == KeyEvent.VK_S )
        {
            dy = 0;
        }
    }

	@Override
	public void setImagem() {
		var espaconave = new ImageIcon("imagem\\nave_pequena.png");
        this.imagem = espaconave.getImage();
		
	}


	
	
}