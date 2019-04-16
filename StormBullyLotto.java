package lemonadeStand;

import java.awt.Color;
import java.util.Random;

/**
 * runs the storm, bully, or lotto.
 * 
 * @author Cory Britton
 *
 */
@SuppressWarnings({ "serial", "unused" })
public class StormBullyLotto extends DemoLemonadeStand {

	private static double helpRate = 0.7;

	/**
	 * decides if you get to experience the storm, bully, or lotto.
	 * 
	 * @param money
	 * @param chance
	 * @return
	 */
	public static int stormOrBully(int money, int chance) {
		Random rand = new Random();
		int num = rand.nextInt(chance) + 1;

		if (num <= chanceOfStorm * chance) {
			incrementDay();
			imagePanel.setStorm(true);
			Thread thread3 = new Thread() {
				public void run() {
					Music.storm();
				}
			};
			thread3.start();
			money = storm(money);
			if (money == 0) {
				DemoLemonadeStand.txtrOutputTextPanel.setText("You Lost all of Your Money in the Storm!!");
				imagePanel.setLoser(true);
				Music.youLose();
			}

		} else if ((num >= (minChanceOfLotto * chance)) && (num <= (maxChanceOfLotto * chance))) {
			parentPanel.removeAll();
			parentPanel.add(likeToPlayLottoPanel);
			parentPanel.repaint();
			parentPanel.revalidate();
//	       money = Lottery.lottery(money);

		} else if ((num >= (minChanceOfBully * chance)) && (num <= (maxChanceOfBully * chance))) {
			incrementDay();
			money = Bully.bully(money);
			imagePanel.setBully(true);
			Thread thread3 = new Thread() {
				public void run() {
					Music.bully();
				}
			};
			thread3.start();
		}
		return money;
	}

	/**
	 * Increments the day.
	 */
	private static void incrementDay() {
		int dayCount = getDay();
		setDay(++dayCount);
		dayInt.setText(String.valueOf(dayCount));
		cupsBeingMade.setText("");
	}

	/**
	 * Returns how much money you lost in the storm.
	 * 
	 * @param money
	 * @return
	 */
	public static int storm(int money) {
		int newMoney = (int) (money * helpRate);
		int loss = money - newMoney;
		DemoLemonadeStand.txtrOutputTextPanel.setText("You Lost " + loss + " dollars due to the storm today.");
		return newMoney;
	}
	
	public static void setUmbrellaHelpRate(int level) {
		switch (level) {
			case 1:
				helpRate = 0.75;
				break;
			case 2:
				helpRate = 0.79;
				break;
			case 3:
				helpRate = 0.83;
				break;
			case 4:
				helpRate = 0.87;
				break;
			case 5:
				helpRate = 0.92;
				break;
			default:
				helpRate = 0.70;
		}
	}

	public static double getHelpRate() {
		return helpRate;
	}
	
}
