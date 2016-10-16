package algorithms.interviewQuestions;

import java.util.HashMap;

public class LongestSubstringWithUnique {

	public static void main(String[] args) {
		String s="cdaeaanlaj";
		int m=longest_substring_with_unique_char(s);
		System.out.println(m);
	}

	private static int longest_substring_with_unique_char(String s) {
		int start=0,max=0;
		HashMap<Character,Integer> list=new HashMap<>();
		
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			
			if(list.containsKey(c)){
				max=Math.max(max, list.size());
				while(list.containsKey(c)){
					list.remove(s.charAt(start));
					start++;
				}
			}else{
				list.put(c,i);
			}
		}
		max =Math.max(max, list.size());
		return max;
	}

}
