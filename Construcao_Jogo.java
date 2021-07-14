package Jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Construcao_Jogo extends JPanel implements ActionListener, KeyListener
{

    private Image PlanoDeFundo;
    private Player jogador;
    private Timer delay;
    private boolean status_jogo = true;
    
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

        delay = new Timer(2,this);
        delay.start();
    }
    
    public void gerar_asteroides()
    {
    	int coordendas_asteroide [] = new int [1000];
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
        graficos.drawImage(PlanoDeFundo, 1, 1, null);
        
        if(status_jogo)
        {
        	
        
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
        
        g.dispose();
        
        }
    }
    


    @Override
    public void actionPerformed(ActionEvent e)
    {
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
    	
        	jogador.atualizar_imagem_player();
        	repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        jogador.KeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        jogador.KeyReleased(e);
    }


}