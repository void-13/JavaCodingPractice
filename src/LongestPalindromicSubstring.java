/*
Given a string s, return the longest palindromic substring in s.
https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=two-pointers
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        /*
        Approach: Expand Around Centers
        Time Complexity: O(n^2)
        Space Complexity: O(1)
         */
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int maxLength = 0;

        for (int current=0; current<s.length(); current++ ) {
            // Check odd-length palindrome (single character center)
            int[] odd = expand(s, current, current);
            // Check even-length palindrome (between two characters)
            int[] even = expand(s, current, current+1);

            if (odd[1] > maxLength) {
                start = odd[0];
                maxLength = odd[1];
            }

            if (even[1] > maxLength) {
                start = even[0];
                maxLength = even[1];
            }
        }
        return s.substring(start, start+maxLength);
    }

    private int[] expand(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left+1, right-left-1};
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String input = "abcdcda";
        System.out.println("Longest palindromic substring: " + solution.longestPalindrome(input));
    }
}
