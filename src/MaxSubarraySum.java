public class MaxSubarraySum {

    public int maxSubarraySum(int[] arr, int k) {

        /* ***************1st Solution*********************


        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return -1;
        }

        int low = 0;
        int high = k - 1;
        int sum = 0;

        for (int i = low; i <= high; i++) {
            sum += arr[i];
        }
        low++;
        high++;
        int result = sum;
        return calculateMaxSum(arr, low, high, sum, result);
    }

    private int calculateMaxSum(int[] arr, int low, int high, int sum, int result) {
        while (high < arr.length){
            sum = sum - arr[low - 1] + arr[high];
            result = Math.max(sum, result);
            low++;
            high++;
        }
        return result;
         */

        // ***************2nd Solution (Simplified)*********************
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return -1;
        }

        // Initial window sum
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int maxSum = sum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i - k] + arr[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarraySum maxSubarraySum = new MaxSubarraySum();

        System.out.println(maxSubarraySum.maxSubarraySum(new int[]{1, 2, 3}, 2));
        System.out.println(maxSubarraySum.maxSubarraySum(new int[]{4, 5, 6}, 2));
    }
}
