package LeetCodeHome.LeetCode75;

import java.util.ArrayList;

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
        public boolean increasingTriplet(int[] nums) {
            int n= nums.length;
            ArrayList<Integer> lis = new ArrayList<>();
            lis.add(nums[0]);
            for(int i=1;i<n;++i){

                if(nums[i] < lis.get(lis.size() - 1))
                {
                    lis.removeLast();
                    lis.addLast(nums[i]);
                }
                else if(nums[i] > lis.get(lis.size() - 1))
                {
                    lis.addLast(nums[i]);
                }

//                int lb = lower_bound(lis.begin(),lis.end(),nums[i])-lis.begin();
//                if(lb==lis.size())
//                    lis.push_back(nums[i]);
//                else
//                    lis[lb] = nums[i];
            }
            return lis.size()>=3;
        }
    };

//    class Solution2 {
//        public boolean increasingTriplet(vector<int>& nums) {
//            int n=nums.size();
//            int k=3;
//            vector<long long> increasing(k,LONG_MAX);
//
//            //Find an increasing subsequence of length k
//            for(int i=0;i<n;++i){
//                for(int j=0;j<k;++j){
//                    if(increasing[j]>=nums[i]){
//                        increasing[j]=nums[i];
//                        break;
//                    }
//                }
//                if(increasing[k-1]!=LONG_MAX)
//                    return true;//Found increasing subsequence of length K
//            }
//            return false;
//        }
//    };


}
