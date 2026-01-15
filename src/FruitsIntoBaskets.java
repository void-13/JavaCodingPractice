import java.util.HashMap;
import java.util.Map;
/*
fruit-into-baskets
https://leetcode.com/problems/fruit-into-baskets/description/
 */
public class FruitsIntoBaskets {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int totalFruit(int[] fruits) {
        int left = 0;
        int k = 2;
        int max_count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        if (fruits == null || fruits.length == 0) {
            return 0;
        }

        for (int right = 0; right< fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > k) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            max_count = Math.max(max_count, (right - left + 1));
        }
        return max_count;
    }

    public static void main(String[] args) {
        FruitsIntoBaskets fruitsIntoBaskets = new FruitsIntoBaskets();
        int[] input =  {1,2,3,2,2};
        System.out.println(fruitsIntoBaskets.totalFruit(input));
    }
}
