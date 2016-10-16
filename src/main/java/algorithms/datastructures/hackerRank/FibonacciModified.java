package algorithms.datastructures.hackerRank;

import java.util.Scanner;

public class FibonacciModified {

	static double storage[];
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String values[]=in.nextLine().split(" ");
		int a=Integer.parseInt(values[0]),b=Integer.parseInt(values[1]),n=Integer.parseInt(values[2]);
		storage=new double[n];
		double term=recursieFibonacciModified(a,b,n-1);
		System.out.println(term);
		in.close();
	}

	private static double recursieFibonacciModified(int a, int b, int n) {
		if(storage[n]!=0)
			return storage[n];
		if(n==0)
			return a;
		else if(n==1)
			return b;
		else{
			storage[n-1]=recursieFibonacciModified(a, b, n-1);
			storage[n-2]=recursieFibonacciModified(a, b, n-2);
			storage[n]=storage[n-1]*storage[n-1]+storage[n-2];
			return storage[n];
		}
	}

}
