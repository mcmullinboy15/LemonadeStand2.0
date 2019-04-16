package lemonadeStand;

import java.util.Random;
import java.util.Arrays;

@SuppressWarnings({ "unused", "serial" })
public class Lottery extends DemoLemonadeStand {
	private static int matchCheck;
	private static int percent;
	private static int finalAccountBal;

	private static int moneyWon;

	public static int getMoneyWon() {
		return moneyWon;
	}

	public static int getMatchCheck() {
		return matchCheck;
	}

	public static int getPercent() {
		return percent;
	}

	public static int getFinalAccountBal() {
		return finalAccountBal;
	}

	public static int lottery(int currentMoney, int[] userNumbers, int wageredMoney) {

		int[] random = randomNumbers();

		finalAccountBal = currentMoney;

		// Caluculates how much money you have after wagering
		currentMoney = currentMoney - wageredMoney;
		matchCheck = compareNumbers(random, userNumbers);
		percent = howMuchMoneyWon(matchCheck);
		moneyWon = (wageredMoney * percent);
		finalAccountBal = (wageredMoney * percent) + currentMoney;

		return finalAccountBal;
	}

	public static int[] randomNumbers() {
		Random rand = new Random();
		int[] lottoArray = new int[5];
		for (int i = 0; i < lottoArray.length; i++) {
			lottoArray[i] = rand.nextInt(20) + 1;
		}
		return lottoArray;
	}

	public static int compareNumbers(int[] lottoArray, int[] userArray) {
		int matchCheck = 0;
		for (int i = 0; i < lottoArray.length; i++) {
			for (int j = 0; j < lottoArray.length; j++) {
				if (lottoArray[i] == userArray[j]) {
					matchCheck++;
				}
			}
		}
		if (matchCheck > 5) {
			matchCheck = 5;
		}
		return matchCheck;
	}

	public static int howMuchMoneyWon(int numMatches) {
		int percent = 0;
		switch (numMatches) {
		case 0:
			break;
		case 1:
			percent = 1;
			break;
		case 2:
			percent = 2;
			break;
		case 3:
			percent = 3;
			break;
		case 4:
			percent = 5;
			break;
		case 5:
			percent = 10;
			break;
		}
		return percent;
	}

}