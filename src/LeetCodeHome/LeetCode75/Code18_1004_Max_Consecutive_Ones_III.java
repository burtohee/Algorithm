package LeetCodeHome.LeetCode75;

public class Code18_1004_Max_Consecutive_Ones_III {


    public int longestOnes(int[] nums, int k) {
        int maxCount = 0, num_zeros = 0;
        int l = 0;
        for(int r = 0; r < nums.length; r++)
        {
            if(nums[r] == 0)
            {
                num_zeros += 1;
            }
            while(num_zeros > k)
            {
                if(nums[l] == 0)
                {
                    num_zeros-= 1;
                }
                l += 1;
            }
            int count = r - l + 1;
            if(count > maxCount)
            {
                maxCount = count;
            }
        }
        return maxCount;
    }


    class Solution1 {
        public int longestOnes(int[] nums, int k) {
            int maxCount = 0, num_zeros = 0, l = 0;
            for(int r = 0; r < nums.length; r++)
            {
                if(nums[r] == 0)
                {
                    num_zeros += 1;
                }
                while(num_zeros > k)
                {
                    if(nums[l] == 0)
                    {
                        num_zeros-= 1;
                    }
                    l += 1;
                }
                int count = r - l + 1;
                if(count > maxCount)
                {
                    maxCount = count;
                }
            }
            return maxCount;
        }
    }

    class Solution 2 {
        public int longestOnes(int[] nums, int k) {
            int right=0,res=0,maxres=0;
            int p=k;
            int rightt=0;
            while(right<nums.length){
                if(nums[right]==1){
                    res+=1;
                    maxres=Math.max(res,maxres);
                    right++;

                }
                else if(nums[right]==0 && p!=0){
                    res+=1;
                    maxres=Math.max(res,maxres);
                    p--;
                    right++;
                }
                else if(p==0 && nums[right]==0){
                    res=0;
                    p=k;
                    right=rightt+1;
                    rightt++;
                }
            }
            return maxres;
        }
    }


}
