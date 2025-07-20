package LeetCodeHome.LeetCode75;

public class Code13_392_Is_Subsequence {

    public static void main(String [] args)
    {
        Code13_392_Is_Subsequence code13392IsSubsequence = new Code13_392_Is_Subsequence();

        String[][] testCases = {
                {"axc", "ahbgdc"}
//                {2,1,5,0,4,6}, // true
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
            boolean result = code13392IsSubsequence.isSubsequence(testCases[i][0],testCases[i][1]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }

    }

    public boolean isSubsequence(String s, String t) {
        return true;
    }

    class Solution1 {
        public boolean isSubsequence(String s, String t) {
            int i = 0, j =0;

            while(i < s.length() && j < t.length())
            {
                if(s.charAt(i) == t.charAt(j))
                {
                    i++;
                    j++;
                }
                else
                {
                    j++;
                }
            }
            return i == s.length();
        }
    }

    class Solution2 {
        public boolean isSubsequence(String s, String t) {
            char a[] = s.toCharArray();
            char b[] = t.toCharArray();
            boolean target = false;
            int j = 0;
            for (int i = 0; i < b.length && j < a.length; i++) {
                if (a[j] == b[i]) {
                    j++;
                }
            }
            if (a.length == j) {
                target = true;
            }

            return target;
        }
    }

    class Solution3 {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0){
                return true;
            }
            // s = ""
            // t = "ahbgdc"

            int holdInt = 0;

            for (int i = 0; i < t.length(); i++){
                if(s.charAt(holdInt) == t.charAt(i)){
                    holdInt++;
                    if(holdInt == s.length()){
                        return true;
                    }
                }
            }

            return false;
        }
    }

}

