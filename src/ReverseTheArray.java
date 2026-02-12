import java.util.ArrayList;
/*
Given an array/list 'ARR' of integers and a position ‘M’. You have to reverse the array after that position.

Example:

We have an array ARR = {1, 2, 3, 4, 5, 6} and M = 3 , considering 0
based indexing so the subarray {5, 6} will be reversed and our
output array will be {1, 2, 3, 4, 6, 5}.

https://www.naukri.com/code360/problems/reverse-the-array_1262298?leftPanelTabValue=PROBLEM
 */
public class ReverseTheArray {
    /*
    Approach: Two Pointers
    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        int left = m+1;
        int right = arr.size()-1;
        int temp;

        while (left < right) {
            temp = arr.get(right);
            arr.set(right, arr.get(left));
            arr.set(left, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);

        System.out.println("Original Array: " + arr);
        reverseArray(arr, 3);
        System.out.println("Reversed Array: " + arr);
    }
}
