/**
 * Khoi Tran
 * CMSC 401
 * Professor Bulut
 */

import java.util.Scanner;

public class assignment2 {
    public static void main (String[] args){
        //Take in the user input for the array to be able to produce the array
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] array1 = new int[num * 3];
        int xAxis = 0;
        int yAxis = 0;
        //Take in the yAxis and be able to produce the xAxis
        for (int i = 0; i < num * 2; i++){
            if (i % 2 == 0){
                yAxis = input.nextInt();
            } else {
                int value = input.nextInt();
                for (int j = 0; j < value; j++){
                    array1[xAxis] = yAxis;
                    xAxis++;
                }
            }
        }
        //An increment value to keep track if a value it's not zero then increment by 1
        int icr = 0;
        for (int i = 0; i < num * 3; i++){
            if (array1[i] != 0){
                icr += 1;
            }
        }
        //Another array keep track of the duplicate value so we can take that into
        //account for the calculation
        int[] array2 = new int[icr];
        for (int i = 0; i < icr; i++){
            array2[i] = array1[i];
        }
        //Start of the comparison and use the quicksort algorithm to pull put the correct median
        //value to give the correct final value
        int p = 0;
        int r = array2.length - 1;
        int midIndex1 = 0;
        int midIndex2 = 0;

        if (array2.length % 2 == 1){
            midIndex1 = (((array2.length + 1) / 2) - 1);
            int median = Quicksort(array2, p, r, midIndex1)[midIndex1];
            System.out.println(median);
        } else {
            midIndex1 = (array2.length / 2) - 1;
            midIndex2 = array2.length / 2;
            int median1 = Quicksort(array2, p, r, midIndex1)[midIndex1];
            int median2 = Quicksort(array2, p, r, midIndex2)[midIndex2];
            int realMedian = (value(array2, median1) < value(array2, median2)) ? median1 : median2;
            System.out.println(realMedian);
        }
    }
    /**
     * This is just a sum method to see the total output cost
     * after the garden calculation
    public static int sum(int[] arr){
        int sum = 0;
        for (int value : arr){
            sum += value;
        }
        return sum;
    */

    //Swap method so we can do the partition within the array
    public static void swap (int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //Partition method so we can start comparing and sorting the array
    public static int Partition(int [] A, int p, int r){
        int insert = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++){
            if (A[j] < insert){
                i = i + 1;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }
    //Quicksort method also to be able to compare and sort the array
    public static int[] Quicksort(int[] arr, int p, int r, int midIndex){
        if (p < r){
            int q = Partition(arr, p ,r);
            if (midIndex == q){
                return arr;
            }
            if (midIndex < q){
                Quicksort(arr, p, q - 1, midIndex);
            } else {
                Quicksort(arr, q + 1, r, midIndex);
            }
        }
        return arr;
    }
    //A method with a sum value to take in the array with all the numbers for calculating the sum of
    //the total
    public static int value(int[] nums, int j){
        int sum = 0;
        for (int num: nums){
            int local = absolute(num - j);
            sum += local;
        }
        return sum;
    }
    //For the absolute value if a value is less then 0 times it by -1 to push a positive value
    //to have a positive value in case the user input an error. If not just return the original value.
    public static int absolute(int a){
        if (a <= 0){
            return a*(-1);
        } else {
            return a;
        }
    }

}


