public class TwoSumII {

    // Time Complexity: O(n)
    //Space Complexity: O(1)

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
            else
                return new int[]{i+1, j+1};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = {-1,0};
        int target = -1;
        int[] res = twoSum(numbers, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
