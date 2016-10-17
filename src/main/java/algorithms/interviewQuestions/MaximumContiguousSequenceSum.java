package algorithms.interviewQuestions;

import java.util.Scanner;

public class MaximumContiguousSequenceSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter comma separated integer values!");
		String line = sc.nextLine();
		String lines[] = line.split(",");
		int values[] = new int[lines.length];
		for (int i = 0; i < lines.length; i++) {
			values[i] = Integer.parseInt(lines[i]);
		}
		MaximumContiguousSequenceSum sum = new MaximumContiguousSequenceSum();
		int[] display = sum.getMaximumSequenceSum(values);
		int s = 0;
		System.out.println("maximum sub sequence array");
		for (int i = 0; i < display.length; i++) {
			System.out.print(display[i] + " ");
			s += display[i];
		}
		System.out.println();
		System.out.println("max subsequence sum = " + s);
		sc.close();
	}

	int[] getMaximumSequenceSum(int[] values) {
		int cur_sum = values[0], prev_sum = cur_sum;

		int s_index = 0, e_index = 0;
		for (int i = 1; i < values.length; i++) {
			cur_sum = Math.max(cur_sum + values[i], values[i]);
			if (prev_sum != cur_sum) {
				if (cur_sum == values[i]) {
					s_index = e_index = i;
				} else {
					e_index = i;
				}
				prev_sum = cur_sum;
			} else {
				e_index = i;
			}
		}
		int n_array[] = new int[e_index - s_index + 1];
		for (int i = s_index, j = 0; i <= e_index; i++, j++) {
			n_array[j] = values[i];
		}
		return n_array;
	}
}
