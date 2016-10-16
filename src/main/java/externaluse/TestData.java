package externaluse;

import java.util.Arrays;

public class TestData {
	public static void main(String[] args) throws Exception {
		char a[] = new char[]{'B','_','R','R','B','R'};
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	  }
}
