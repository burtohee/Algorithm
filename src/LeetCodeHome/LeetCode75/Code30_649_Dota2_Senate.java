package LeetCodeHome.LeetCode75;

import java.util.LinkedList;
import java.util.Queue;

public class Code30_649_Dota2_Senate {

    public static void main(String [] args)
    {
        Code30_649_Dota2_Senate code30649Dota2Senate = new Code30_649_Dota2_Senate();
        String[] testCases = {
                "RD",
                "RDD", // 49,

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
            String result = code30649Dota2Senate.predictPartyVictory(testCases[i]);

            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }

    public String predictPartyVictory(String senate) {
        return "";
    }

    class Solution {
        public String predictPartyVictory(String senate) {
            Queue<Character> q=new LinkedList<>();
            int Rdeletes=0;
            int Ddeletes=0;
            int ds=0;
            int rs=0;
            for(char c: senate.toCharArray()){
                q.offer(c);
                if(c=='D'){
                    ds++;
                }
                else{
                    rs++;
                }

            }
            Character last=null;
            while(!q.isEmpty()){
                Character c=q.poll();
                last=c;
                if(rs==0){
                    return "Dire";
                }
                if(ds==0){
                    return "Radiant";
                }
                if(c=='D'){
                    if(Ddeletes>0){
                        Ddeletes--;
                        ds--;
                        continue;
                    }
                    else{
                        Rdeletes++;
                        q.offer(c);
                    }
                }
                else{
                    if(Rdeletes>0){
                        Rdeletes--;
                        rs--;
                        continue;
                    }
                    else{
                        Ddeletes++;
                        q.offer(c);
                    }
                }
            }
            if(last=='D'){
                return "Dire";
            }
            return "Radiant";

        }
    }


    class Solution3 {
        public String predictPartyVictory(String senate) {
            int n = senate.length();
            Queue<Integer> radiant = new LinkedList<>();
            Queue<Integer> dire = new LinkedList<>();

            // Populate the queues with indices of R and D senators
            for (int i = 0; i < n; i++) {
                if (senate.charAt(i) == 'R') {
                    radiant.offer(i);
                } else {
                    dire.offer(i);
                }
            }

            // Simulate the rounds
            while (!radiant.isEmpty() && !dire.isEmpty()) {
                int r = radiant.poll();
                int d = dire.poll();

                // The senator with the smaller index bans the other
                if (r < d) {
                    radiant.offer(r + n); // R goes to the next round
                } else {
                    dire.offer(d + n); // D goes to the next round
                }
            }

            return radiant.isEmpty() ? "Dire" : "Radiant";
        }
    }

}


