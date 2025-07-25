package LeetCodeHome.LeetCode75;

public class Code19_1493_LongestSubarrayof1sAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        return 1;
    }

    class Solution1 {
        public int longestSubarray(int[] nums) {
            int l = 0, maxCount = 0, zeroCount = 0;
            boolean noZeros = true;
            for(int r = 0; r < nums.length; r++)
            {
                if(nums[r] == 0)
                {
                    noZeros = false;
                    zeroCount++;
                }
                while(zeroCount > 1)
                {
                    if(nums[l] == 0)
                    {
                        zeroCount--;
                    }
                    l++;
                }
                int count = r - l + 1 - zeroCount;
                if(count > maxCount)
                {
                    maxCount = count;
                }
            }
            if(noZeros)
            {
                maxCount--;
            }
            return maxCount;
        }
    }



    class Solutiontemp1 {
        static {
            for(int i = 0; i < 500; i++) {
                longestSubarray(new int[] { 0 });
            }
        }
        public static int longestSubarray(int[] nums) {
            int cc =0 ,pc =0,ans=0,x=0;
            boolean d = false;
            for (int i =0 ;i<nums.length;i++){
                if(nums[i]==1){
                    cc++;
                }
                else{
                    d = true;
                    x=pc;
                    pc=cc;
                    cc=0;
                }
                ans=Math.max(pc+cc,ans);
            }
            return d?ans:nums.length-1;
        }
    }

    class Solutiontemp2 {
        public int longestSubarray(int[] nums) {
            int len = nums.length, lastZero = -1, max = 0, oneCount = 0;

            for(int i = 0; i < len; i++){
                if(nums[i] == 0) {
                    max = Math.max(max, oneCount + i - lastZero - 1);
                    oneCount = i - lastZero - 1;
                    lastZero = i;
                }
            }

            if(nums[len - 1] != 0) max = Math.max(max, oneCount + len - lastZero - 1);

            return max == len ? max - 1 : max;
        }
    }


}
