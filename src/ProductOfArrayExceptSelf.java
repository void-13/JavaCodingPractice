/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return  nums;
        }

        int[] answer = new int[nums.length];
        int right_product = 1;

            /*
    Time Complexity: O(n^2)
    Space Complexity: O(1)
     */
//        for (int i=0; i<nums.length; i++) {
//            for (int j=i-1; j>=0; j--) {
//                result *= nums[j];
//            }
//            for (int k=i+1; k<nums.length; k++) {
//                result *= nums[k];
//            }
//            answer[i] = result;
//            result = 1;
//        }
//        return answer;

        answer[0] = 1;
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
        for (int i = 1;i<nums.length;i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            answer[j] *= right_product;
            right_product *= nums[j];
        }
        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(nums)));
    }
}
