
import java.lang.*;
import java.util.*;

class InsertionSort{
    static int[] insertionSort(int[] arr){
        // Create a new arry
        var sorted = new int[arr.length];
        // Solve trivial 
        sorted[0] = arr[0];
        // Loop across each key
        for (int i = 1; i < arr.length; i++){
            var key = arr[i];
            int j;
            // Moving forward each previous sorted key
            for (j = (i - 1); j >= 0 && sorted[j] > key; j--)
                sorted[j+1] = sorted[j];
            
            // Setting current key
            // Why (j + 1)? Because the for above will stop after decrementing j one more time for until the test failure, so it plus one for compensation.
            sorted[j + 1] = key;
        }
        
        // return the sorted array
        return sorted;
    }

    // It will create a random array, call the insertion sort and print the result
    public static void main(String[] args){
        System.out.println("Insertion Sort");
        Random rand = new Random();

        var arr = new int[rand.nextInt(50) + 1];
        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(200) + 1;

        System.out.println("input: " + Arrays.toString(arr));

        var sorted = insertionSort(arr);
        System.out.println("output: " + Arrays.toString(sorted));
    }
}