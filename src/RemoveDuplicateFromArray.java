import java.util.Arrays;
/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?source=submission-ac
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicateFromArray {
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int i = 0;
//        int j = 1;

        //SOLUTION using while loop:
//        while(j < nums.length){
//            if(nums[i] == nums[j]){
//                j++;
//            }else{
//                nums[i+1] = nums[j];
//                i++;
//                j++;
//                count++;
//            }
//        }
//        return count;


        // SOLUTION using for loop:
        for (int j=1; j<nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
