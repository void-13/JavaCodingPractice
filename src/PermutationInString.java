import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() > s1.length()) {
            return false;
        }

        int[] s1_arr = new int[26];
        int[] s2_arr = new int[26];

        for (int i=0; i<s1.length(); i++) {
            char ch = s1.charAt(i);
            s1_arr[ch - 'a']++;
        }

        for (int j=0; j<s1.length(); j++) {
            char ch = s2.charAt(j);
            s2_arr[ch - 'a']++;
        }

        int left = 0;
        int right = s1.length() - 1;

        while (right < s2.length()) {
            if(Arrays.equals(s1_arr, s2_arr)) {
                return true;
            } else {
                char remove = s2.charAt(left);
                s2_arr[remove - 'a']--;
                left++;
                right++;
                if (right < s2.length()) {
                    char add = s2.charAt(right);
                    s2_arr[add - 'a']++;
                }
            }
        }
        return false;
    }
}
