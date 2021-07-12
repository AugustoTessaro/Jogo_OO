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
	
	private Image PlanoDeFundo;
	private Player jogador;
	private Timer delay;
	
	public Construcao_Jogo()
	{
		ImageIcon fundo = new ImageIcon("imagem\\"
				+ "fundo.jpg");
		PlanoDeFundo = fundo.getImage();
		
		jogador = new Player();
		jogador.esteticaPlayer();
		
		addKeyListener(new TecladoAdapter());
		
		delay = new Timer(5,this);
		delay.start();
	}

	public void paint(Graphics g)
	{
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(PlanoDeFundo, 1, 1, null);
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
		public void KeyPressed(KeyEvent e) 
		{
			
			jogador.KeyPressed(e);
		}

		public void KeyReleased(KeyEvent e) 
		{
			
			jogador.KeyReleased(e);
		}
	}

}
