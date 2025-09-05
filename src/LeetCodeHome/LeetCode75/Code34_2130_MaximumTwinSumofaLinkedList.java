package LeetCodeHome.LeetCode75;

public class Code34_2130_MaximumTwinSumofaLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    class Solution {
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


            return 1;
        }
    }

    public void main()
    {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        solution.pairSum(node1);

    }
}
