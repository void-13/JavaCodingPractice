/*
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class FindPivotIndex {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left_sum = 0;
        int right_sum = 0;

        for (int i=1; i<nums.length; i++) {
            right_sum += nums[i];
        }

        for (int j=0; j<nums.length; j++) {
            if (j > 0) {
                left_sum += nums[j-1];
                right_sum -= nums[j];
            }

            if (left_sum == right_sum) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int[] nums = {2,1,-1};
        System.out.println(findPivotIndex.pivotIndex(nums));
    }
}
