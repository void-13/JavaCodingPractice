/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
 */
public class MergeStringsAlternately {
    /*
    Time Complexity: O(m+n)
    Space Complexity: O(m+n)
     */
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null ||
                word2 == null ||
                word1.isBlank() ||
                word2.isBlank()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;

        while (word1.length() > counter && word2.length() > counter) {
            char w1 = word1.charAt(counter);
            stringBuilder.append(w1);
            char w2 = word2.charAt(counter);
            stringBuilder.append(w2);
            counter += 1;
        }

        while (word1.length() > counter) {
            char w1 = word1.charAt(counter);
            stringBuilder.append(w1);
            counter += 1;
        }

        while (word2.length() > counter) {
            char w2 = word2.charAt(counter);
            stringBuilder.append(w2);
            counter += 1;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String word1 = "ab";
        System.out.println("word1: " + word1);
        String word2 = "pqrst";
        System.out.println("word2: " + word2);
        MergeStringsAlternately m = new MergeStringsAlternately();
        String result = m.mergeAlternately(word1, word2);
        System.out.println("result: " + result);
    }
}
