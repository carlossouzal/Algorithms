
import java.lang.*;
import java.util.*;

class MergeSort{
    static int[] merge(int[] A, int[] B){
        int[] result = new int[(A.length + B.length)];

        int i = 0;
        int j = 0;
        int k;
        
        for (k = 0; i < A.length && j < B.length; k++) {
            if (A[i] <= B[j]) {
                result[k] = A[i];
                i++;
            }else{
                result[k] = B[j];
                j++;
            }
        }

        for (; i < A.length; k++, i++)
            result[k] = A[i];

        for (; j < B.length; k++, j++)
            result[k] = B[j];

        return result;
    }

    static int[] mergeSort(int[] arr){
        if (arr.length <= 1){
            return arr;
        }

        int half = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;
        int[] left = Arrays.copyOfRange(arr, 0, half);
        left = mergeSort(left);        
        int[] right = Arrays.copyOfRange(arr, half, arr.length);
        right = mergeSort(right);

        return merge(left, right);
    }

    // It will create a random array, call the merge sort and print the result
    public static void main(String[] args){
        System.out.println("Merge Sort");
        Random rand = new Random();

        var arr = new int[rand.nextInt(50) + 1];
        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(200) + 1;

        System.out.println("input: " + Arrays.toString(arr));

        var sorted = mergeSort(arr);
        System.out.println("output: " + Arrays.toString(sorted));
    }
}