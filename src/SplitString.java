/*
You are given a string ‘str’ of even length. Your task is to find out if we divide the ‘str’ from the middle, will both the substrings contain an equal number of vowels or not.
 */
public class SplitString {
    /*
    Time Complexity : O(n)
    Space Complexity : O(1)
     */
    public static Boolean splitString(String str) {

        if (str == null || str.isEmpty() || str.length() == 1) {
            return false;
        }

        int str_length = str.length();
        int str_mid_point = str_length/2;
        int left_vowel_count = 0;
        int right_vowel_count = 0;

        for (int i = 0; i < str_mid_point; i++) {
            left_vowel_count = getVowelCount(str, left_vowel_count, i);
        }

        for (int j = str_mid_point; j < str_length; j++) {
            right_vowel_count = getVowelCount(str, right_vowel_count, j);
        }
        return left_vowel_count == right_vowel_count;
    }

    private static int getVowelCount(String str, int vowel_count, int i) {
        char index = Character.toLowerCase(str.charAt(i));
//        if (Character.toLowerCase(index) == 'a'
//        || Character.toLowerCase(index) == 'e'
//        || Character.toLowerCase(index) == 'i'
//        || Character.toLowerCase(index) == 'o'
//        || Character.toLowerCase(index) == 'u') {
//            vowel_count ++;
//        }

        if ("aeiou".indexOf(index) != -1) {
            vowel_count ++;
        }
        return vowel_count;
    }

    public static void main(String[] args) {
        boolean result = SplitString.splitString("CodingNINJAS");
        System.out.println(result);
    }
}
