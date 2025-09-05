package LeetCodeHome.LeetCode75;

public class Code32_328_Odd_Even_LinkedList {

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
    class Solution1 {
        public ListNode oddEvenList(ListNode head) {

            if(head == null || head.next == null)
            {
                return head;
            }

            ListNode odd = head.next, even = head, headnext = head.next;
            while(odd != null && odd.next != null)
            {
                even.next = odd.next;
                even = odd.next;

                odd.next = even.next;
                odd = even.next;
            }
            even.next = headnext;
            return head;
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
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null)return head;
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenhead = even;
            while(even != null && even.next != null){
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenhead;
            return head;
        }
    }

}
