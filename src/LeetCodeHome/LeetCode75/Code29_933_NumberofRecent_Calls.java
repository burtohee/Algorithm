package LeetCodeHome.LeetCode75;

import java.util.LinkedList;
import java.util.Queue;

public class Code29_933_NumberofRecent_Calls {





    class RecentCounter {
        private static final int[] records = new int[10000];
        private int start;
        private int end;
        public RecentCounter() {
            start = 0;
            end = 0;
        }
        public int ping(int t) {

//            d < t - 3000
//            t - d > 3000 (it is when condition does not meet)
            while (start < end && (t - records[start] > 3000)) {
                start++;
            }
            records[end++] = t;
            return end - start;
        }
    }


    class RecentCounter3 {

        private Queue<Integer> queue;

        public RecentCounter3() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
                queue.add(t);

                // Remove pings older than 3000 ms
//                while (!queue.isEmpty() && queue.peek() < t - 3000) {
                while (queue.peek() < t - 3000) {

                        queue.poll();
                }

                return queue.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */






}
