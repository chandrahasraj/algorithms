package algorithms.sorting;

public class HeapSort {
	private static  int theArray[];
	private static int arraySize;
	
	HeapSort(int size){
		arraySize = size;
		theArray = new int[arraySize];
		generateRandomArray();
	}
	public static void main(String as[]){
		HeapSort sort =  new HeapSort(10);
		printHorzArray(0,9);
		for(int i=4;i>=0;i--){
			sort.heapify(i);
			printHorzArray(0,9);
		}
	}
	
	static void printHorzArray(int i, int j) {

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print(String.format("| %2s " + " ", theArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		if (i != -1) {

			// Number of spaces to put before the F

			int spacesBeforeFront = 6 * (i + 1) - 5;

			for (int k = 0; k < spacesBeforeFront; k++)
				System.out.print(" ");

			System.out.print("L" + i);

			// Number of spaces to put before the R

			int spacesBeforeRear = 5 * (j + 1) - spacesBeforeFront;

			for (int l = 0; l < spacesBeforeRear; l++)
				System.out.print(" ");

			System.out.print("R" + j);

			System.out.println("\n");

		}

	}
	
	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			theArray[i] = (int) (Math.random() * 50) + 10;

		}

	}
	
	public void heapify(int index){
		boolean left_changed = false,right_changed=false;
		int largest;
		
		if(index<(theArray.length/2)){
			if(theArray[2*index + 1] < theArray[2*index]){
				largest = 2*index;
				left_changed = true;
				
			}else{
				largest = 2*index+1;
				right_changed = true;
			}
			
			if(theArray[index] < theArray[largest]){
				if(left_changed)
					swapValues(index, 2*index);
				if(right_changed)
					swapValues(index, 2*index+1);
				heapify(largest);
			}
		}
	}
	private void swapValues(int i, int j) {
		int temp = theArray[i];
		theArray[i]=theArray[j];
		theArray[j]=temp;
		
	}
}
