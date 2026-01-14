import java.util.HashMap;
/*
You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.
https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 */
public class LongestSubstringWithKUniques {
    /*
    Time Complexity: O(n)
    Space Complexity: O(min(n, k))
     */
    public int longestKSubstr(String s, int k) {
        int left = 0;
        int maxLen = -1;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        if (s == null || s.isEmpty() || k <= 0) {
            return -1;
        }

        for (int right=0; right<s.length(); right++) {
            char rightChar = s.charAt(right);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar, 0)+1);

            while (hashMap.size() > k) {
                char leftChar = s.charAt(left);
                hashMap.put(leftChar, hashMap.get(leftChar)-1);
                if (hashMap.get(leftChar) == 0) {
                    hashMap.remove(leftChar);
                }
                left++;
            }
            if (hashMap.size() == k) {
                maxLen = Math.max(maxLen, (right-left+1));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithKUniques longestSubstringWithKUniques = new LongestSubstringWithKUniques();
        String testString = "aabaaab";
        int k = 2;
        int result = longestSubstringWithKUniques.longestKSubstr(testString, k);
        System.out.println(result);
    }
}
