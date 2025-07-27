package LeetCodeHome.LeetCode75;

public class Code20_1732_Find_the_Highest_Altitude {

    public static void main(String [] args)
    {
        Code20_1732_Find_the_Highest_Altitude code201732FindTheHighestAltitude = new Code20_1732_Find_the_Highest_Altitude();
        int[][] testCases = {
                {-5,1,5,0,-7}, // 49
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
            int result = code201732FindTheHighestAltitude.largestAltitude(testCases[i]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }

    public int largestAltitude(int[] gain) {
        return 1;
    }


    class Solution1 {
        public int largestAltitude(int[] gain) {
            int sum=0,mx=0;
            for (int m:gain){
                sum+=m;
                mx=Math.max(mx,sum);
            }
            return mx;
        }
    }

    class Solution2 {
        public int largestAltitude(int[] gain) {
            int [] result = new int[gain.length + 1];
            int max = 0;
            for (int i = 1; i < result.length; i++)
            {
                result[i] = gain[i - 1] + result[i - 1];
                if(result[i] > max)
                {
                    max = result[i];
                }
            }
            return max;
        }
    }

}
