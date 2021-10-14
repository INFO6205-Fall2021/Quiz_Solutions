package com.INFO6205.QuizSolutons.Quiz2;
import java.util.Arrays;

/*

        Find Duplicate Pairs:

        Given an array of integers nums, return the total number of unique pairs of duplicate elements (if a = b then a and b are a pair).
        Requirements:

        Complete the implementation of countDuplicatePairs method
        Your algorithm should be less than O(n2) time complexity. (You'll lose 10 points if your algorithm passes all the test cases but doesn't meet the requirement of the time complexity. )

        You need to return a count of unique pairs.
        Constraints:

        0<= nums.length <=1000

        -1000<= nums[i] <= 1000

        Example:

        input: [1, 2, 3, 4, 1]

        output: 1 (Pairs: [1,1])



        input: [-2, 2, 3, 5, 5,5,3,4,5]

        output: 2 (Pairs: [5,5], [3,3])

   */

public class Solution {
    public int countDuplicatePairs(int[] nums){
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int duplicatePairsCount = 0;
        while(i<nums.length){
            j = i+1;
            int localCount = 0;
            while(j< nums.length && nums[i] == nums[j]){
                j++;
                localCount++;
            }
            if(localCount > 0){
                duplicatePairsCount++;
            }
            i = j;
        }
        return duplicatePairsCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-1,2,3,4,5,-1,3,5,5,10,5,6,7,8,5};
        System.out.println("Duplicate pairs: " + s.countDuplicatePairs(nums));
    }
}