package LeetCodeHome.LeetCode75;

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
        }



}
