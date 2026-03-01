import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.isEmpty()
        || words == null || words.length == 0) {
            return result;
        }

        int strLen = s.length();
        int wordLen = words[0].length();
        int totalWords = words.length;
        int wordWindow = wordLen * totalWords;
        Map<String, Integer> totalWordFrequency = new HashMap<>();

        for (int i=0; i<totalWords; i++) {
            totalWordFrequency.put(words[i], totalWordFrequency.getOrDefault(words[i], 0) + 1);
        }

        for (int start=0; start<wordLen; start++) {
            Map<String, Integer> windowFrequency = new HashMap<>();

            int left = start;
            int right = start;
            int count = 0;

            while (right + wordLen <= strLen) {
                String substring = s.substring(right, right+wordLen);
                right += wordLen;

                
            }
        }

        return result;
    }
}
