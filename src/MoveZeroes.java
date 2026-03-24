/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.Arrays;

public class MoveZeroes {
    /*
    Time Complexity = O(n)
    Space Complexity = O(1)
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        int temp;
        for (int right = 0; right < nums.length; right++) {
            if ((nums[left] != 0) && (nums[right] != 0)) {
                left++;
            } else if ((nums[left] == 0) && nums[right] != 0) {
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] input = {};
        moveZeroes.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}
