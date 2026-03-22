/*
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.isBlank()) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder(s);
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length()-1;

        while (left<right) {
            char left_char = s.charAt(left);
            if (vowels.indexOf(left_char) != -1) {
                char right_char = s.charAt(right);
                if (vowels.indexOf(right_char) != -1) {
                    stringBuilder.setCharAt(right, left_char);
                    stringBuilder.setCharAt(left, right_char);
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return  stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();
        String s = "IceCreAm";
        String result = reverseVowelsOfAString.reverseVowels(s);
        System.out.println(result);
    }
}
