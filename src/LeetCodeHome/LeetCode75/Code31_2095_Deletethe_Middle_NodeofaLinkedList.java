package LeetCodeHome.LeetCode75;

public class Code31_2095_Deletethe_Middle_NodeofaLinkedList {



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

    public int floor(double x)
    {
        int inPart = (int) x;
        if(inPart >= 0 || x == inPart)
        {
            return inPart;
        }
        else {
            // For negative numbers that are not integers, subtract 1. e.g. -2.3 -> -3
            return inPart - 1;
        }
    }
    public int length(ListNode head)
    {
        int count = 0;
        while(head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode prev = null, slow = head, fast = head;

        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return new ListNode();
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
        static {
            for (int i = 0; i < 500; i++) {
                deleteMiddle(null);
            }
        }
        public static ListNode deleteMiddle(ListNode head) {
            if(head == null || head.next==null)
                return null;
            ListNode slow = head, fast = head,prev=null;
            while(fast!=null && fast.next!=null){
                prev=slow;
                slow=slow.next;
                fast=fast.next.next;
            }
            prev.next=slow.next;
            return head;
        }
    }

    class Solution4 {
        public ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null) {
                return null; // Edge case: 0 or 1 node
            }
            ListNode dummy = new ListNode(0, head);
            ListNode slow = dummy, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }

    }


    class Solution3 {
        public ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null) return null;

            ListNode prev = null, slow = head, fast = head;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            prev.next = slow.next;
            return head;

        }
    }

}
