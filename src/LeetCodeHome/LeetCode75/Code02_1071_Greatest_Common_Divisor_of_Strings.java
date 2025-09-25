package LeetCodeHome.LeetCode75;

public class Code02_1071_Greatest_Common_Divisor_of_Strings {


    public String gcdOfStrings(String str1, String str2) {
        return processGreatest_Common_Divisor_of_Strings(str1, str2);
    }

    public static boolean isDivided(String candidate, String str1, String str2)
    {
        int candidateLength = candidate.length();

        if(str1.length() % candidateLength != 0 || str2.length() % candidateLength != 0)
        {
            return false;
        }

        int f1 = str1.length() / candidateLength;
        int f2 = str2.length() / candidateLength;

        return str1.equals(candidate.repeat(f1)) && str2.equals(candidate.repeat(f2));
    }

    public static String processGreatest_Common_Divisor_of_Strings(String str1, String str2){

//        String minStr = str1.length() < str2.length()? str1: str2;

        int str1Length = str1.length();
        int str2Length = str2.length();

        int minLength = Math.min(str1Length, str2Length);


        for(int i = minLength; i > 0; i--)
        {
            String candiate = str1.substring(0, i);
            if(isDivided(candiate, str1, str2))
            {
                return candiate;
            }
        }
        return "";
    }

    public static void main(String [] args)
    {
        String result = processGreatest_Common_Divisor_of_Strings("ABABAB", "ABAB");
        System.out.println(result);

        Solution solution = new Solution();
        String result1 = solution.gcdOfStrings("ABABAB", "ABAB");
        System.out.println(result1);

    }


    class Solution1 {
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }

            int lenGCD = gcd(str1.length(), str2.length());
            return str1.substring(0, lenGCD);
        }

        private int gcd(int len1, int len2) {
            while (len2 != 0) {
                int temp = len1 % len2;
                len1 = len2;
                len2 = temp;
            }
            return len1;
        }
    }

    class Solution2 {
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }

            int lenGCD = gcd(str1.length(), str2.length());
            return str1.substring(0, lenGCD);
        }

        private int gcd(int len1, int len2) {
            int minVal = Math.min(len1, len2);
            for (int i = minVal; i > 0; i--) {
                if (len1 % i == 0 && len2 % i == 0) {
                    return i;
                }
            }
            return 1;
        }
    }

    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if(!(str1 + str2).equals(str2+str1)) return "";

            int gcdLength = gcd(str1.length(), str2.length());
            return str1.substring(0, gcdLength);
        }
        public int gcd(int a, int b)
        {
            if(b==0) return a;
            return gcd(b,a%b);
        }
    }



}
