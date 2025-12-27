import java.util.Arrays;

/*
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */
public class SquaresOfSortedArray {

    /*
     * Time Complexity -> O(n)
     * Space Complexity -> O(n)
     */
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int index = nums.length-1;
        int[] result = new int[nums.length];

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(input)));
    }
}
