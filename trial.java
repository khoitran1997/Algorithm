import java.util.Scanner;

/**
 * Khoi Tran
 * CMSC 401
 * Professor Bulut
 * Write a program that prints the sum of two selected numbers from a
 * line
 */

public class trial {
    public static void main(String[] args){
        //This will store the number of lines
        int numberOfLines = 0;

        //A Scanner class to read in the user's input
        //Record in the user's input of number of lines
        Scanner input = new Scanner(System.in);
        numberOfLines = input.nextInt();
        int[] result = new int[numberOfLines];

        //This will create the array for the input
        for (int i = 0; i < numberOfLines; i++){
            int elementCount = input.nextInt() - 2;
            int[] compareArray = new int[elementCount];
            //This will store the results in the array
            for (int j = 0; j < elementCount; j++){
                compareArray[j] = input.nextInt();
            }

            //Get the index to compute the result
            int indexCount1 = input.nextInt() - 1;
            int indexCount2 = input.nextInt() - 1;

            //Get the index and start calculating the result
            if (compareArray[indexCount1] != compareArray[indexCount2]){
                result[i] = compareArray[indexCount1] + compareArray[indexCount2];
            } else {
                result[i] = compareArray[indexCount1] + compareArray[indexCount2];
            }
        }
        //Print out the result
        for (int i = 0; i < numberOfLines; i++){
            System.out.print(result[i] + "\n");
        }
    }
}
