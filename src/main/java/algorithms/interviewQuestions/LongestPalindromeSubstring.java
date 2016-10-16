package algorithms.interviewQuestions;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String s="dabcba";
		
		String ss=longest_palindrome_string(s);
		System.out.println(ss);
	}

	private static String longest_palindrome_string(String s) {
		if(s.length()==1)
			return s;
		String longest_string=s.substring(0,1);
		for(int i=0;i<s.length();i++){
			String temp=loop(s,i,i);
			if(temp.length() > longest_string.length())
				longest_string=temp;
			
			temp=loop(s,i,i+1);
			if(temp.length() > longest_string.length())
				longest_string=temp;
		}
		return longest_string;
		
	}

	private static String loop(String s, int low, int high) {
		while(low>=0 && high<=s.length()-1 && s.charAt(low)==s.charAt(high)){
			low--;
			high++;
		}
		return s.substring(low+1,high);
	}

}
