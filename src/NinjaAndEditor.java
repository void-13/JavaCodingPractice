/*
Ninja wants to print a book of stories. He created a doc file and sent it to his editor to make some edits. But the file got corrupted due to some reasons and made changes in the original file. Ninja did not have a duplicate file of the same, so he wants to correct the same file. He found that the file has been changed in such a way that all the spaces have been removed from the file and the first letter after each space that used to be has been changed to the equivalent uppercase characters.
Example:
If the corrupted file looks like “CodingNinjasIsACodingPlatform”, then the original file was: “coding ninjas is a coding platform”.
Ninja needs to change the corrupted file to the original file.
Note:
You need to convert all the uppercase characters to lowercase characters, and you need to add a single space between every two words.

https://www.naukri.com/code360/problem-of-the-day/easy

 */
public class NinjaAndEditor {
    /*
    Time Complexity: O( n )
    Space Complexity: O( n )
     */
    public static String editSentence(String str){
        StringBuilder sb = new StringBuilder();
        int length = str.length();

        for (int i=0; i<length; i++) {
            char ch = str.charAt(i);
            if(Character.isUpperCase(ch)) {
                sb.append(" ").append(Character.toLowerCase(ch));
            } else
                sb.append(ch);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(editSentence("IAmACompetitiveProgrammer"));
    }
}
