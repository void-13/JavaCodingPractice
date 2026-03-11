import java.util.Arrays;
/*
Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.
https://leetcode.com/problems/next-permutation/description/?envType=problem-list-v2&envId=two-pointers
 */
public class NextPermutation {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public void nextPermutation(int[] nums) {
        int index = -1;
        int nums_length = nums.length;

        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        // Step 1: Find pivot (scan right to left, find first element smaller than its right neighbor)
        int right = nums_length - 1;
        while (right > 0) {
            if (nums[right] <= nums[right - 1]) {
                right--;
            } else {
                index = right - 1;
                break;
            }
        }
        // Step 2: If no pivot found, reverse entire array
        if (index == -1) {
            int left = 0, r = nums_length - 1;
            while (left < r) {
                int temp = nums[left];
                nums[left] = nums[r];
                nums[r] = temp;
                left++;
                r--;
            }
            return;
        }
        // Step 3: Find swap candidate (scan right to left, find first element greater than pivot)
        for (int i = nums_length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        // Step 4: Reverse the suffix after pivot index
        int left = index + 1, r = nums_length - 1;
        while (left < r) {
            int temp = nums[left];
            nums[left] = nums[r];
            nums[r] = temp;
            left++;
            r--;
        }
    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] input = {8,6,4,1};
        obj.nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }
}
