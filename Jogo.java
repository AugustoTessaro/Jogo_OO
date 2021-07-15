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


public class Jogo extends JPanel implements ActionListener, KeyListener  
/*
 * A classe Jogo herda de JPanel para fazer uso dos metodos e atributos da classe JPnael possibiliando fazer a adicao ao Jframe Tela.
 * As interfaces implemnetadas sao usadas para capturar os clicks no teclado e realizar determinadas acoes.
 */
{
	private Image planoDeFundo;
    private Image imagemGameOver;
    private Player jogador;
    private Timer timer;
    private boolean statusJogo;  // variavel que define se o jogo esta rodando ou nao.
    private List<Asteroide> asteroides;
 
    public Jogo()
    {
        ImageIcon iconePlanoDeFundo = new ImageIcon("imagem\\planodefundo.jpg"); 
        planoDeFundo = iconePlanoDeFundo.getImage();

        jogador = new Player();
        gerarAsteroides();
        // a classe jogo agrega as classes jogador e asteroide.
        
        setFocusable(true); // define o foco de todas as acoes para o JPanel criado
        addKeyListener(this);
        statusJogo = true;

        timer = new Timer(3,this); // criacao do objeto timer com um delay de 3 milisegundos e com o listener sendo a propria classe que implementa o ActionListener
        timer.start();
    }

    public void gerarAsteroides()
    {
    	this.asteroides = new ArrayList<Asteroide>();
    	
    	for (int i = 0; i < 100 ; i++) 
    	{
    		int x = (int)(Math.random() * 8000+1920); // gera valores entre 1920 e 9920, porque o objetivo e criar asteroides fora da visibilidade do usuario
    		int y = (int)(Math.random() * 1030);      // gera valores entre 0 e 1030, porque o objetivo e criar asteroides dentro dos limites de altura da tela
    		asteroides.add(new Asteroide(x,y));       
		}
    }
    
    
    public void paint(Graphics g)   
    {
        Graphics2D graficos = (Graphics2D) g; // conversao do objeto g do tipo graphics para um objeto graficos do tipo graphics2d
        
        if(statusJogo == true)	
        {
	        graficos.drawImage(planoDeFundo, 1, 1, this);
	        graficos.drawImage(jogador.getImagem(), jogador.getX(), jogador.getY(),this);
	        
	        List<Projetil> projeteis = jogador.getProjeteis();
        
	        for(int a = 0; a < projeteis.size(); a++)
	        {
	        	Projetil p = projeteis.get(a);
	        	graficos.drawImage(p.getImagem(), p.getX(), p.getY(), this);
	        }
        
	        for (int e = 0; e < asteroides.size(); e ++)
	        {
	        	Asteroide objAsteroide = asteroides.get(e);
	        	graficos.drawImage(objAsteroide.getImagem(), objAsteroide.getX(), objAsteroide.getY(), this);
	        }
        }
        
        else
        {
        	ImageIcon iconeImagemGameOver = new ImageIcon("imagem\\gameover.jpg"); 
            imagemGameOver = iconeImagemGameOver.getImage();
        	graficos.drawImage(imagemGameOver , 0, 0, this);
        	timer.stop();
        } 
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	
    	jogador.atualizarImagemPlayer();
    	
    	List<Projetil> projeteis = jogador.getProjeteis();
    	
	    	for(int a = 0; a < projeteis.size(); a++)
	    	{
	    		Projetil p = projeteis.get(a);
	    		
	    		if(p.isVisibilidade())
		    		{
		    			p.movimentarTiro();
		    		}
	    		
		    		else
		    		{
		    			projeteis.remove(a);
		    		}
	    	}
	    	
	    	for (int i = 0; i < asteroides.size(); i++) 
	    	{
	    		Asteroide at = asteroides.get(i);
	    		if(at.isVisibilidade())
		    		{
		    			at.movimentarAsteroide();
		    			
		    		}
		    		else
		    		{
		    			asteroides.remove(i);
		    		}
			}
	    	
    	checaColisoesPlayer();
    	checaColisoesProjetilAsteroide();
        repaint();
    }
   
    public void checaColisoesPlayer()                                 
    {
    	Rectangle retanguloNave = jogador.getBounds();
    	Rectangle retanguloAsteroide;
    	
    	
    	for (int i = 0; i < asteroides.size(); i++) 
    	{
    		Asteroide asteroide = asteroides.get(i);
    		retanguloAsteroide = asteroide.getBounds();
    		
    		if(retanguloNave.intersects(retanguloAsteroide))
    		{
    			jogador.setVisibilidade(false);
    			asteroide.setVisibilidade(false);
    			statusJogo = false;
    		
    		}	
		}
    	
     }
     
    public void checaColisoesProjetilAsteroide()
    {
    	Rectangle retanguloAsteroide;
    	Rectangle retanguloProjetil;
    	
    	List<Projetil> projeteis = jogador.getProjeteis();
    	for (int i = 0; i < projeteis.size(); i++) 
    	{
    		Projetil projetil = projeteis.get(i);
    		retanguloProjetil = projetil.getBounds();
    		
    		for (int j = 0; j < asteroides.size(); j++) 
    		{
    			Asteroide asteroide = asteroides.get(j);
        		retanguloAsteroide = asteroide.getBounds();
        		
        		if(retanguloProjetil.intersects(retanguloAsteroide))
        		{
        			projetil.setVisibilidade(false);
        			asteroide.setVisibilidade(false);
        		}
			}
		}
    }

    @Override
    public void keyTyped(KeyEvent e) { 
 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        jogador.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        jogador.keyReleased(e);
    }


}