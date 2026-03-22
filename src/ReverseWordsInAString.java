/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseWordsInAString {
    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
     */
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = words.length-1; i>=0; i--) {
            stringBuilder.append(words[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        String s = "the sky is blue";
        String result = reverseWordsInAString.reverseWords(s);

        System.out.println(result);
    }
}
