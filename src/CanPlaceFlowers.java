/*
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
        Time Complexity: O(n)
        Space Complexity: O(1)
         */
        if (flowerbed == null || flowerbed.length == 0)
        {
            return false;
        }

        int count = 0;
        for(int flower=0; flower < flowerbed.length; flower++) {
            boolean leftEmpty = (flower == 0) || (flowerbed[flower-1] == 0);
            boolean rightEmpty = (flower == flowerbed.length - 1) || (flowerbed[flower+1] == 0);

            if (leftEmpty && (flowerbed[flower] == 0) && rightEmpty) {
                flowerbed[flower] = 1;
                count++;
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlowers p = new CanPlaceFlowers();
        int[] flowerbed = {1,0,0,0,1};
        int n = 2;
        boolean result = p.canPlaceFlowers(flowerbed, n);
        System.out.println(result);
    }
}
