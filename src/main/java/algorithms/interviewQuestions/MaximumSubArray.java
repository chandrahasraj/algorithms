package algorithms.interviewQuestions;

public class MaximumSubArray {

	public static void main(String[] args) {
		int ar[]={-2,1,-3,4,-1,2,1,-5,4};
		
		int m=max_sub_array(ar);
		System.out.println(m);
	}

	private static int max_sub_array(int[] A) {
		int newsum=A[0];
	       int max=A[0];
	       for(int i=1;i<A.length;i++){
	           newsum=Math.max(newsum+A[i],A[i]);
	           max= Math.max(max, newsum);
	       }
	       return max;
	}

}
