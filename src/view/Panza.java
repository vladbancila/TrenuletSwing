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
	public void paint(Graphics g) {
		for (int i = 0; i < 5; i++) {
			g.setColor(Color.black);
			g.drawLine(15, 15 + i * 100, 500, 15 + i * 100);

			g.setColor(Color.black);
			g.drawLine(15, 55 + i * 100, 500, 55 + i * 100);
		}
		// Sine gara
		g.setColor(Color.black);
		g.drawLine(15, 215, 800, 215);

		g.setColor(Color.black);
		g.drawLine(15, 255, 800, 255);

		g.setColor(Color.GREEN);
		g.fillRect(550, 150, 50, 50);
		g.setColor(Color.black);
		g.drawString("G A R A", 550, 160);
		// Semafosr
		// g.setColor(color);
		g.drawRect(500, 150, 20, 30);
		if (flag) {
			g.setColor(Color.GREEN);
			g.fillOval(500, 150, 20, 20);

		} else {
			g.setColor(Color.RED);
			g.fillOval(500, 160, 20, 20);
		}

		g.setColor(Color.GREEN);
		g.fillRect(Principala.trenulete[0].getPozitie(), Principala.trenulete[0].getPozitieY(), 100, 50);

		g.setColor(Color.YELLOW);
		g.fillRect(Principala.trenulete[1].getPozitie(), Principala.trenulete[1].getPozitieY(), 100, 50);

		g.setColor(Color.RED);
		g.fillRect(Principala.trenulete[2].getPozitie(), Principala.trenulete[2].getPozitieY(), 100, 50);

		g.setColor(Color.BLUE);
		g.fillRect(Principala.trenulete[3].getPozitie(), Principala.trenulete[3].getPozitieY(), 100, 50);

		g.setColor(Color.MAGENTA);
		g.fillRect(Principala.trenulete[4].getPozitie(), Principala.trenulete[4].getPozitieY(), 100, 50);

	}

	public void stergeDesenul(Graphics gr) {
		super.paint(gr);
	}
	public void seteazaSemafor(boolean flag) {
		this.flag = flag;
	}
}
