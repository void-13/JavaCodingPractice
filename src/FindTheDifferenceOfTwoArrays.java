/*
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();

        Set<Integer> nums1Set = new HashSet<>(); //O(n)
        Set<Integer> nums2Set = new HashSet<>(); // O(m)

        List<Integer> nums1List = new ArrayList<>(); //O(n)
        List<Integer> nums2List = new ArrayList<>(); // O(m)

        for (int num1 : nums1) { //O(n)
            nums1Set.add(num1);
        }

        for (int num2 : nums2) { // O(m)
            nums2Set.add(num2);
        }

        for (int set1 : nums1Set) { //O(n)
            if (!nums2Set.contains(set1)) {
                nums1List.add(set1);
            }
        }

        for (int set2 : nums2Set) { // O(m)
            if (!nums1Set.contains(set2)) {
                nums2List.add(set2);
            }
        }
        answer.add(nums1List);
        answer.add(nums2List);

        return answer;
    }

    public static void main(String[] args) {
        FindTheDifferenceOfTwoArrays solution = new FindTheDifferenceOfTwoArrays();
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        System.out.println(solution.findDifference(nums1, nums2));
    }
}
