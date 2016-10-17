package algorithms.interviewQuestions;

import java.util.Scanner;

public class DetectIfNumber {
	final static String numberRegex = "^([\\+-]?[0-9]+)((\\.)?[0-9]+((e([\\+-])?[0-9]+)?))?";

	public static void main(String as[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		String number = sc.nextLine();
		if (isNumber(number))
			System.out.println("It is a valid number");
		else
			System.out.println("Not a valid Number");
		sc.close();
	}

	static boolean isNumber(String number) {
		if (number.matches(numberRegex))
			return true;
		else
			return false;
	}
}
