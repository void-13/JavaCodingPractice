/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        /*
        Time Complexity: O(n)
        Space Complexity: O(1)
         */
        int low = 0;
        int zero_count = 0;
        int n = nums.length;

        if (nums.length == 0) {
            return 0;
        }
        for (int high = 0; high < n; high++) {
            if (nums[high] == 0) {
                zero_count++;
            }
            if (zero_count > k) {
                if (nums[low] == 0) {
                    zero_count--;
                }
                low++;
            }
        }
        return n-low;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII solution = new MaxConsecutiveOnesIII();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 6;

        int result = solution.longestOnes(nums, k);
        System.out.println(result);
    }
}
