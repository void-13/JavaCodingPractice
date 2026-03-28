/*
Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int zeroCount = 0;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement solution = new LongestSubarrayOf1sAfterDeletingOneElement();
        int[] nums = {1,1,1,1};
        System.out.println(solution.longestSubarray(nums));
    }
}
