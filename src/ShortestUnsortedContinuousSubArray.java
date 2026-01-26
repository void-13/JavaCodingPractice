/*
Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order. Return the shortest such subarray and output its length.
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */
public class ShortestUnsortedContinuousSubArray {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = -1;
        int right = -1;
        int max_element = Integer.MIN_VALUE;
        int min_element = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            max_element = Math.max(nums[i], max_element);
            if (nums[i] < max_element) {
                right = i;
            }
        }
        for (int j=n-1; j>=0; j--) {
            min_element = Math.min(nums[j], min_element);
            if (nums[j] > min_element) {
                left = j;
            }
        }
        if (right == -1) {
            return 0;
        }
        return (right - left + 1);
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubArray obj = new ShortestUnsortedContinuousSubArray();
        int[] nums = {5,10,2,4,1,8,9};
        int result = obj.findUnsortedSubarray(nums);
        System.out.println(result);
    }
}
