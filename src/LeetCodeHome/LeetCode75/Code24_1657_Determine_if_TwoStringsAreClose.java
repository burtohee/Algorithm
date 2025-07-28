package LeetCodeHome.LeetCode75;

import java.util.*;
import java.util.stream.Collectors;

public class Code24_1657_Determine_if_TwoStringsAreClose {

    public static void main(String [] args)
    {
        Code24_1657_Determine_if_TwoStringsAreClose code241657DetermineIfTwoStringsAreClose = new Code24_1657_Determine_if_TwoStringsAreClose();
        String[][] testCases = {
                {"cabbba", "abbccc"}, // 49,
                {"abc", "bca"}, // 49
                {"a", "aaa"}, // 49
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
            boolean result = code241657DetermineIfTwoStringsAreClose.closeStrings(testCases[i][0],testCases[i][1]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }

    public boolean closeStrings(String word1, String word2) {
//        Solution1 solution1 = new Solution1();
//        return solution1.closeStrings(word1, word2);
        return false;
    }



    class Solution1 {
        public boolean closeStrings(String word1, String word2){
            int m=word1.length();
            int n=word2.length();
            if(m!=n) return false;

            int[] freq1= new int[26];
            int[] freq2= new int[26];

            for(int i=0;i<m;i++)
            {
                freq1[word1.charAt(i) -'a']++;
            }

            for(int i=0;i<n;i++)
            {
                freq2[word2.charAt(i) -'a']++;
            }

            for(int i=0;i<26;i++)
            {
                if(freq1[i]!=0 && freq2[i]!=0) continue;
                if(freq1[i]==0 && freq2[i]==0) continue;

                return false;
            }
            Arrays.sort(freq1);
            Arrays.sort(freq2);

            return Arrays.equals(freq1, freq2);
        }
    }

    class Solution3 {
        public boolean closeStrings(String word1, String word2) {

            if(word1.length() != word2.length())
                return false;
            // length
            // characters
            // frequencies
            // e,g,   3 1 1 : 1 2 2

            HashMap<Character, Integer> hashMap1 = new HashMap<>();
            HashMap<Character, Integer> hashMap2 = new HashMap<>();

            for(int i = 0; i < word1.length(); i++)
            {
                hashMap1.put(word1.charAt(i), hashMap1.getOrDefault(word1.charAt(i), 1) + 1);
                hashMap2.put(word2.charAt(i), hashMap2.getOrDefault(word2.charAt(i), 1) + 1);
            }

            if(!hashMap1.keySet().equals(hashMap2.keySet()))
            {
                return false;
            }

            // Sort by values and collect into a LinkedHashMap
            Map<Character, Integer> sortedMap11 = hashMap1.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1, // merge function (not used here)
                            LinkedHashMap::new // keeps insertion order
                    ));

            System.out.println("Sorted by values: " + sortedMap11);

            // java 7
            // Step 1: Convert map entries to a list
            List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(hashMap1.entrySet());

            // Step 2: Sort the list with a custom comparator (by value)
            Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
                public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                    return e1.getValue().compareTo(e2.getValue()); // ascending
                }
            });

            // Step 3: Put the sorted entries into a LinkedHashMap to preserve order
            Map<Character, Integer> sortedMap12 = new LinkedHashMap<>();
            for (Map.Entry<Character, Integer> entry : entryList) {
                sortedMap12.put(entry.getKey(), entry.getValue());
            }

            // Output
            System.out.println("Sorted by values: " + sortedMap12);

            // Check: same multiset of frequencies
            List<Integer> values1 = new ArrayList<>(hashMap1.values());
            List<Integer> values2 = new ArrayList<>(hashMap2.values());
            Collections.sort(values1);
            Collections.sort(values2);

            return values1.equals(values2);
        }
    }



    class Solution2 {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) return false;

            int[] cnt1 = new int[26], cnt2 = new int[26];
            for (char c : word1.toCharArray()) cnt1[c - 'a']++;
            for (char c : word2.toCharArray()) cnt2[c - 'a']++;

            // Check matching character sets
            for (int i = 0; i < 26; i++) {
                if ((cnt1[i] == 0) != (cnt2[i] == 0)) {
                    return false;
                }
            }

            // Check matching sorted frequency distributions
            Arrays.sort(cnt1);
            Arrays.sort(cnt2);
            return Arrays.equals(cnt1, cnt2);
        }
    }


    class Solution5 {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) return false;

            // Count frequencies of each character
            Map<Character, Integer> freq1 = new HashMap<>();
            Map<Character, Integer> freq2 = new HashMap<>();

            for (char c : word1.toCharArray()) {
                freq1.put(c, freq1.getOrDefault(c, 0) + 1);
            }

            for (char c : word2.toCharArray()) {
                freq2.put(c, freq2.getOrDefault(c, 0) + 1);
            }

            // Check: same set of characters
            if (!freq1.keySet().equals(freq2.keySet())) return false;

            // Check: same multiset of frequencies
            List<Integer> values1 = new ArrayList<>(freq1.values());
            List<Integer> values2 = new ArrayList<>(freq2.values());
            Collections.sort(values1);
            Collections.sort(values2);

            return values1.equals(values2);
        }
    }



}
