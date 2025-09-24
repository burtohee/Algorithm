package LeetCodeHome.LeetCode75;

public class Code01_1768_Merge_Strings_Alternately {

    class Solution {
        public String mergeAlternately(String word1, String word2) {
            int i = 0, j =0;
            int a = word1.length(), b =word2.length();
            StringBuilder stringBuilder = new StringBuilder();
            while(i < a && j < b)
            {
                stringBuilder.append(word1.charAt(i));
                stringBuilder.append(word2.charAt(j));
                i++;
                j++;
            }
            if(i < a)
            {
                stringBuilder.append(word1, i, a);
            }
            if(j < b)
            {
                stringBuilder.append(word2, j, b);
            }
            return stringBuilder.toString();
        }
    }


    public String mergeAlternately(String word1, String word2) {

        int a =0;
        int b = 0;

        int i = word1.length();
        int j = word2.length();


        StringBuilder stringBuilder = new StringBuilder();

        while(a < i && b < j)
        {
            stringBuilder.append(word1.charAt(a++)).append(word2.charAt(b++));
        }

        if(a<i)
        {
            stringBuilder.append(word1, a, i);
        }

        if(b<j)
        {
            stringBuilder.append(word2, b, j);
        }
        return stringBuilder.toString();
    }



    public static void main(String [] args)
    {
        Code01_1768_Merge_Strings_Alternately code011768MergeStringsAlternately = new Code01_1768_Merge_Strings_Alternately();
        code011768MergeStringsAlternately.mergeAlternately("abc", "pqr++");
    }

    class Solution1 {
        public String mergeAlternately(String word1, String word2) {
            return processMergeAlternately(word1, word2);
        }

        public static String processMergeAlternately(String word1, String word2)
        {
            int a = word1.length();
            int b = word2.length();

            int i=0, j =0;

            StringBuilder stringBuilder = new StringBuilder();

            while(i < a && j <b)
            {
                stringBuilder.append(word1.charAt(i++)).append(word2.charAt(j++));
            }
            if(i < a)
            {
                stringBuilder.append(word1.substring(i));
            }
            if(j < b)
            {
                stringBuilder.append(word2.substring(j));
            }

            return stringBuilder.toString();

            //        int a = word1.length();
//        int b = word2.length();
//        // pointers
//        int i = 0, j = 0;
//
//        // result holder
//        StringBuilder sb = new StringBuilder();
//
//        // get everything when they are same length
//        while (i<a && j<b){
//            sb.append(word1.charAt(i++)).append(word2.charAt(j++));
//        }
//
//        if (i<a){
//            sb.append(word1.substring(i));
//        }
//        if (j<b){
//            sb.append(word2.substring(i));
//        }

//        return sb.toString();
        }
    }

    class Solution2 {
        public String mergeAlternately(String word1, String word2) {
            return processMergeAlternately(word1, word2);
        }

        public static String processMergeAlternately(String word1, String word2)
        {
            StringBuilder stringBuilder = new StringBuilder();
            int maxLength = Math.max(word1.length(), word2.length());

            for(int i = 0; i < maxLength; i++)
            {
                if(i < word1.length())
                {
                    stringBuilder.append(word1.charAt(i));
                }
                if(i < word2.length())
                {
                    stringBuilder.append(word2.charAt(i));
                }
            }
//        System.out.println("After append: " + stringBuilder);
            return stringBuilder.toString();
        }
    }


}


