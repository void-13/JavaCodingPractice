import java.util.Arrays;

/*
Given an array arr consisting of only 0's and 1's in random order. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.
https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1
 */
public class SegregateZeroesAndOnes {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public static void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] == 0) {
                left++;
            } else {
                if (arr[right] == 1) {
                    right--;
                } else {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0};
        segregate0and1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
