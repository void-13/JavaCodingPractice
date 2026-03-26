/*
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaximumAverageSubarrayI {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max_avg = (double) sum/k;
        int left = 0;

        for (int right=k; right<nums.length; right++) {
            sum = sum - nums[left] + nums[right];
            max_avg = Math.max(max_avg, (double) sum /k);
            left++;
        }
        return max_avg;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI solution = new MaximumAverageSubarrayI();
        int[] nums = {5};
        int k = 1;

        System.out.println(solution.findMaxAverage(nums, k));
    }
}
