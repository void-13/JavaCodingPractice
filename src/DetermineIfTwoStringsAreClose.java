/*
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {
    /*
    Time complexity: O(n), where n is the length of the strings.
    Space complexity: O(1), since we use fixed-size arrays of size 26.
     */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        // Frequency arrays for both strings (26 lowercase letters)
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count character frequencies
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Check 1: Both strings must have the same set of characters
        // A character exists in a string if its frequency > 0
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) ||
                    (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Check 2: Both strings must have the same frequency distribution
        // Sort the frequency arrays and compare
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        DetermineIfTwoStringsAreClose solution = new DetermineIfTwoStringsAreClose();
        System.out.println(solution.closeStrings("cabbba", "abbccc"));
    }
}
