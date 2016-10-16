package algorithms.datastructures;

import java.util.Arrays;

public class SubractTwoStrings {

	public static void main(String[] args) {
		String s1="10000000000",s2="999999999";
		int[] final_array;
		int max=get_greater_of_both_strings(s1.toCharArray(),s2.toCharArray());
		
		if(max==1){
			final_array=new int[s1.length()];
			subtract_s1_from_s2(s1,s2,final_array);
		}else{
			final_array=new int[s2.length()];
			subtract_s1_from_s2(s2,s1,final_array);
		}
		System.out.println(Arrays.toString(final_array));
		
	}

	private static void subtract_s1_from_s2(String s1, String s2,int[] final_array) {
		char a1[]= s1.toCharArray();
		char a2[]= s2.toCharArray();
		int i,j;
		
		for(i =a1.length-1,j=a2.length-1;i>=0 && j>=0;i--,j--){
			int v1 = a1[i] - '0';
			int v2 = a2[j] - '0';
			if(v1<v2){
				v1=v1+10;
				a1=reduce_remaining_elements(a1,i-1);
			}
			System.out.println(Arrays.toString(a1));
			final_array[i]=v1-v2;
		}
		if(i!=0){
			for(;i>=0;i--)
				final_array[i]=a1[i] - '0';
		}
	}

	private static char[] reduce_remaining_elements(char[] a1, int i) {
		for(int j=i;j>=0;j--){
			int v = a1[j]-'0';
			if(v!=0){
				a1[j] = (char) (v-1);
				break;
			}else{
				a1[j] = (char) (9);
			}
		}
		return a1;
	}

	private static int get_greater_of_both_strings(char[] a1, char[] a2) {
		if(a1.length<a2.length)
			return 2;
		else if(a1.length>a2.length)
			return 1;
		else{
			for(int i=0;i<a1.length;i++){
				int v1 = a1[i] - '0';
				int v2 = a2[i] - '0';
				
				if(v1>v2)
					return 1;
				else if(v1<v2)
					return 2;
			}
		}
		
		return 0;
	}

}
