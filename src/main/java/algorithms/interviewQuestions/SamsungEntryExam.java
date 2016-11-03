package algorithms.interviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SamsungEntryExam {

	public static void main(String[] args) {
		Comparator<Integer> cmp = new Comparator<Integer>(){

			public int compare(Integer arg0, Integer arg1) {
				return arg0.compareTo(arg1);
			}};
			List<Integer> list = new ArrayList<>();
			list.add(6);
			list.add(3);
			list.add(7);
			list.add(2);
			Collections.sort(list,cmp);
			System.out.println(list);
	}

}
