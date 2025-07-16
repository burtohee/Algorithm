package LeetCodeHome.LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Code10_334_Increasing_Triplet_Subsequence {

    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
   public static void main(String[] args) {
            Code10_334_Increasing_Triplet_Subsequence code10334IncreasingTripletSubsequence = new Code10_334_Increasing_Triplet_Subsequence();

            int[][] testCases = {
                    {2,1,5,0,4,6}, // true
                    {6, 7, 1, 2},      // true
                    {1, 2, 3, 4, 5},      // true
                    {5, 4, 3, 2, 1},      // false
                    {2, 1, 5, 0, 4, 6},   // true
                    {20, 100, 10, 12, 5, 13}, // true
                    {1, 1, 1, 1, 1},      // false
                    {1, 2, 1, 3},          // true
                    {5, 1, 6}          // false
            };

            for (int i = 0; i < testCases.length; i++) {
                boolean result = code10334IncreasingTripletSubsequence.increasingTriplet(testCases[i]);
                System.out.println("Test case " + (i + 1) + ": " + result);
            }
            Solution1 solution1 = new Solution1();


       System.out.println("==========");

            for (int i = 0; i < testCases.length; i++) {
               boolean result = solution1.increasingTriplet(testCases[i]);
               System.out.println("Test case " + (i + 1) + ": " + result);
            }



        }





    //LIS Solution: TC->O(NlogN)
    static class Solution1 {

        private int lowerBound(List<Integer> list, int target) {
            int left = 0, right = list.size();

            while (left < right) {
                int mid = left + (right - left) >> 1;
                if (list.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left; // Insertion index
        }

        public boolean increasingTriplet(int[] nums) {
            List<Integer> lis = new ArrayList<>();

            for (int num : nums) {
//                int idx = Collections.binarySearch(lis, num);
                int idx = lowerBound(lis, num);

//                If num exists in lis, it returns the index.
//                If not, it returns -(insertion point) - 1.

                if (idx < 0) {
                    idx = -idx - 1; // lower_bound behavior
                }
                if (idx == lis.size()) {
                    lis.add(num);
                } else {
                    lis.set(idx, num);
                }
            }

            return lis.size() >= 3;
        }
    };

    class Solution2 {

        public boolean increasingKSubsequence(int[] nums, int k) {
            long[] increasing = new long[k];
            Arrays.fill(increasing, Long.MAX_VALUE);

            for (int num : nums) {
                for (int j = 0; j < k; j++) {
                    if (increasing[j] >= num) {
                        increasing[j] = num;
                        break;
                    }
                }
                if (increasing[k - 1] != Long.MAX_VALUE) {
                    return true; // Found increasing subsequence of length k
                }
            }

            return false;
        }
    };


}
