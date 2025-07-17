package LeetCodeHome.LeetCode75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code12_283_Move_Zeros {

    public static void main(String[] args) {
        Code12_283_Move_Zeros code12283MoveZeros = new Code12_283_Move_Zeros();

        int[][] testCases = {
                {0,1,0,3,12}
//                {2,1,5,0,4,6}, // true
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
            code12283MoveZeros.moveZeroes(testCases[i]);
        }
    }


    public void moveZeroes(int[] nums) {
        int zero = 0;
        for (int i = 0; i <  nums.length; i++) {
            if (nums[i] != 0) {
                nums[zero++] = nums[i];
            }
        }
        while(zero < nums.length) {
            nums[zero++] = 0;
        }

//         i
//           j
//        [0,1,0,3,12]

//           i
//             j
//        [1,0,0,3,12]


    }


    class Solution1 {
        public void moveZeroes(int[] nums) {

            LinkedList<Integer> list = new LinkedList<>();
            int count = 0;
            for(Integer i : nums)
            {
                if(i != 0)
                {
                    list.addLast(i);
                }
                else
                {
                    count++;
                }
            }
            for(int i = 0 ; i < count; i++)
            {
                list.addLast(0);
            }

            for(int i = 0 ; i < nums.length; i++)
            {
                nums[i] = list.pop();
            }



        }
    }

    class Solution2 {
        public void swap(int [] nums , int i, int j)
        {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];

        }

        public void moveZeroes(int[] nums) {

            int i = 0;

            while(i < nums.length)
            {
                int j = i + 1;

                while(j < nums.length && nums[j] == 0 )
                {
                    j++;
                }
                if(j < nums.length && nums[i] == 0)
                {
                    swap(nums, i , j);
                }

                i++;
            }

//         i
//           j
//        [0,1,0,3,12]

//           i
//             j
//        [1,0,0,3,12]


        }
    }

}
