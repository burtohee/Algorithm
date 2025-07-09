package LeetCodeHome.LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Code03_1431_KidsWiththeGreatestNumberofCandies {


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = processkKidsWithCandies(candies, extraCandies);

        return result;
    }

    public static int getMax(int[] candies)
    {
//        int max = candies[0];
//        for(Integer c: candies)
//        {
//            max = Math.max(max, c);
//        }
//        return max;


        int max = Integer.MIN_VALUE;
        for (int c : candies)
        {
            max = Math.max(max, c);
        }
        return max;

//        return Arrays.stream(candies).max().orElse(Integer.MIN_VALUE);

//        String[] data = {"5", "12", "15", "60"};
//        return Arrays.stream(data)              // data: String
//                .mapToInt(Integer::parseInt)     // Convert to int
//                .filter(n -> n > 10)             // Filter condition
//                .max()                           // Find max
//                .orElse(Integer.MIN_VALUE);      // Default if empty

    }

    public static List<Boolean> processkKidsWithCandies(int[] candies, int extraCandies)
    {
        int max = getMax(candies);
        List<Boolean> result = new ArrayList<Boolean>();
        for(int i = 0; i < candies.length; i++)
        {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;


//        int max = Arrays.stream(candies).max().orElse(Integer.MIN_VALUE);
//
//        return Arrays.stream(candies)
//                .mapToObj(c -> c + extraCandies >= max)
//                .collect(Collectors.toList());
    }

    public static void main(String [] args)
    {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = processkKidsWithCandies(candies, extraCandies);
        System.out.println(result);  // Output: [true, true, true, false, true]

    }

    class Solution1 {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int maxCandies = 0;
            for (int candy : candies) {
                if (candy > maxCandies) {
                    maxCandies = candy;
                }
            }

            List<Boolean> result = new ArrayList<>();
            for (int i = 0; i < candies.length; i++) {
                if (candies[i] + extraCandies >= maxCandies) {
                    result.add(true);
                } else {
                    result.add(false);
                }
            }

            return result;
        }
    }

}


