package Jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Construcao_Jogo extends JPanel implements ActionListener
{
	private Image Plano_De_Fundo;
	private Player jogador;
	private Timer delay;
	
	public Construcao_Jogo()
	{
		ImageIcon fundo = new ImageIcon("imagem/fundo.png");
		Plano_De_Fundo = fundo.getImage();
		
		jogador = new Player();
		jogador.esteticaPlayer();
		
		addKeyListener(new TecladoAdapter());
		
		delay = new Timer(5,this);
		delay.start();
	}

	public void desenhar(Graphics g)
	{
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(Plano_De_Fundo, 0, 0, null);
		graficos.drawImage(jogador.getImagem_nave(), jogador.getX(), jogador.getY(),this);
		g.dispose();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		jogador.atualizar_imagem();
		repaint();
	}
	
	private class TecladoAdapter extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			jogador.KeyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e)
		{
			jogador.KeyReleased(e);
		}
	}

}
