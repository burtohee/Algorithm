package LeetCodeHome.LeetCode75;

public class Code21_724_Find_Pivot_Index {

    public static void main(String [] args)
    {
        Code21_724_Find_Pivot_Index code21724FindPivotIndex = new Code21_724_Find_Pivot_Index();
        int[][] testCases = {
                {1,7,3,6,5,6}, // 49
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
            int result = code21724FindPivotIndex.pivotIndex(testCases[i]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }

    public int pivotIndex(int[] nums) {
        int rsum = 0;
        for(int i : nums)
        {
            rsum += i;
        }
        int lsum = 0;
        for(int i = 0 ; i < nums.length; i++)
        {
            rsum -= nums[i];
            if(lsum == rsum)
            {
                return i;
            }
            lsum += nums[i];
        }

        return -1;
    }



    class Solution1 {
        public int pivotIndex(int[] nums) {
            int rsum=0;
            for(int ele : nums){
                rsum= rsum+ele;
            }
            int lsum = 0;
            for(int i=0;i<nums.length;i++){
                rsum=rsum-nums[i];
                if(rsum==lsum){
                    return i;
                }
                lsum+=nums[i];
            }
            return -1;

        }
    }


    class Solution2 {
        public int pivotIndex(int[] nums) {
            int i = 0, len = nums.length;
            int [] preArray = new int[len];
            for(i = 1; i < len; i++)
            {
                preArray[i] = preArray[i - 1] + nums[i - 1];
            }
            int [] sufArray = new int[len];
            for(i = len - 2; i > -1; i--)
            {
                sufArray[i] = sufArray[i + 1] + nums[i + 1];
            }

            for(i = 0; i < len; i++)
            {
                if(preArray[i] == sufArray[i])
                {
                    return  i;
                }
            }
            return -1;
        }
    }

}
