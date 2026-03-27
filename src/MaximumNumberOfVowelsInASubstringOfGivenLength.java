/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int maxVowels(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        int count = 0;
        String vowel = "aeiouAEIOU";

        for (int i=0; i<k; i++) {
            char ch = s.charAt(i);
            if (vowel.indexOf(ch) != -1) {
                count++;
            }
        }

        int vowel_count = count;
        int left = 0;
        for (int right = k; right<s.length(); right++) {
            char left_ch = s.charAt(left);
            char right_ch = s.charAt(right);
            if (vowel.indexOf(left_ch) != -1) {
                count--;
            }
            if (vowel.indexOf(right_ch) != -1) {
                count++;
            }
            left++;
            vowel_count = Math.max(count, vowel_count);
        }
        return vowel_count;
    }

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubstringOfGivenLength solution = new MaximumNumberOfVowelsInASubstringOfGivenLength();
        String s = "leetcode";
        int k = 3;
        System.out.println(solution.maxVowels(s, k));
    }
}
