package LeetCodeHome.LeetCode75;

public class Code34_2130_MaximumTwinSumofaLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    class Solution {
        public int pairSum(ListNode head) {
            int ans = 0;
            ListNode newList = null;
            ListNode current = head;
            ListNode currHalf = head;

            while (currHalf != null && currHalf.next != null) {
                currHalf = currHalf.next.next;
                ListNode temp = current.next;
                current.next = newList;
                newList = current;
                current = temp;
            }

            while (current != null) {
                ans = Math.max(ans, current.val + newList.val);
                current = current.next;
                newList = newList.next;
            }

            return ans;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution3 {
        public int pairSum(ListNode head) {

            int length = 0;

            ListNode lengthCounter = head;

            while(lengthCounter != null)
            {
                length++;
                lengthCounter = lengthCounter.next;
            }

            ListNode firstHalfHead = head;
            ListNode secondHalfHead = head;
            int mid = (length - 1 ) / 2;
            while(mid != -1)
            {
                secondHalfHead = secondHalfHead.next;
                mid--;
            }

            ListNode pre = null, next = null;
            while(secondHalfHead != null)
            {
                next = secondHalfHead.next;
                secondHalfHead.next = pre;
                pre = secondHalfHead;
                secondHalfHead = next;
            }
            secondHalfHead = pre;
            int max = Integer.MIN_VALUE;
            while(secondHalfHead != null)
            {
                int sum = firstHalfHead.val + secondHalfHead.val;
                if(sum > max)
                {
                    max = sum;
                }
                secondHalfHead = secondHalfHead.next;
                firstHalfHead = firstHalfHead.next;
            }


            return max;
        }
    }



    public static void main(String [] args)
    {
        Solution3 solution3 = new Solution3();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        int result = solution3.pairSum(node1);
        System.out.println(result);

    }
}
