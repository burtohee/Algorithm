package LeetCodeHome.LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Code05_345_Reverse_Vowels_of_a_String {


    public static String processReverseVowels(String s)
    {
        Code05_345_Reverse_Vowels_of_a_String code05345ReverseVowelsOfAString = new Code05_345_Reverse_Vowels_of_a_String();
        return  code05345ReverseVowelsOfAString.reverseVowels(s);
    }

    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start < end ){
            if(!isVowel(ch[start])){
                start++;
            } else if(!isVowel(ch[end])){
                end--;
            } else {
//                    char temp = ch[start];
//                    ch[start] = ch[end];
//                    ch[end] = temp;
                swap(ch, start, end);
                start++;
                end--;
            }
        }
        return String.valueOf(ch);
    }
    public void swap(char [] arr, int i, int j)
    {
        // this swap will not work if, i == j
        arr[i] = (char) (arr[i] ^ arr[j]);
        arr[j] = (char) (arr[i] ^ arr[j]);
        arr[i] = (char) (arr[i] ^ arr[j]);
    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;

    }


    public static void main(String [] args)
    {
        String test1 = "IceCreAm";
        String test1res = processReverseVowels(test1);
        System.out.println(test1res);

        String test2 = "IceCreAm";
        String test2res = Solution1.processReverseVowels(test2);
        System.out.println(test2res);



    }


    class Solution1 {
        public String reverseVowels(String s) {
            return processReverseVowels((s));
        }

        private boolean isVowel(char c) {
            c = Character.toLowerCase(c); // Handle both uppercase and lowercase vowels
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }

        public static void swap(char [] arr, int i, int j)
        {
            // this swap will not work if, i == j
            arr[i] = (char) (arr[i] ^ arr[j]);
            arr[j] = (char) (arr[i] ^ arr[j]);
            arr[i] = (char) (arr[i] ^ arr[j]);
        }

        public static String processReverseVowels(String s)
        {
            char[] sChars = s.toCharArray();
            int L = 0, R = s.length() - 1;

            ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            String loweredString = s.toLowerCase();

            while(L < R)
            {

                while(!vowels.contains(loweredString.charAt(L)))
                {
                    L++;
                }
                while(!vowels.contains(loweredString.charAt(R)))
                {
                    R--;
                }

                if(L < R)
                {
                    swap(sChars, L, R);
//                char temp = sChars[L];
//                sChars[L] = sChars[R];
//                sChars[R] = temp;
                    L++;
                    R--;
                }

            }
            return new String(sChars);
        }

    }


}
