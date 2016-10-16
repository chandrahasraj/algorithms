package algorithms.datastructures.hackerRank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author chand
 *
 *You are given a square map of size n×n. Each cell of the map has a value denoting its depth. We 
 *will call a cell of the map a cavity if and only if this cell is not on the border of the map and 
 *each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).
 *You need to find all the cavities on the map and depict them with the uppercase character X.
 *
 *sample Input
 *4
 *1112
 *1912
 *1892
 *1234
 *
 *sample output
 *1112
 *1X12
 *18X2
 *1234
 *
 */
public class FindingCavities {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("C:/Users/chand/Desktop/test.txt"));
		int sizeOfMatrix=Integer.parseInt(in.nextLine());
		int matrix[][]=new int[sizeOfMatrix][sizeOfMatrix];
		
		for(int i=0;i<sizeOfMatrix;i++){
			String line=in.nextLine();
			for(int j=0;j<sizeOfMatrix;j++){
				matrix[i][j]=Character.getNumericValue(line.charAt(j));
			}
		}
		
		for(int i=1;i<sizeOfMatrix-1;i++){
			for(int j=1;j<sizeOfMatrix-1;j++){
				if(matrix[i][j]>matrix[i-1][j]&&matrix[i][j]>matrix[i][j-1]
						&&matrix[i][j]>matrix[i+1][j]&&matrix[i][j]>matrix[i][j+1]){
					matrix[i][j]=0;
				}
			}
		}
		
		for(int i=0;i<sizeOfMatrix;i++){
			for(int j=0;j<sizeOfMatrix;j++){
				System.out.print(matrix[i][j]==0?"X":matrix[i][j]);
			}
			System.out.println();
		}
		
		in.close();
	}

}
