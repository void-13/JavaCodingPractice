/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
https://leetcode.com/problems/remove-element/description/?envType=problem-list-v2&envId=two-pointers
 */
public class RemoveElement {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] input = {0,1,2,2,3,0,4,2};
        int val = 2;
        int result = re.removeElement(input, val);
        System.out.println(result);
    }
}
