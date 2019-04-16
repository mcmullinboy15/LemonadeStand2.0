package lemonadeStand;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * Creates the graphics for the image panel.
 * 
 * @author Cory Britton
 *
 */
@SuppressWarnings({ "serial", "unused" })
public class ImagePanel extends JPanel {
	private boolean loser = false;
	private boolean winner = false;
	private boolean storm = false;
	private boolean bully = false;
	private String[] kids = { "bobs1", "Rick", "Sonic", "Morty", "homerRight", "trollface", };
	private int kidIndex;
	private String[] bullys = { "Bully3", "Bully1", "BullyWedgie", "Bully2", "Bully" };
	private static int bullyIndex;

	/**
	 * Sets the bully index.
	 * 
	 * @param index
	 */
	public static void setBullyIndex(int index) {
		bullyIndex = index;
	}

	public ImagePanel() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (storm) {
			createLemonadeStand(g);
			createStormBackground(g);
		} else if (bully) {
			normalDay(g);
			createBully(g);
		} else if (loser) {
			loserImage(g);
		} else if (winner) {
			winnerImage(g);
		} else {
			normalDay(g);
			createKidLeft(g);
		}

	}

	/**
	 * Creates the lemonade stand with a normal sunny day.
	 * 
	 * @param g
	 */
	private void normalDay(Graphics g) {
		createClouds(g);
		createLemonadeStand(g);
	}

	/**
	 * Cycles through kids.
	 */
	public void changeKid() {
		kidIndex = ++kidIndex % kids.length;
		repaint();
	}

	/**
	 * Checks to see if there is a storm present.
	 * 
	 * @return
	 */
	public boolean isStorm() {
		return storm;
	}

	/**
	 * Creates a storm.
	 * 
	 * @param storm
	 */
	public void setStorm(boolean storm) {
		this.storm = storm;
		repaint();
	}

	/**
	 * Checks to see if there is a bully present.
	 * 
	 * @return
	 */
	public boolean isBully() {
		return bully;
	}

	/**
	 * Creates a bully.
	 * 
	 * @param bully
	 */
	public void setBully(boolean bully) {
		this.bully = bully;
		repaint();
	}

	/**
	 * Checks to see if you lost.
	 * 
	 * @param loser
	 */
	public void setLoser(boolean loser) {
		this.loser = loser;
		repaint();
		Thread thread3 = new Thread() {
			public void run() {
				Music.youLose();
			}
		};
		thread3.start();
	}

	/**
	 * Checks to see if you won.
	 * 
	 * @param winner
	 */
	public void setWinner(boolean winner) {
		this.winner = winner;
		repaint();
		Thread thread3 = new Thread() {
			public void run() {
				Music.playWinner();
			}
		};
		thread3.start();
	}

	/**
	 * Creates a bully.
	 * 
	 * @param g
	 */
	private void createBully(Graphics g) {
		createImage(g, "/lemonadeStand/Images/" + bullys[bullyIndex] + ".png", 80, 250);
	}

	/**
	 * Creates a storm.
	 * 
	 * @param g
	 */
	private void createStormBackground(Graphics g) {
		setBackground(new Color(51, 51, 51));
		createImage(g, "/lemonadeStand/Images/stormLeft.png", 100, 20);
		createImage(g, "/lemonadeStand/Images/stormRight.png", 600, 20);
		createImage(g, "/lemonadeStand/Images/puddle.png", 20, 350);
		createImage(g, "/lemonadeStand/Images/puddle1.png", 100, 400);
		createImage(g, "/lemonadeStand/Images/puddle2.png", 600, 400);
		createImage(g, "/lemonadeStand/Images/rain.gif", 0, 0);
		createImage(g, "/lemonadeStand/Images/rain.gif", 0, 300);
		createImage(g, "/lemonadeStand/Images/rain.gif", 400, 300);
		createImage(g, "/lemonadeStand/Images/rain.gif", 400, 0);
		createImage(g, "/lemonadeStand/Images/rain.gif", 800, 300);
		createImage(g, "/lemonadeStand/Images/rain.gif", 800, 0);
	}

	/**
	 * Creates the Lemonade stand.
	 * 
	 * @param g
	 */
	private void createLemonadeStand(Graphics g) {
		createImage(g, "/lemonadeStand/Images/backdrop.png", 0, 0);
		createImage(g, "/lemonadeStand/Images/Sidewalk.png", 0, 500);
		createImage(g, "/lemonadeStand/Images/LemonadeStand.png", 300, 20);
	}

	/**
	 * Creates a sunny day.
	 * 
	 * @param g
	 */
	private void createClouds(Graphics g) {
		createImage(g, "/lemonadeStand/Images/Sun.gif", 540, 0);
		createImage(g, "/lemonadeStand/Images/Cloud1.png", 350, 0);
		createImage(g, "/lemonadeStand/Images/Cloud2.png", 700, 0);
		createImage(g, "/lemonadeStand/Images/Cloud3.png", 0, 0);
	}

	/**
	 * Creates a customer.
	 * 
	 * @param g
	 */
	private void createKidLeft(Graphics g) {
		createImage(g, "/lemonadeStand/Images/" + kids[kidIndex] + ".gif", 50, 210);
	}

	/**
	 * Creates the loser image.
	 * 
	 * @param g
	 */
	private void loserImage(Graphics g) {
		createImage(g, "/lemonadeStand/Images/Loser.jpg", 0, 0);
	}

	/**
	 * Creates the winner image
	 * 
	 * @param g
	 */
	private void winnerImage(Graphics g) {
		setBackground(new Color(255, 255, 255));
		createImage(g, "/lemonadeStand/Images/Winner.gif", 30, 0);
	}

	/**
	 * Creates a graphic.
	 * 
	 * @param g - leave this as Graphics g.
	 * @param s - URL to the image.
	 * @param x - X coordinate.
	 * @param y - Y coordinate.
	 */
	private void createImage(Graphics g, String s, int x, int y) {
		ImageIcon image = new ImageIcon(ImagePanel.class.getResource(s));
		image.paintIcon(this, g, x, y);
	}

}
