package LeetCodeHome.LeetCode75;

import java.util.Arrays;
import java.util.List;

public class Code25_2352_Equal_Row_and_Column_Pairs {

    public static void main(String [] args)
    {
        Code25_2352_Equal_Row_and_Column_Pairs code252352EqualRowAndColumnPairs = new Code25_2352_Equal_Row_and_Column_Pairs();
        int[][][] testCases = {
                { {3,2,1},{1,7,6},{2,7,7} } // 49
//                {1,1}, // 1
//                {1,0}, // 0
//                {0,0,0,1,2,0,0,8,0,1}, // 49

//                {6, 7, 1, 2},      // true
//                {1, 2, 3, 4, 5},      // true
//                {5, 4, 3, 2, 1},      // false
//                {2, 1, 5, 0, 4, 6},   // true
//                {20, 100, 10, 12, 5, 13}, // true
//                {1, 1, 1, 1, 1},      // false
//                {1, 2, 1, 3},          // true
//                {5, 1, 6}          // false
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = code252352EqualRowAndColumnPairs.equalPairs(testCases[i]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }

    public int equalPairs(int[][] grid) {
        return -1;
    }

    class Solution {
        public int equalPairs(int[][] grid) {
            int[][] row = new int[grid.length][grid[0].length];
            int[][] col = new int[grid.length][grid[0].length];

            for(int i = 0; i < grid.length; i++)
            {
                for(int j = 0; j < grid[i].length; j++)
                {
                    row[i][j] = grid[i][j];
                }
            }

//        for(int i = grid.length - 1; i > -1; i--)
//        {
//            int j = 0;
//            while(j < grid.length)
//            {
//                col[i][j] = grid[j][i];
//                j++;
//            }
//        }

            for(int i = grid.length - 1; i > -1; i--) {
                for (int j = 0; j < grid[i].length; j++) {

                    col[i][j] = grid[j][i];
                }
            }

            int counter = 0;
            for(int i = 0; i < row.length; i++)
            {
                for(int j = 0; j < row.length; j++)
                {
                    if(Arrays.equals(row[i], col[j]))
                    {
                        counter++;
                    }
                }
            }
            return counter;
        }
    }

}
