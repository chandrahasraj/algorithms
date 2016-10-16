package algorithms.datastructures;
import java.util.Scanner;
 
public class MatrixMultiplication
{
    public static void main(String args[])
    {
    	System.out.println("Welcome to the matrix multiplier program");
        int n;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the base of squared matrices");
        n = keyboard.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] c = new int[n][n];
        //whatever the base is (n), each line must match that amount else it will not multiply correctly
        //must separate each number by a space
        System.out.println("Please enter the elements of first matrix (rows)");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("Please enter the elements of second martix (rows)");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                b[i][j] = keyboard.nextInt();
            }
        }
        
        //multiplying the matrices
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }

        //prints out the final products
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        keyboard.close();
        System.out.println("DONE!");    }
}