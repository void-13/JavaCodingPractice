/*
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.
 */
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
     */
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }

        for (int num : nums) {
            int diff = k - num;
            if (hashMap.containsKey(diff)) {
                if (diff != num && hashMap.get(diff) > 0 && hashMap.get(num) > 0) {
                    count++;
                    hashMap.put(diff, hashMap.getOrDefault(diff, 0) - 1);
                    hashMap.put(num, hashMap.getOrDefault(num, 0) - 1);
                }
                if (diff == num && hashMap.get(diff) >= 2) {
                    count++;
                    hashMap.put(diff, hashMap.getOrDefault(diff, 0) - 1);
                    hashMap.put(num, hashMap.getOrDefault(num, 0) - 1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxNumberOfKSumPairs solution = new MaxNumberOfKSumPairs();
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        System.out.println(solution.maxOperations(nums, k));
    }
}
