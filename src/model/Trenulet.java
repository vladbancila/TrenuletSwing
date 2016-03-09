package model;

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import view.Panza;

public class Trenulet extends Thread {

	public int getPozitieY() {
		return pozitieY;
	}

	private int pozitie = 10;
	private int pozitieY;

	// Panza am initializat-o din GUI
	// Cand se ceraza obiectele Trenulet, panza e null
	// Nu vom da drumul la Threaduri decat dupa ce GUI-ul a fost creat
	// si implicit variabila panza din aceasta clasa a fost initializata.
	// pt ca altfel vom avea NullPointerException pe linia
	// Graphics gr = panza.getGraphics();
	// panza.stergeDesenul(gr);
	// panza.paint(gr);

	public Trenulet(int y) {
		this.pozitieY = y;
	}

	public int getPozitie() {
		return pozitie;
	}

	@Override
	public void run() {

		seDeplaseaza();
		intraInGara();

	}

	public void seDeplaseaza() {
		int viteza = ThreadLocalRandom.current().nextInt(1, 8);
		// similar cu = (int)(Math.random(7)+1);
		Graphics gr = Principala.gui.panza.getGraphics();

		while (pozitie <= 350) {

			try {

				Thread.sleep(200); // doarme 1/2 secunde

				pozitie += viteza * 2;

				Principala.gui.panza.stergeDesenul(gr);

				Principala.gui.panza.paint(gr);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		} // end while
	}

	public void intraInGara() {

		synchronized (Gara.class) {
			Principala.gui.panza.seteazaSemafor(false);
			pozitie = 500;
			pozitieY = 210;
			Graphics gr = Principala.gui.panza.getGraphics();

			Principala.gui.panza.stergeDesenul(gr);

			Principala.gui.panza.paint(gr);

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (pozitie <= 1000) {

				try {

					Thread.sleep(200); // doarme 1/2 secunde

					pozitie += 15;

					Principala.gui.panza.stergeDesenul(gr);

					Principala.gui.panza.paint(gr);

				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
			
			Principala.gui.panza.seteazaSemafor(true);
			Principala.gui.panza.stergeDesenul(gr);

			Principala.gui.panza.paint(gr);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
