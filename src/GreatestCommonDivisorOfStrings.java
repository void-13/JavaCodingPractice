/*
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
public class GreatestCommonDivisorOfStrings {
    /*
    Time Complexity: O(m+n)
    Space Complexity: O(m+n)
     */
    public String gcdOfStrings(String str1, String str2) {

        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int str1_length, int str2_length) {
        while (str2_length != 0) {
            int temp = str2_length;
            str2_length = str1_length % str2_length;
            str1_length = temp;
        }
        return  str1_length;
    }

    public static void main(String[] args) {
        String str1 = "AAAAAB";
        String str2 = "AAA";
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings(str1, str2));
    }
}
