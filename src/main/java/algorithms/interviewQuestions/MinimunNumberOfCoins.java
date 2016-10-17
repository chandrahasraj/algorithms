package algorithms.interviewQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class MinimunNumberOfCoins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to get the change!");
		int number = sc.nextInt();
		int minimumArray[] = new int[number + 1];
		int denominations[] = new int[] { 1, 2, 5 };
		Arrays.sort(denominations);

		MinimunNumberOfCoins mc = new MinimunNumberOfCoins();
		mc.minimumNumberOfCoins(number, denominations, minimumArray);

		for (int i = 1; i <= number; i++) {
			minimumArray = mc.minimumNumberOfCoins(i, denominations, minimumArray);
			// System.out.println(minimumArray[i]);
		}
		System.out.println("Minimum number of coins for making " + number + " = " + minimumArray[number]);
		int noOfCoins = minimumArray[number];
		mc.displayDenominationRanges(noOfCoins, denominations, number);
		sc.close();
	}

	void displayDenominationRanges(int noOfCoins, int[] denominations, int number) {
		int i = 0;
		StringBuilder builder = new StringBuilder();
		builder.append("Number ").append(number).append(" is formed as --> ");
		for (i = denominations.length - 1; i >= 0; i--) {
			if (number >= denominations[i])
				break;
		}
		while (noOfCoins != 0) {
			int divisor = number / denominations[i];
			noOfCoins -= divisor;
			number = number % denominations[i];
			if (divisor != 0)
				builder.append(denominations[i]).append(" * ").append(divisor);
			i--;
			if (number != 0)
				builder.append(" + ");
		}
		System.out.println(builder.toString());
	}

	/**
	 * number of coins for change p C(p) = min{C(p-vi)} for all i
	 * 
	 * where vi is the available denomination
	 * 
	 * @param number
	 * @return
	 */
	int[] minimumNumberOfCoins(int number, int[] denominations, int[] minimumArray) {
		int min = number;
		for (int i = 0; i < denominations.length; i++) {
			int change = number - denominations[i];
			if (change >= 0) {
				min = Math.min(min, minimumArray[change]);
			} else
				break;
		}
		minimumArray[number] = min + 1;
		return minimumArray;
	}
}
