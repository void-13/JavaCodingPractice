public class BackspaceStringCompare {
    /*
    Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character. Note that after backspacing an empty text, the text will continue empty.
    https://leetcode.com/problems/backspace-string-compare/description/
     */
    public boolean backspaceCompare(String s, String t) {
        /*
        time complexity: O(n + m)
        space complexity: O(1)
         */
        int s_index = s.length() - 1;
        int t_index = t.length() - 1;

        while (s_index >= 0 || t_index >= 0) {
            s_index = characterIndex(s, s_index);
            t_index = characterIndex(t, t_index);

            if ((s_index >= 0) != (t_index >= 0))
                return false;
            if (s_index >= 0 && t_index >= 0 && s.charAt(s_index) != t.charAt(t_index)) {
                return false;
            }
            s_index--;
            t_index--;

        }
        return true;
    }

    private int characterIndex(String str, int index) {
        int skip = 0;

        while (index >= 0) {
            if (str.charAt(index) == '#') {
                skip++;
                index --;
            } else if (skip > 0) {
                index --;
                skip--;
            } else {
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();

        System.out.println(backspaceStringCompare.backspaceCompare("", "a#"));
    }
}
