package LeetCodeHome.LeetCode75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code15_1679_Max_Number_of_KSum_Pairs {


    public static void main(String [] args)
    {
        Code15_1679_Max_Number_of_KSum_Pairs code151679MaxNumberOfKSumPairs = new Code15_1679_Max_Number_of_KSum_Pairs();
        int[][][] testCases = {
                {{1,8,6,2,5,4,8,3,7,0}, {5}},
        };

        for (int i = 0; i < testCases.length; i++) {

            int result = code151679MaxNumberOfKSumPairs.maxOperations(testCases[i][0], testCases[i][1][0]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }



    }

    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        int operations = 0;
        while(left < right)
        {
            int sum = nums[left] + nums[right];

            if(sum == k)
            {
                operations++;
                left++;
                right--;
            }
            else if (sum < k)
            {
                left++; // Need a larger sum
            }
            else
            {
                right--; // Need a smaller sum
            }

        }


        return operations;
    }


    class Solution1 {
        public int maxOperations(int[] nums, int k) {
            int n=nums.length,rest,present=0;
            Arrays.sort(nums);
            int j=n-1;
            for(int i=0;i<j;){
                if(nums[i]+nums[j]==k){
                    present++;
                    i++;
                    j--;
                }else if((nums[i]+nums[j])>k){
                    j--;
                }else if((nums[i]+nums[j])<k){
                    i++;
                }
            }
            return present;
        }
    }


    class Solution3 {
        public int maxOperations(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int operations = 0;

            for (int num : nums) {
                int complement = k - num;

                if (map.getOrDefault(complement, 0) > 0) {
                    // Pair found
                    operations++;
                    map.put(complement, map.get(complement) - 1);
                } else {
                    // Store this number for future pair
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }

            return operations;
        }
    }

    class Solution2 {
        public int maxOperations(int[] nums, int k) {

            Arrays.sort(nums);
            int left = 0, right = nums.length - 1;

            int operations = 0;
            while(left < right)
            {
                int sum = nums[left] + nums[right];

                if(sum == k)
                {
                    operations++;
                    left++;
                    right--;
                }
                else if (sum < k)
                {
                    left++; // Need a larger sum
                }
                else
                {
                    right--; // Need a smaller sum
                }

            }


            return operations;
        }
    }

}
