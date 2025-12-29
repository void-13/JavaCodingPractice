import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <a href="https://leetcode.com/problems/3sum/description/">...</a>
 * Time Complexity: O(n^2)
 *  Space Complexity: O(1)
 */
public class ThreeSum {

    /*

     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;

        for (int i=0; i<length-2; i++) {
            //Skipping duplicate for first element "i"
           if (i > 0 && (nums[i] == nums[i-1])) {
               continue;
           }

           //Terminating if smallest possible sum is > 0
            if (nums[i] + nums[i+1] + nums[i+2] > 0) {
                break;
            }

            //Terminating if smallest number is > 0
            if (nums[i] > 0) {
                break;
            }

            int left = i+1;
            int right = length-1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //Skipping duplicates for left and right elements
                    while (left < right && (nums[left] == nums[left+1])) {
                        left++;
                    }
                    while (left <right && (nums[right] == nums[right-1])) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}
