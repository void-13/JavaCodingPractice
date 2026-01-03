/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
https://leetcode.com/problems/subarray-product-less-than-k/description/
 */
public class SubarrayProductLessThanK {
    /*
    Time complexity: O(n)
    Space complexity: O(1)
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int product = 1;
        int left = 0;
        for (int right=0; right< nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 0;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
