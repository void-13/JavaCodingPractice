import java.util.Arrays;
import java.util.HashMap;
/*
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class EqualRowAndColumnPairs {
    /*
    Time Complexity: O(n²)
    Space Complexity: O(n²)
     */
    public int equalPairs(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int len = grid.length;

//        int[][] column = new int[len][len];
        HashMap <String, Integer> hashMap = new HashMap<>();

        for (int[] row : grid) {
            String arr_str = Arrays.toString(row);
            hashMap.put(arr_str, hashMap.getOrDefault(arr_str, 0)+1);
        }

//        for (int i=0; i<len; i++) {
//            for (int j=0; j<len; j++) {
//                column[i][j] = grid[j][i];
//            }
//        }

        int count = 0;
        for (int col = 0; col < len; col++) {
            int[] column = new int[len];
            for (int row = 0; row < len; row++) {
                column[row] = grid[row][col];
            }
            String colStr = Arrays.toString(column);
            count += hashMap.getOrDefault(colStr, 0);
        }
//        for (int[] col : column) {
//            String row = Arrays.toString(col);
//            if (hashMap.containsKey(row)) {
//                count+= hashMap.get(row);
//            }
//        }
        return count;
    }

    public static void main(String[] args) {
        EqualRowAndColumnPairs equalRowAndColumnPairs = new EqualRowAndColumnPairs();
        int[][] grid = {{3,1,2,2}, {1,4,4,5}, {2,4,2,2}, {2,4,2,2}};

        int result = equalRowAndColumnPairs.equalPairs(grid);
        System.out.println(result);
        }
}
