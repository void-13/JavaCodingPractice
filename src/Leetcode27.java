public class Leetcode27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return right+1;
    }

    public static void main(String[] args) {
        Leetcode27 leetcode27 = new Leetcode27();
        int[] nums = {3,2,2,3};
        int val = 3;

        int result = leetcode27.removeElement(nums, val);
        System.out.println(result);
    }
}
