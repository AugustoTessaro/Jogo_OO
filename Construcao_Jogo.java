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
import java.awt.event.KeyListener;
import java.util.List;

public class Construcao_Jogo extends JPanel implements ActionListener, KeyListener
{

    private Image PlanoDeFundo;
    private Player jogador;
    private Timer delay;

    public Construcao_Jogo()
    {
        ImageIcon fundo = new ImageIcon("imagem\\planodefundo.jpg");
        PlanoDeFundo = fundo.getImage();

        jogador = new Player();
        jogador.esteticaPlayer();

        setFocusable(true);
        addKeyListener(this);

        delay = new Timer(2,this);
        delay.start();
    }

    public void paint(Graphics g)
    {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(PlanoDeFundo, 1, 1, null);
        graficos.drawImage(jogador.getImagem_nave(), jogador.getX(), jogador.getY(),this);
        
        List<Projetil> projetil = jogador.getProjetil();
        
        for(int a = 0; a < projetil.size(); a++)
        {
        	Projetil p = projetil.get(a);
        	graficos.drawImage(p.getImagem_tiro(), p.getX(), p.getY(), this);
        }
        
        g.dispose();
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
    	List<Projetil> projetil = jogador.getProjetil();
    	
    	for(int a = 0; a < projetil.size(); a++)
    	{
    		Projetil p = projetil.get(a);
    		
    		if(p.isVisibilidade_tiro())
    		{
    			p.movimentar_tiro();
    		}
    		
    		else
    		{
    			projetil.remove(a);
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
