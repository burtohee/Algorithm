package LeetCodeHome.LeetCode75;

import java.util.Stack;

public class Code28_394_Decode_String {

    public static void main(String [] args)
    {
        Code28_394_Decode_String code28394DecodeString = new Code28_394_Decode_String();
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
            String result = code28394DecodeString.decodeString(testCases[i]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }


    public String decodeString(String s) {
        return "";
    }

    class Solution1 {
        public String decodeString(String s) {
            Stack<Integer> st = new Stack<>();
            Stack<StringBuilder> string = new Stack<>();
            StringBuilder current  = new StringBuilder();
            int num = 0;
            for(int i = 0;i<s.length();i++){
                char ch  = s.charAt(i);

                if(Character.isDigit(ch)){
                    num = num*10 + (ch-'0');
                }
                else if(ch=='['){
                    st.push(num);
                    string.push(current);
                    current = new StringBuilder();
                    num = 0;
                }
                else if(ch==']'){
                    int top  = st.pop();
                    StringBuilder decoded = string.pop();
                    for (int j = 0; j < top; j++) {
                        decoded.append(current);
                    }
                    current  = decoded;
                }
                else {
                    current.append(ch);
                }
            }
            return current.toString();
        }
    }



    class Solution2 {
        public String decodeString(String s) {
            Stack<Integer> st = new Stack<>();
            Stack<StringBuilder> string = new Stack<>();
            StringBuilder current  = new StringBuilder();
            int num = 0;
            for(int i = 0;i<s.length();i++){
                char ch  = s.charAt(i);

                if(Character.isDigit(ch)){
                    num = num*10 + (ch-'0');
                }
                else if(ch=='['){
                    st.push(num);
                    string.push(current);
                    current = new StringBuilder();
                    num = 0;
                }
                else if(ch==']'){
                    int top  = st.pop();
                    StringBuilder decoded = string.pop();
                    for (int j = 0; j < top; j++) {
                        decoded.append(current);
                    }
                    current  = decoded;
                }
                else {
                    current.append(ch);
                }
            }
            return current.toString();
        }
    }


    class Solution3 {
        public String decodeString(String s) {
            StringBuilder currStr  = new StringBuilder();

            Stack<String> strStack = new Stack<>();
            Stack<Integer> numStrack = new Stack<>();

            int num = 0;

            for(char c : s.toCharArray())
            {
                if(Character.isDigit(c))
                {
                    num = num * 10 + (c - '0');
                }
                else if(c == '[')
                {
                    numStrack.push(num);
                    strStack.push(currStr.toString());
                    // reset for next sequence
                    currStr = new StringBuilder();
                    num = 0;
                }
                else if (c == ']')
                {
                    int repeatTimes = numStrack.pop();
                    StringBuilder temp = new StringBuilder(strStack.pop());
                    for (int i = 0; i < repeatTimes; i++) {
                        temp.append(currStr);
                    }
                    currStr = temp;
                }
                else {
                    currStr.append(c);
                }
            }
            return currStr.toString();
        }
    }



}
