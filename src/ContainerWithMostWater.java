/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int maxArea(int[] height) {

        if (height.length == 0 || height.length == 1) {
            return 0;
        }

        int max_area = 0;
        int left = 0;
        int right = height.length - 1;

        while (left<right) {
            int area = Math.min(height[left], height[right]) * (right-left);
            max_area = Math.max(area, max_area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max_area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater water = new ContainerWithMostWater();
        int[] input = {1,3,2,5,25,24,5};
        System.out.println(water.maxArea(input));
    }
}
