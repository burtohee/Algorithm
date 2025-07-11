package LeetCodeHome.LeetCode75;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Code06_151_Reverse_Words_in_a_String {

    public String reverseWords(String s) {
        char[] st = s.toCharArray();
        char[] arr = new char[st.length];
        int index = reverse(st, arr, 0);
        return new String(arr, 0, index);
    }

    private int reverse(char[] st, char[] arr, int start){
        while(start < st.length && st[start] == ' '){
            start++;
        }
        int end = start;
        while(end < st.length && st[end] != ' '){
            end++;
        }
        if(start == end){
            return 0;
        }
        int reverseLen = reverse(st, arr, end);
        if(reverseLen != 0){
            arr[reverseLen++] = ' ';
        }
        while(start < end){
            arr[reverseLen++] = st[start++];
        }
        return reverseLen;
    }





    public static void main(String[] args)
    {
        Code06_151_Reverse_Words_in_a_String code06151ReverseWordsInAString = new Code06_151_Reverse_Words_in_a_String();
//        String test1 = "a good   example";
//        String test1res = code06151ReverseWordsInAString.reverseWords(test1);

        String test2 = "  hello world  ";
        String test2res = code06151ReverseWordsInAString.reverseWords(test2);
    }

    class Solution1 {

        public String reverseWords(String s) {
            return processReverseWords(s);
        }

        public static String processReverseWords(String s)
        {
            List<String> temp = Arrays.stream(s.split("\\s+")).filter(t -> !t.isEmpty()).toList();
//        return temp.reversed().stream().collect(Collectors.joining(" "));
            return String.join(" ", temp.reversed());
        }
    }



}
