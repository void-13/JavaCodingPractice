public class ReverseString {
    public static String reverseString(String str) {
        char[] result = new char[str.length()];
        int index = 0;

        for (int i = str.length()-1; i >=0; i--) {
            result[index] = str.charAt(i);
            index++;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello"));
    }
}