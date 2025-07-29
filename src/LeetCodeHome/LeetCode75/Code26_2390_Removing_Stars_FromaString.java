package LeetCodeHome.LeetCode75;

import java.util.Arrays;
import java.util.Stack;

public class Code26_2390_Removing_Stars_FromaString {

    public static void main(String [] args)
    {
        Code26_2390_Removing_Stars_FromaString code262390RemovingStarsFromaString = new Code26_2390_Removing_Stars_FromaString();
        String[] testCases = {
                "leet**cod*e",
                "erase*****", // 49,

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
            String result = code262390RemovingStarsFromaString.removeStars(testCases[i]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }


    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for(char c: chars)
        {
            if(c != '*')
            {
                stack.add(c);
            }
            else
            {
                stack.pop();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(char ch: stack)
        {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    class Solution1 {
        public String removeStars(String s) {
            char[] stack = new char[s.length()];
            int top=-1;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='*')
                    top--;
                else
                    stack[++top]=s.charAt(i);
            }
            char[] rstack=new char[top+1];
            for(int i=0;i<top+1;i++)
                rstack[i]=stack[i];
            return new String(rstack);
        }
    }

    class Solution0   {
        static{
            for(int i=0;i<500;i++) removeStars("m*");
        }
        public static String removeStars(String s) {
            int len = s.length();
            char[] cs = new char[len];
            cs[0] = s.charAt(0);
            int top = 0;
            for(int i=1;i<len;i++){
                char cc = s.charAt(i);
                if(cc == '*') cs[top--] = '\u0000';
                else cs[++top] = cc;
            }
            // StringBuilder sb = new StringBuilder();
            // for(char c:cs){
            //     if(c == '\u0000') continue;
            //     sb.append(c);
            // }
            return new String(cs,0,top+1);
        }
    }

    class Solution2 {
        public String removeStars(String s) {
            StringBuilder stack = new StringBuilder();

            for (char ch : s.toCharArray()) {
                if (ch == '*') {
//                    if (stack.length() > 0) {
                    if (!stack.isEmpty()) {
                        stack.deleteCharAt(stack.length() - 1); // pop last character
                    }
                } else {
                    stack.append(ch); // push character
                }
            }

            return stack.toString();
        }
    }

    class Solution3 {
        public String removeStars(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();

            for(char c: chars)
            {
                if(c != '*')
                {
                    stack.add(c);
                }
                else
                {
                    stack.pop();
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(char ch: stack)
            {
                stringBuilder.append(ch);
            }
            return stringBuilder.toString();
        }
    }


}
