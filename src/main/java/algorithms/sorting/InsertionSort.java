package algorithms.sorting;

/**
 * 
 * @author chand
 *
 *Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands
 */
public class InsertionSort {
	
	int[] insertionSort(int[] array){
		for(int i=0;i<array.length;i++){
			int j = i-1;
			int temp = array[i];
			while(j >0 && array[j] < array[i] ){
				array[j] = array[i];
				j--;
			}
			array[j+1] = temp;
		}
		return array;
	}

}
