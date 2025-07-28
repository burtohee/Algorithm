package LeetCodeHome.LeetCode75;

import java.util.*;

public class Code22_2215_Find_the_Difference_ofTwo_Arrays {

    public static void main(String [] args)
    {
        Code22_2215_Find_the_Difference_ofTwo_Arrays code222215FindTheDifferenceOfTwoArrays = new Code22_2215_Find_the_Difference_ofTwo_Arrays();
        int[][][] testCases = {
                { {1,2,3},  {2,4,6}} // 49
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
            List<List<Integer>> result = code222215FindTheDifferenceOfTwoArrays.findDifference(testCases[i][0], testCases[i][1]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }

    class Solution1 {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> s1 = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
            for (int n : nums1) s1.add(n);
            for (int n : nums2) s2.add(n);

            List<Integer> ans1 = new ArrayList<>(s1);
            ans1.removeAll(s2);

            List<Integer> ans2 = new ArrayList<>(s2);
            ans2.removeAll(s1);

            return Arrays.asList(ans1, ans2);
        }
    }


    class Solution5 {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

            HashMap<Integer, Integer> hashMap1 = new HashMap<>();
            int i;
            for(i = 0; i < nums1.length; i++)
            {
                hashMap1.put(nums1[i] , 1);
            }
            HashMap<Integer, Integer> hashMap2 = new HashMap<>();
            for(i = 0; i < nums2.length; i++)
            {
                hashMap2.put(nums2[i] , 1);
            }

            List<Integer> r1 = new ArrayList<>();
            for(i = 0; i < nums1.length; i++)
            {
                if(hashMap2.get(nums1[i]) == null)
                {
                    if(!r1.contains(nums1[i]))
                    {
                        r1.add(nums1[i]);
                    }
                }

            }

            List<Integer> r2 = new ArrayList<>();
            for(i = 0; i < nums2.length; i++) {
                if(hashMap1.get(nums2[i]) == null)
                {
                    if(!r2.contains(nums2[i]))
                    {
                        r2.add(nums2[i]);
                    }
                }
            }


            List<List<Integer>> result = new ArrayList<>();
            result.add(r1);
            result.add(r2);

            return result;
        }
    }

}
