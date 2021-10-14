package com.INFO6205.QuizSolutons.Quiz1;
import java.util.Arrays;

/*

        --------------------Recursive Binary Insertion Sort-----------------

        You are expected to implement the recursive version of Binary Insertion Sort

        The classic Insertion Sort works in the following manner:

        To sort an array of size n in ascending order:
        1: Iterate from arr[1] to arr[n] over the array.
        2: Compare the current element to its predecessor. If the key element is smaller than its predecessor, successively compare it to the elements before until you find the correct position.
        3: Move the greater elements one position up to make space for the swapped element.



        Binary Insertion Sort replaces step 2 with Binary Search to find the correct location for the element to be inserted in.

        You are expected to implement a recursive version of this algorithm.



        Requirements:

        Complete the implementation of com.INFO6205.QuizSolutons.Quiz1.InsertionSort method
        Guidelines:

        You must not make any changes apart from the code you have to add to the 'TODO' sections.
        Modifying another section or unit test will result in 0 points. Make your changes in BinaryInsertionSort.java(Which will be under main folder).
        To test the code you have to click the run unit test button and NOT "Execute main()" button.

  */

public class InsertionSort {
    public int binarySearch(int[] a, int item, int low, int high)
    {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item == a[mid])
                return mid + 1;
            else if (item > a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
    public int[] insertionSort(int[] a, int n)
    {
        if(n <= 1){
            return a;
        }
        insertionSort(a, n-1);
        int i = binarySearch(a, a[n-1], 0, n-2);
        int j = a[n-1];
        for(int k = i; k<n; k++){
            int temp = a[k];
            a[k] = j; 
            j = temp;
        }
        
        return a;
    }

    public static void main(String[] args) {
        InsertionSort i = new InsertionSort();
        int[] a =  new int[]{5,4,3,2,1};
        i.insertionSort(a, 5);
        System.out.print(Arrays.toString(a));
    }
}
