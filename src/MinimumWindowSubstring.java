/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

https://leetcode.com/problems/minimum-window-substring/description/?envType=problem-list-v2&envId=sliding-window
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        /*
        Time Complexity: O(|s| + |t|)
        Space Complexity: O(1)
         */
        if (s == null || t == null || s.length()<t.length()) {
            return "";
        }

        int[] t_char_count = new int[256];
        for(char c : t.toCharArray()) {
            t_char_count[c]++;
        }

        int left = 0;
        int min_index=0;
        int min_window = Integer.MAX_VALUE;
        int found_char = t.length();

        for (int right=0; right<s.length(); right++) {
            char ch = s.charAt(right);

            if (t_char_count[ch] > 0) {
                found_char--;
            }
            t_char_count[ch] --;

            while (found_char == 0) {
                int curr_win_size = right-left+1;
                if (curr_win_size < min_window) {
                    min_window = curr_win_size;
                    min_index = left;
                }
                char left_char = s.charAt(left);
                t_char_count[left_char]++;
                if (t_char_count[left_char] > 0) {
                    found_char++;
                }
                left++;
            }
        }
        return min_window == Integer.MAX_VALUE ? "" : s.substring(min_index, min_index+min_window);
    }
}
