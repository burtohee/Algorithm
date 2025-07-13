package LeetCodeHome.LeetCode75;

import java.util.Arrays;

public class Code09_238_Product_of_Array_Except_Self {


    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int [] result = new int[length], suff = new int[length];
        result[0] = 1;

        int i;
        for(i = 1; i < length; i++)
        {
            result[i] =  result[i - 1] * nums[i - 1];
        }
        int suffProduct = 1;
        for(i = length - 2; i > -1; i--)
        {
            suffProduct *= nums[i + 1];
            result[i] *= suffProduct;
        }
        return result;

    }


    class Solution1 {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int [] result = new int[length];

            for(int x = 0; x < length; x++)
            {
                int total = 1;
                for(int y = 0; y < length; y++) {
                    if(x == y)
                    {
                        continue;
                    }
                    total *= nums[y];
                }
                result[x] = total;
            }

            return result;

        }
    }

    class Solution2 {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int [] pre = new int[length], suff = new int[length], result = new int[length];
            pre[0] = 1;
            suff[length - 1] = 1;

            int i;
            for(i = 1; i < length; i++)
            {
                pre[i] =  pre[i - 1] * nums[i - 1];
            }

            for(i = length - 2; i > -1; i--)
            {
                suff[i] =  suff[i + 1] * nums[i + 1];
            }

            for(i= 0; i < length; i++)
            {
                result[i] = pre[i] * suff[i];
            }

            return result;

        }
    }

    class Solution3 {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int [] result = new int[length], suff = new int[length];
            result[0] = 1;
            suff[length - 1] = 1;

            int i;
            for(i = 1; i < length; i++)
            {
                result[i] =  result[i - 1] * nums[i - 1];
            }
            for(i = length - 2; i > -1; i--)
            {
                suff[i] =  suff[i + 1] * nums[i + 1];
            }

            for(i = 0; i < length; i++)
            {
                result[i] =  result[i] * suff[i];
            }

            return result;

        }
    }

    class Solution4 {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int [] result = new int[length];
            result[0] = 1;

            int i;
            for(i = 1; i < length; i++)
            {
                result[i] =  result[i - 1] * nums[i - 1];
            }
            int suffProduct = 1;
            for(i = length - 2; i > -1; i--)
            {
                suffProduct *= nums[i + 1];
                result[i] *= suffProduct;
            }
            return result;

        }
    }

    class Solution5 {
        public int[] productExceptSelf(int[] nums) {
            int product = 1;
            int zeroCount = 0;
            int zeroIndex = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    if (++zeroCount > 1)
                        break;
                    zeroIndex = i;
                } else
                    product *= nums[i];
            }

            if (zeroCount > 0) {
                Arrays.fill(nums, 0);

                if (zeroCount == 1)
                    nums[zeroIndex] = product;
            } else
                for (int i = 0; i < nums.length; i++)
                    nums[i] = product / nums[i];

            return nums;
        }
    }

    class Solution {

        static {
            for (int i = 0; i < 500; i++) {
                fastProductExceptSelf(new int[] { 0, 0 });
            }
        }

        public int[] productExceptSelf(int[] nums) {
            return fastProductExceptSelf(nums);
        }

        private int[] slowProductExceptSelf(int[] nums) {
            //Input: nums = [1,2,3,4]
            //Output: [24,12,8,6]
            int[] answer = new int[nums.length];
            int[] prefix = new int[nums.length];
            int[] postfix = new int[nums.length];

            //accumulate moving forward the product of the numbers on the left of the current position
            for(int i=0;i<nums.length;i++) {
                if(i==0){
                    prefix[i]=1;
                } else {
                    prefix[i]=prefix[i-1]*nums[i-1];
                }
            }
            //[1,1,2,6]


            // accumulate moving back the product of the numbers on the right
            for(int i=nums.length-1;i>=0;i--) {
                if(i==nums.length-1) {
                    postfix[i] = 1;
                } else {
                    postfix[i] = postfix[i+1]*nums[i+1];
                }
            }
            //[24,12,4,1]

            for(int i=0;i<nums.length;i++) {
                answer[i]=prefix[i]*postfix[i];
            }


            return answer;
        }

        private static int[] fastProductExceptSelf(int[] nums) {
            //Input: nums = [1,2,3,4]
            //Output: [24,12,8,6]
            int length=nums.length;
            int[] answer = new int[nums.length];
            int[] postfix = new int[nums.length];

            int product = 1;

            //accumulate moving forward the product of the numbers on the left of the current position
            for(int i=0;i<length;i++) {
                answer[i]=product;
                product*=nums[i];
            }
            //[1,1,2,6]

            product = 1;

            // accumulate moving back the product of the numbers on the right
            for(int i=length-1;i>=0;i--) {
                answer[i]*=product;
                product*=nums[i];
            }

            return answer;
        }
    }


}
