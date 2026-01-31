/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max_length = 0;
        int max_frequency = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right=0; right<s.length(); right++) {
            char right_element = s.charAt(right);
            map.put(right_element, (map.getOrDefault(right_element, 0) +1));
            max_frequency = Math.max(max_frequency, map.get(right_element));
            int subString_length = right - left + 1;

            while ((subString_length - max_frequency)>k) {
                char left_element = s.charAt(left);
                map.put(left_element, (map.get(left_element)-1));

                if (map.get(left_element)==0) {
                    map.remove(left_element);
                }
                left++;
                subString_length = right - left + 1;
            }

            max_length = Math.max(max_length, subString_length);
        }
        return max_length;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        System.out.println(solution.characterReplacement("AAAA", 1));
    }
}
