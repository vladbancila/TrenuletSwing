package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Principala;

public class Panza extends JPanel {

	

	private boolean flag = true;

	public Panza() {

		this.setSize(800, 600);
	}

	@Override
	public void paint(Graphics g)
	{
		// Sine trenulete pana la gara
		for (int i = 0; i < 5; i++) 
		{
			g.setColor(Color.black);
			g.drawLine(15, 15 + i * 100, 460, 15 + i * 100);

			g.setColor(Color.black);
			g.drawLine(15, 55 + i * 100, 460, 55 + i * 100);
		}
		// Sine gara
		g.setColor(Color.black);
		g.drawLine(15, 215, 1200, 215);

		g.setColor(Color.black);
		g.drawLine(15, 255, 1200, 255);

		// Gara
		g.setColor(Color.GREEN);
		g.fillRect(540, 140, 60, 60);
		g.setColor(Color.black);
		g.drawString("G A R A", 550, 160);
		
		// Semafosr
		// g.setColor(color);
		g.drawRect(500, 150, 20, 30);
		if (flag)
		{
			g.setColor(Color.GREEN);
			g.fillOval(500, 150, 20, 20);
		}
		else 
		{
			g.setColor(Color.RED);
			g.fillOval(500, 160, 20, 20);
		}

		// Desen Trenulete
		g.setColor(Color.GREEN);
		g.fillRect(Principala.trenulete[0].getPozitieX(), Principala.trenulete[0].getPozitieY(), 100, 50);

		g.setColor(Color.YELLOW);
		g.fillRect(Principala.trenulete[1].getPozitieX(), Principala.trenulete[1].getPozitieY(), 100, 50);

		g.setColor(Color.RED);
		g.fillRect(Principala.trenulete[2].getPozitieX(), Principala.trenulete[2].getPozitieY(), 100, 50);

		g.setColor(Color.BLUE);
		g.fillRect(Principala.trenulete[3].getPozitieX(), Principala.trenulete[3].getPozitieY(), 100, 50);

		g.setColor(Color.MAGENTA);
		g.fillRect(Principala.trenulete[4].getPozitieX(), Principala.trenulete[4].getPozitieY(), 100, 50);

	}

	public void stergeDesenul(Graphics gr) {
		super.paint(gr);
	}
	public void seteazaSemafor(boolean flag) {
		this.flag = flag;
	}
}
