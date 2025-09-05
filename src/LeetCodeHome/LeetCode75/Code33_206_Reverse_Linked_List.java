package LeetCodeHome.LeetCode75;

public class Code33_206_Reverse_Linked_List {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null,  next = null;
            while(head != null)
            {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
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
    class Solution2 {
        public ListNode reverseList(ListNode head) {

            if(head == null || head.next == null)
            {
                return head;
            }

            ListNode pre = null,  next = null;

            while(head != null)
            {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

}
