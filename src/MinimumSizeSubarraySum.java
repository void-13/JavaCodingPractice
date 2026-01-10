/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class MinimumSizeSubarraySum {
    /*
    Time complexity: O(n)
    Space complexity: O(1)
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || (nums.length == 1 && nums[0] < target)) {
            return 0;
        }

        int low = 0;
        int high = 0;
        int sum = nums[low];
        int elementCount = Integer.MAX_VALUE;

        while (high<nums.length) {
            if (sum >= target) {
                int minElementCount = high-low+1;
                elementCount = Math.min(minElementCount, elementCount);

                    sum -= nums[low];
                    low++;
            } else {
                high++;
                if (high<nums.length) {
                    sum += nums[high];
                }
            }
        }
        return elementCount == Integer.MAX_VALUE ? 0 : elementCount;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen(15, nums));
    }
}
