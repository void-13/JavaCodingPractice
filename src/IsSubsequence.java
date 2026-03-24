/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class IsSubsequence {
    /*
    Time Complexity: O(n+m)
    Space Complexity: O(1)
     */
    public boolean isSubsequence(String s, String t) {
        int left = 0;
        for (int right=0; right<t.length(); right++) {
            if (left<s.length()) {
                char s_char = s.charAt(left);
                char t_char = t.charAt(right);

                if (s_char == t_char) {
                    left++;
                }
            }
        }
        return left == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";

        boolean result = isSubsequence.isSubsequence(s, t);
        System.out.println(result);
    }
}
