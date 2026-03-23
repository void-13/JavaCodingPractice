/*
Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of consecutive repeating characters in chars:
If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
After you are done modifying the input array, return the new length of the array.
You must write an algorithm that uses only constant extra space.
Note: The characters in the array beyond the returned length do not matter and should be ignored.

https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class StringCompression {
    /*
    Time complexity: O(n)
    Space complexity: O(1)
     */
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }

        int left = 0;
        int count = 1;
        for (int right=1; right<chars.length; right++) {
            if (chars[left] == chars[right]) {
                count++;
            } else {
                if (count == 1) {
                    left++;
                    chars[left] = chars[right];
                } else {
                    if (count <= 9) {
                        chars[left + 1] = (char) ('0' + count);
                        left += 2;
                        chars[left] = chars[right];
                        count = 1;
                    } else {
                        String countStr = String.valueOf(count);
                        for (int i=0; i<countStr.length(); i++) {
                            chars[left + 1 + i] = countStr.charAt(i);
                        }
                        left += 1 + countStr.length();
                        chars[left] = chars[right];
                        count = 1;
                    }
                }
            }
        }
        if (count == 1) {
            left++;
        } else if (count <= 9) {
            chars[left + 1] = (char) ('0' + count);
            left += 2;
        } else {
            String countStr = String.valueOf(count);
            for (int i = 0; i < countStr.length(); i++) {
                chars[left + 1 + i] = countStr.charAt(i);
            }
            left += 1 + countStr.length();
        }

        return left;
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
