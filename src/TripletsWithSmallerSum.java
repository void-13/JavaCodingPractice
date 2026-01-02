import java.util.Arrays;

/*
Given an array arr[] of distinct integers of size n and a value sum, the task is to find the count of triplets (i, j, k), having (i<j<k) with the sum of (arr[i] + arr[j] + arr[k]) smaller than the given value sum.
https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1
 */
public class TripletsWithSmallerSum {
    /*
    Time Complexity: O(n^2)
    Auxiliary Space: O(1)
     */
    static long countTriplets(int n, int sum, long[] arr) {
        Arrays.sort(arr);
        long count = 0;

        for (int i=0; i<n-2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long temp = arr[i] + arr[left] + arr[right];

                if (temp < sum) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long arr[] = {-2, 0, 1, 3};
        long count = countTriplets(4, 2, arr);

        System.out.println(count);
    }
}
