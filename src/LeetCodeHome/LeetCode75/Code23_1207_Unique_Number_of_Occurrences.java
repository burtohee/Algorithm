package LeetCodeHome.LeetCode75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code23_1207_Unique_Number_of_Occurrences {

    public static void main(String [] args)
    {
        Code23_1207_Unique_Number_of_Occurrences code231207UniqueNumberOfOccurrences = new Code23_1207_Unique_Number_of_Occurrences();
        int[][] testCases = {
                {1,2,2,1,1,3}, // 49
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
            boolean result = code231207UniqueNumberOfOccurrences.uniqueOccurrences(testCases[i]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }


    public boolean uniqueOccurrences(int[] arr) {

        return true;
    }

    class Solution1 {
        public boolean uniqueOccurrences(int[] arr) {

//            constraints:
//            1 <= arr.length <= 1000
//            -1000 <= arr[i] <= 1000
            int[] container = new int[2001];
            for (int num : arr) {
                container[num + 2001 / 2]++;
            }

            boolean[] result = new boolean[container.length];

            for (int num : arr) {
                int a = num + 2001 / 2;
                int index = container[a];
                if (index > 0 && result[index]) {
                    return false;
                }
                container[a] = 0;
                result[index] = true;
            }
            return true;
        }
    }


    class Solution2 {
        public boolean uniqueOccurrences(int[] arr) {

//          constraints:
//            1 <= arr.length <= 1000
//            -1000 <= arr[i] <= 1000
            int[] counts = new int[2001];

            for (int i =0;i<arr.length;i++)
            {
                int num=arr[i];
                counts[num + 1000]++;
            }
            boolean[] seen = new boolean[arr.length + 1];

            for (int count : counts)
            {
                if (count > 0)
                {
                    if (seen[count])
                    {
                        return false;
                    }
                    seen[count] = true;
                }
            }
            return true;
        }
    }




    class Solution5 {
        public boolean uniqueOccurrences(int[] arr) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int it: arr)
            {
                hashMap.put(it, hashMap.getOrDefault(it, 1) + 1);
            }
            Set<Integer> set = new HashSet<>();
            for(Map.Entry<Integer, Integer> entry: hashMap.entrySet())
            {
                if(set.contains(entry.getValue()))
                {
                    return false;
                }
                set.add(entry.getValue());
            }
            return true;
        }
    }


}
