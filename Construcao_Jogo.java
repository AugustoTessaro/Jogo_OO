package Jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Construcao_Jogo extends JPanel implements ActionListener
{
	private Player jogador;
	private Timer delay;
	
	public Construcao_Jogo()
	{
		jogador = new Player();
		jogador.esteticaPlayer();
		
		addKeyListener(new TecladoAdapter());
		
		delay = new Timer(5,this);
		delay.start();
	}

	public void desenhar(Graphics g)
	{
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(jogador.getImagem_nave(), jogador.getX(), jogador.getY(),this);
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
