package Jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public class Construcao_Jogo extends JPanel implements ActionListener, KeyListener
{

    private Image PlanoDeFundo;
    private Player jogador;
    private Timer delay;
    private boolean status_jogo;
    private List<Asteroide> asteroide;
 
    

    public Construcao_Jogo()
    {
        ImageIcon fundo = new ImageIcon("imagem\\planodefundo.jpg");
        PlanoDeFundo = fundo.getImage();

        jogador = new Player();
        jogador.esteticaPlayer();
        gerar_asteroides();
        
        setFocusable(true);
        addKeyListener(this);
        status_jogo = true;

        delay = new Timer(3,this);
        delay.start();
    }
    
    
    
    public void gerar_asteroides()
    {
    	int coordendas_asteroide [] = new int [100];
    	asteroide = new ArrayList<Asteroide>();
    	
    	for (int i = 0; i < coordendas_asteroide.length; i++) 
    	{
    		int x = (int)(Math.random() * 8000+1920);
    		int y = (int)(Math.random() * 1000+30);
    		asteroide.add(new Asteroide(x,y));
			
		}
    }
    
    
    public void paint(Graphics g)
    {
        Graphics2D graficos = (Graphics2D) g;
        
        if(status_jogo == true)	
        {
        	
	        graficos.drawImage(PlanoDeFundo, 1, 1, null);
	        graficos.drawImage(jogador.getImagem_nave(), jogador.getX(), jogador.getY(),this);
	        
	        List<Projetil> projetil = jogador.getProjetil();
        
	        for(int a = 0; a < projetil.size(); a++)
	        {
	        	Projetil p = projetil.get(a);
	        	graficos.drawImage(p.getImagem_tiro(), p.getX(), p.getY(), this);
	        }
        
	        for (int e = 0; e < asteroide.size(); e ++)
	        {
	        	Asteroide obj_asteroide = asteroide.get(e);
	        	obj_asteroide.estetica_asteroide();
	        	graficos.drawImage(obj_asteroide.getImagem_asteroide(), obj_asteroide.getX(), obj_asteroide.getY(), this);
	        }
        }
        
        else
        {
        	ImageIcon GameOver = new ImageIcon("imagem\\GameOver(1).png");
        	graficos.drawImage(GameOver.getImage(), 0, 0, null);
        }
        
        g.dispose();
        
    }
    


    @Override
    public void actionPerformed(ActionEvent e)
    {
    	
    	jogador.atualizar_imagem_player();
    	
    	List<Projetil> projetil = jogador.getProjetil();
    	
	    	for(int a = 0; a < projetil.size(); a++)
	    	{
	    		Projetil p = projetil.get(a);
	    		
	    		if(p.Visibilidade_tiro())
		    		{
		    			p.movimentar_tiro();
		    		}
	    		
		    		else
		    		{
		    			projetil.remove(a);
		    		}
	    	}
	    	
	    	for (int i = 0; i < asteroide.size(); i++) 
	    	{
	    		Asteroide at = asteroide.get(i);
	    		if(at.Visibilidade_asteroide())
		    		{
		    			at.movimentar_asteroide();
		    			
		    		}
		    		else
		    		{
		    			asteroide.remove(i);
		    		}
			}
	    	
    	Checa_Colisoes();
        repaint();
    }
    
    
    
    public void Checa_Colisoes()                                 
    {
    	Rectangle retangulo_nave = jogador.getBounds();
    	Rectangle retangulo_asteroide;
    	Rectangle retangulo_projetil;
    	
    	for (int i = 0; i < asteroide.size(); i++) 
    	{
    		Asteroide asteroide_temporario = asteroide.get(i);
    		retangulo_asteroide = asteroide_temporario.getBounds();
    		
    		if(retangulo_nave.intersects(retangulo_asteroide))
    		{
    			jogador.setVisibilidade_player(false);
    			asteroide_temporario.setVisibilidade_asteroide(false);
    			status_jogo = false;
    		
    		}	
		}
    	
    	List<Projetil> projetil = jogador.getProjetil();
    	for (int i = 0; i < projetil.size(); i++) 
    	{
    		Projetil projetil_temporario = projetil.get(i);
    		retangulo_projetil = projetil_temporario.getBounds();
    		
    		for (int j = 0; j < asteroide.size(); j++) 
    		{
    			Asteroide asteroide_temporario = asteroide.get(j);
        		retangulo_asteroide = asteroide_temporario.getBounds();
        		
        		if(retangulo_projetil.intersects(retangulo_asteroide))
        		{
        			projetil_temporario.setVisibilidade_tiro(false);
        			asteroide_temporario.setVisibilidade_asteroide(false);
        		}
			}
		}
     }
    
    
    @Override
    public void keyTyped(KeyEvent e) { 
 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        jogador.KeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        jogador.KeyReleased(e);
    }


}