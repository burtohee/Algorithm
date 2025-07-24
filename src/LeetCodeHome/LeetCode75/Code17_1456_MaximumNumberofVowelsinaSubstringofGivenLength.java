package LeetCodeHome.LeetCode75;

public class Code17_1456_MaximumNumberofVowelsinaSubstringofGivenLength {


    public static void main(String [] args)
    {
        Code17_1456_MaximumNumberofVowelsinaSubstringofGivenLength code171456MaximumNumberofVowelsinaSubstringofGivenLength = new Code17_1456_MaximumNumberofVowelsinaSubstringofGivenLength();
        int[] testCasesK = {
                3,
                2,
                3,
        };

        String[] testCasesS = {
                "abciiidef",
                "aeiou",
                "leetcode",};


        for (int i = 0; i < testCasesS.length; i++) {
            int result = code171456MaximumNumberofVowelsinaSubstringofGivenLength.maxVowels(testCasesS[i], testCasesK[i]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }



    }

    public int maxVowels(String s, int k)
    {
        return 1;
    }



    class Solution1 {
        public int maxVowels(String s, int k) {
            int[] vowels = new int[s.length()];

            for(int i = 0; i<vowels.length; i++) {
                if(isVowel(s.charAt(i)))
                    vowels[i] = 1;
            }

            int sum = 0;
            for(int i = 0; i<k; i++) {
                sum+=vowels[i];
            }
            int max = sum;
            int begin = 1, end = k;
            while(end<vowels.length) {
                sum-=vowels[begin-1];
                sum+= vowels[end];
                if(sum > max) max = sum;
                begin++;
                end++;
            }
            return max;
        }

        public boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }

    class Solution2 {
        public int maxVowels(String s, int k) {
            //crating a window
            char[] str = s.toCharArray();
            int vowelCnt = 0;
            for(int i = 0 ; i < k ; i++){
                if(str[i] == 'a' ||str[i] == 'e' ||str[i] == 'i' ||str[i] == 'o' ||str[i] == 'u' )
                    vowelCnt++;
            }
            int maxCnt = vowelCnt;
            //slide the window
            for(int i = k ; i < str.length ; i++){
                if(str[i-k] == 'a' ||str[i-k] == 'e' ||str[i-k]== 'i' ||str[i-k] == 'o' ||str[i-k] == 'u' )
                    vowelCnt--;
                if(str[i] == 'a' ||str[i] == 'e' ||str[i] == 'i' ||str[i] == 'o' ||str[i] == 'u' )
                    vowelCnt++;
                if(vowelCnt > maxCnt)   maxCnt = vowelCnt;
            }
            return maxCnt;
        }
    }




    class Solution3 {
        public boolean ifVowel(char c)
        {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }

        public int maxVowels(String s, int k) {

            int count = 0;

            char [] chars = s.toCharArray();

            for(int i = 0; i < k; i++)
            {
                if(ifVowel(chars[i]))
                {
                    count++;
                }
            }
            int maxCount = count;
            for(int i = k; i < chars.length; i++)
            {
                if(ifVowel(chars[i]))
                {
                    count += 1;
                }
                if(ifVowel(chars[i - k]))
                {
                    count -= 1;
                }
                maxCount = Math.max(count, maxCount);

            }
            return maxCount;

        }
    }



}
