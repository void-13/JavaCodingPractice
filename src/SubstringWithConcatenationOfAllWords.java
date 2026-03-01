/*
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=problem-list-v2&envId=sliding-window
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    /*
    Time Complexity: O(m*n) where m is the length of the string and n is the length of each word
    Space Complexity: O(n) where n is the number of words
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.isEmpty()
                || words == null || words.length == 0) {
            return result;
        }

        int strLen = s.length();
        int wordLen = words[0].length();
        int totalWords = words.length;
        Map<String, Integer> totalWordFrequency = new HashMap<>();

        for (int i = 0; i < totalWords; i++) {
            totalWordFrequency.put(words[i], totalWordFrequency.getOrDefault(words[i], 0) + 1);
        }

        for (int start = 0; start < wordLen; start++) {
            Map<String, Integer> windowFrequency = new HashMap<>();

            int left = start;
            int right = start;
            int count = 0;

            while (right + wordLen <= strLen) {
                String substring = s.substring(right, right + wordLen);
                right += wordLen;

                if (totalWordFrequency.containsKey(substring)) {
                    windowFrequency.put(substring, windowFrequency.getOrDefault(substring, 0) + 1);
                    count++;

                    while (windowFrequency.get(substring) > totalWordFrequency.get(substring)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowFrequency.put(leftWord, windowFrequency.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == totalWords) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        windowFrequency.put(leftWord, windowFrequency.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                } else {
                    windowFrequency.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords sol = new SubstringWithConcatenationOfAllWords();
        System.out.println(sol.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(sol.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }
}
