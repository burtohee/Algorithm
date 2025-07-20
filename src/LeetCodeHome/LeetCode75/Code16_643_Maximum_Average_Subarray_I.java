package LeetCodeHome.LeetCode75;

public class Code16_643_Maximum_Average_Subarray_I {





    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int sum = 0;

            // Compute the initial window sum
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }

            int maxSum = sum;

            // Slide the window through the array
            for (int i = k; i < nums.length; i++) {
                sum += nums[i] - nums[i - k];  // Slide window
                maxSum = Math.max(maxSum, sum);
            }

            return (double) maxSum / k;
        }
    }


}
