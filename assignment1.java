/**
 * Khoi Tran
 * CMSC 401
 * Professor Bulut
 * Implement Majority-Element finding. Element occurring more than N/2 times (order of elements doesn’t matter),
 * if M.E. exists, but -1, if the majority element does not exist in the array.
 */
import java.util.Scanner;

public class assignment1 {
    public static void main (String[] args){
        //A scanner class to take in the user input for the array
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] array = new int[num];

        //This is to record the user input for the array
        for (int i = 0; i < num; i++){
            array[i] = input.nextInt();
        }
        //Initialize the majority element and counter
        int ME = array[0];
        int counter = 1;

        for (int i = 1; i < num; i++){
            //This is to check whether or not the counter is at 0.
            //If it is then we shift the majority element to the next index of the array
            if (counter == 0) {
                ME = array[i];
            }
            //Check if the majority element matches with the index. If
            //it is then we increment, if it's not then decrement
            if (ME == array[i]){
                counter++;
            } else {
                counter--;
            }
        }
        //Reset the counter to 0
        counter = 0;
        //Go through the array again then increment the counter if it matches with the majority element
        for (int j = 0; j < array.length; j++) {
            if (ME == array[j]) {
                counter++;
            }
        }
        //Now start dividing the majority element by 2 to print out the final result
        if (counter > num / 2) {
            System.out.println(ME);
        } else {
            System.out.println(-1);
        }

    }

}
