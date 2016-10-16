package algorithms.datastructures.hackerRank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchingPattern {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("C:/Users/chand/Desktop/abc.txt"));
		int T, R, C, r, c;
		T = Integer.parseInt(in.nextLine());
		for (int k = 0; k < T; k++) {
			String temp[] = in.nextLine().split(" ");
			R = Integer.parseInt(temp[0].trim());
			C = Integer.parseInt(temp[1].trim());
			String array[] = new String[R];
			for (int i = 0; i < R; i++) {
				array[i] = in.nextLine();
			}
			String temp3[] = in.nextLine().split(" ");
			r = Integer.parseInt(temp3[0].trim());
			c = Integer.parseInt(temp3[1].trim());
			String searchArray[] = new String[r];
			for (int i = 0; i < r; i++) {
				searchArray[i] = in.nextLine();
			}

			int saveArray[] = new int[C];
			int usedArray[] = new int[C];
			int pointer = 0;
			int matchIndex = -1,nextMatch=0;
			boolean beginSteps = false;
			for (int i = 0; i < R; i++) {
				Pattern pattern = Pattern.compile(searchArray[pointer]);
				Matcher matcher = pattern.matcher(array[i]);

				if (matcher.find()) {
					beginSteps = true;
					matchIndex = matcher.start();
					int usedIndex = i * 10 + matcher.start();
					if (usedArray[matchIndex] == usedIndex) {
						nextMatch+=1;
						for(int p=0;p<nextMatch;p++){
							if (!matcher.find()){
								beginSteps = false;
								usedArray=new int[C];
								nextMatch=0;
							}
						}
					}
					if (beginSteps) {
						int incrementedIndex=getIndex(saveArray);
						if (incrementedIndex==-1){
							saveArray[matcher.start()] = 1;
							pointer++;
						}
						else if(incrementedIndex==matcher.start()){
							saveArray[matcher.start()] += 1;
							pointer++;
						}else{
							pointer=0;
							beginSteps=false;
							usedArray[incrementedIndex] = (i - 1) * 10 + incrementedIndex;
							saveArray = new int[C];
							i = i - 2;
						}
					}
				} else if (beginSteps) {
					beginSteps = false;
					usedArray[matchIndex] = (i - 1) * 10 + matchIndex;
					i = i - 2;
					pointer = 0;
					saveArray = new int[C];
				}
				if (pointer == r)
					break;
			}
			boolean found = false;
			for (int j = 0; j < C; j++) {
				if (saveArray[j] == r) {
					System.out.println("YES");
					found = true;
				}
			}
			if (!found)
				System.out.println("NO");
		}
		in.close();
	}

	private static int getIndex(int[] saveArray) {
		for(int i=0;i<saveArray.length;i++)
			if(saveArray[i]!=0)
				return i;
		return -1;
	}

}
