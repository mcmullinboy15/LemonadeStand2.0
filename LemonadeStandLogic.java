package lemonadeStand;

import java.util.Random;

/**
 * This is the logic behind the Lemonade stand.
 * 
 * @author Cory Britton
 *
 */
@SuppressWarnings("serial")
public class LemonadeStandLogic extends DemoLemonadeStand {

	private static int treeHuggers;

	/**
	 * Checks to see if you can afford to make the requested cups.
	 * 
	 * @param cupsMade
	 * @param money
	 * @return
	 */
	public static boolean canAffordRequestedCups(int cupsMade, int money) {
		while (cupsMade > money) {
			return false;
		}
		return true;
	}

	/**
	 * Generates a random amount of people.
	 * 
	 * @param day
	 * @return
	 */
	public static int randomPeople(int day) {
		Random rand = new Random();
		int randomNum = day + 11;
		int rdmPeople = rand.nextInt(randomNum);
		return rdmPeople;
	}

	/**
	 * Returns the number of cups sold.
	 * 
	 * @param cupsMade
	 * @param randomPeople
	 * @return
	 */
	public static int cupsSold(int cupsMade, int randomPeople) {
		int cupsSold = 0;
		// cups made vs cups sold
		if (cupsMade < randomPeople) {
			cupsSold = cupsMade;
		}
		if (cupsMade >= randomPeople) {
			cupsSold = randomPeople;
		}
		return cupsSold;
	}

	/**
	 * Returns the total money after adding how many cups you sold.
	 * 
	 * @param cupsSold
	 * @param currentMoney
	 * @return
	 */
	public static int currentMoney(int cupsSold, int currentMoney) {
		int totalMoney = currentMoney + (cupsSold * 2);
		return totalMoney;
	}

	/**
	 * Returns the amount of money you have left after deducting for the people that
	 * you cold not supply to.
	 * 
	 * @param peopleShowed
	 * @param cupsMade
	 * @param money
	 * @return
	 */
	public static int cantSupply(int randomPeople, int cupsMade, int money) {
		int deducted = 0;
//		int iDontCare = (randomPeople - StorePanel.getTreeCap());
//		if (randomPeople > cupsMade) {
//			if (iDontCare > 0)
//				deducted = money - ((iDontCare) - cupsMade);
		int capacity = (StorePanel.getTreeCap());
		int extraPeople = (randomPeople - cupsMade);
		if (randomPeople > cupsMade) {
			if (extraPeople > capacity)
				deducted = money - (extraPeople - capacity);
			else
				deducted = money;
		} else
			deducted = money;

		if (deducted < 0) {
			return 0;
		}

		return deducted;
	}

	public static int getTreeHuggers() {
		return treeHuggers;
	}

	public static void setTreeHuggers(int treeHuggers) {
		LemonadeStandLogic.treeHuggers = treeHuggers;
	}
}
