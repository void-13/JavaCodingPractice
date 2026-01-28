import java.util.HashMap;
import java.util.Map;

/*
Given a string s, find the length of the longest substring without duplicate characters.
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacter {
    /*
    Time Complexity: O(n)
    Space Complexity: O(min(m,n)) where m is the size of the charset
     */
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int max_count = 0;
        int subStringSize;
        Map<Character, Integer> hm = new HashMap<>();

        for (int right=0; right<s.length(); right++) {
            char right_element = s.charAt(right);

//            1st approach to move left pointer

//            // If element already exists in the window, shrink from left
//            while (hm.containsKey(right_element)) {
//                    char left_element = s.charAt(left);
//                    hm.remove(left_element);
//                    left++;
//            }
//            hm.put(right_element, 1);

//           2nd approach - Move left pointer to the index next to the last occurrence of right_element

            if (hm.containsKey(right_element)) {
                left = Math.max(left, hm.get(right_element) + 1);
            }

            // Update character's latest position
            hm.put(right_element, right);

            // Calculate max length
            subStringSize = right-left+1;
            max_count = Math.max(max_count, subStringSize);
        }
        return max_count;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacter lss = new LongestSubstringWithoutRepeatingCharacter();
        System.out.println(lss.lengthOfLongestSubstring(""));
    }
}
