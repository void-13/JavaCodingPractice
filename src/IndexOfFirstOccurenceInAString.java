/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=problem-list-v2&envId=two-pointers
 */
public class IndexOfFirstOccurenceInAString {
    /*
    Time Complexity: O(n*m)
    Space Complexity: O(1)
     */
    public int strStr(String haystack, String needle) {
        int haystack_index = 0;
        int haystack_length = haystack.length();
        int needle_length = needle.length();

        while (haystack_index < haystack_length) {
            int start = haystack_index;
            int needle_index = 0;

            while (haystack_index < haystack_length &&
                    needle_index < needle_length &&
                    haystack.charAt(haystack_index) == needle.charAt(needle_index)) {
               haystack_index ++;
               needle_index++;
            }
            if(needle_index == needle_length) {
                return start;
            }
            haystack_index = start + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        IndexOfFirstOccurenceInAString solution = new IndexOfFirstOccurenceInAString();
        String haystack = "leetcode";
        String needle = "code";

        int result = solution.strStr(haystack, needle);
        System.out.println(result);
    }
}
