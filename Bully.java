package lemonadeStand;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Decides what a bully will do when he shows up.
 * 
 * @author Cory Britton
 *
 */
@SuppressWarnings("unused")
public class Bully {

	/**
	 * Randomly selects what bully shows up.
	 * 
	 * @param money
	 * @return
	 */
	public static int bully(int money) {
		int takenMoney = 0;
		int totalMoney = 0;
		Random rand = new Random();
		int random = rand.nextInt(5);
		String whatHappened = null;

		switch (random) {
		case 0:
			whatHappened = "twisted your arm";
			takenMoney = (int) (money * .50);
			totalMoney = money - takenMoney;
			ImagePanel.setBullyIndex(0);
			break;

		case 1:
			whatHappened = "pulled your hair";
			takenMoney = (int) (money * .30);
			totalMoney = money - takenMoney;
			ImagePanel.setBullyIndex(1);
			break;

		case 2:
			whatHappened = "gave you a wedgie";
			takenMoney = (int) (money * .70);
			totalMoney = money - takenMoney;
			ImagePanel.setBullyIndex(2);
			break;

		case 3:
			whatHappened = "tied your shoes together";
			takenMoney = (int) (money * .20);
			totalMoney = money - takenMoney;
			ImagePanel.setBullyIndex(3);
			break;

		default:
			whatHappened = "luckly kept walking by";
			totalMoney = money;
			ImagePanel.setBullyIndex(4);
		}
		DemoLemonadeStand.txtrOutputTextPanel
				.setText("A bully shows up and " + whatHappened + "\nHe took $" + takenMoney + ".");

		return totalMoney;
	}
}
