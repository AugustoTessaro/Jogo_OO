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
        g.dispose();
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
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
