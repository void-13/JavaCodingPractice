/*
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
     */
    public boolean uniqueOccurrences(int[] arr) {

        if (arr == null) {
            return false;
        }
        Map<Integer, Integer> hm = new HashMap<>();

        for (int j : arr) {
            hm.put(j, hm.getOrDefault(j, 0) + 1);
        }
        Set<Integer> hs = new HashSet<>(hm.values());

        return hm.size() == hs.size();
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurrences solution = new UniqueNumberOfOccurrences();
        int[] arr = {1,2,2,1,1,3};
        System.out.println(solution.uniqueOccurrences(arr));
    }
}
