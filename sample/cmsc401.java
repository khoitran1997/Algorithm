/**
 * Khoi Tran
 * CMSC 401
 * Professor Bulut
 * Assignment 4
 */

import java.util.Scanner;
import java.util.Arrays;

public class cmsc401 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int perimeter = input.nextInt();
        int sliceNum = input.nextInt();
        //After taking in the array we need two more spaces for 0 and the perimeter
        int changeVal = sliceNum + 2;
        int[] cut = new int[changeVal];
        //put 0 at the beginning of the array
        cut[0] = 0;
        for (int i = 1; i <= sliceNum; i++){
            cut[i] = input.nextInt();
        }
        //Put the perimeter value at the end of the array
        cut[cut.length - 1] = perimeter;
        //I'm just trying to print out the matrix for this
        //System.out.println(Arrays.toString(cut));

        System.out.println(MatrixMulti(cut, changeVal));
    }

    public static int MatrixMulti(int[] p, int n){
        int m[][] = new int[n][n];

        int row, col, k, l, q;

        //This for loop is just filling the matrix with 0
        for (row = 1; row < n; row++){
            m[row][row] = 0;
        }

        //l is the length of chain
        for (l = 2; l < n; l++){
            for (row = 0; row < n - l + 1; row++){
                col = row + l;
                //This is to prevent index out of bound
                if (col == n)
                    continue;
                m[row][col] = Integer.MAX_VALUE;
                //Go through the matrix to calculate the cost for each block
                for (k = row; k < col - 1; k++){
                    q = m[row][k + 1] + m[k + 1][col] + p[col]-p[row];
                    if (q < m[row][col])
                        m[row][col] = q;
                }
            }
        }
        return m[0][n-1];
    }

}