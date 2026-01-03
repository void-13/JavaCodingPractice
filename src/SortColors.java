import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        int temp;

        while (mid <= right) {
            if (nums[mid] == 0) {
                temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;

                left++;
                mid++;
            } else if (nums[mid] == 2) {
                temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;

                right--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
