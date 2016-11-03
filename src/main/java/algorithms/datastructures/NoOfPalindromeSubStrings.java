package algorithms.datastructures;

import java.util.Set;
import java.util.TreeSet;

public class NoOfPalindromeSubStrings{
	public static void main(String args[]) {
		int val = palindrome("malayalam");
		System.out.println(val);
	}
	
	static int palindrome(String s){
		 int i,j,k;
		 Set<String> list = new TreeSet<>();
	        char[] str = s.toCharArray();
	        for(i=0;i<str.length;i++){
	        	String val = s.substring(i,i+1);
	        	list.add(val);
	        	System.out.println(val);
	        }
		for(i=0;i<str.length;i++)
		{
			k=i-1;j=i+1;  //count odd length palindromes
			while(k>=0 && j<str.length && str[k]==str[j])
			{
				System.out.println(s.substring(k,j+1));
				list.add(s.substring(k,j+1));
				k--;j++;
			}

			k=i;j=i+1; //count even length palindrome
			while(k>=0 && j<str.length && str[k]==str[j])
			{
				System.out.println(s.substring(k,j+1));
				list.add(s.substring(k,j+1));
				k--;j++;
			}
		}
		return list.size();
	}
}