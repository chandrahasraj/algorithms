package algorithms.datastructures;

public class PermutationsOfAString {
	
	public static void main(String s[]){
		permutation("abc");
	}

	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++){
	        	System.out.println("current prefix = "+(prefix + str.charAt(i))+" , current string = "+(str.substring(0, i) + str.substring(i+1, n)));
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}
}
