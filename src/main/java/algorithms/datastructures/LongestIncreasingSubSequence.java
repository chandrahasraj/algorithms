package algorithms.datastructures;

import java.util.Scanner;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input[] = s.nextLine().split(",");
		int ii[] = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			ii[i] = Integer.valueOf(input[i]);
		}
		System.out.println(longestSequence(ii));
		s.close();
	}

	private static int longestSequence(int[] nums) {
		if (nums.length != 0) {
			int seq[] = new int[nums.length];
			seq[0] = 1;
			for (int i = 1; i < nums.length; i++) {
				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i]) {
						int temp = 1 + seq[j];
						if (seq[i] < temp)
							seq[i] = temp;
					} else {
						if (seq[i] == 0)
							seq[i] = 1;
					}

				}
				//System.out.println(i + "-->" + seq[i]);
			}
			int tt = 0;
			for (int i = 0; i < seq.length; i++)
				if (seq[tt] < seq[i]) {
					tt = i;
				}
			return seq[tt];
		} else
			return 0;
	}
}
