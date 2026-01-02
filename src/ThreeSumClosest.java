import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.
https://leetcode.com/problems/3sum-closest/description/
 */
public class ThreeSumClosest {
    /*
    Time Complexity: O(n^2). We have outer and inner loops, each going through n elements.
    Space Complexity: O(1). Only constant space is used.
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i=0; i<len-2; i++) {
            int left = i+1;
            int right = len-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                if (sum<target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
    }
}
