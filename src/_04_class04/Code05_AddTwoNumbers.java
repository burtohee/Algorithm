package _04_class04;

public class Code05_AddTwoNumbers {


    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode addTwoNumbers(ListNode head1, ListNode head2)
    {
        int len1 = listLength(head1);
        int len2 = listLength(head2);

        ListNode l = len1 >= len2 ? head1: head2;
        ListNode s = l == head1 ? head2: head2;

        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;

        int carry = 0;
        int curNum = 0;

        /*
            1) L yes
               S yes

            2) L yes
               S no

            3) L no
               S no

         */

        while(curS != null)
        {
            curNum = curL.val + curL.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            // we need to keep track of long list for future carry bit extend
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while(curL != null)
        {
            curNum = curL.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            // we need to keep track of long list for future carry bit extend
            last = curL;
            curL = curL.next;
        }
        if(carry != 0)
        {
            last.next = new ListNode(carry);
        }

        return l;
    }


    public static ListNode addTwoNumbersWithIterative(ListNode head1, ListNode head2)
    {
        int curNum = 0;
        int carry = 0;
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode cur = result;
        while(head1.next != null && head2.next != null)
        {
            curNum = head1.val + head2.val + carry;
            cur.next = new ListNode(curNum % 10);
            carry = curNum / 10;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null)
        {
            curNum = head1.val + carry;
            cur.next = new ListNode(curNum % 10);
            carry = curNum / 10;
            head1 = head1.next;
        }
        while (head2 != null)
        {
            curNum = head2.val + carry;
            cur.next = new ListNode(curNum % 10);
            carry = curNum / 10;
            head2 = head2.next;
        }
        if(carry != 0)
        {
            cur.next = new ListNode(carry);
        }

        return result.next;
    }

    // HEAD 1 AND HEAD 2 IS NOT A NULL NODE
    public static ListNode addTwoNumbersWithRecursive(ListNode head1, ListNode head2)
    {
        int total = head1.val + head2.val;
        int next1 = total / 10;

        ListNode result = new ListNode(total % 10);

        if(head1.next != null || head2.next != null || next1 != 0)
        {
            if(head1.next != null)
            {
                head1 = head1.next;
            }
            else
            {
                head1 = new ListNode(0);
            }

            if(head2.next != null)
            {
                head2 = head1.next;
            }
            else
            {
                head2 = new ListNode(0);
            }

            head1.val = head1.val + next1;

            result.next = addTwoNumbersWithRecursive(head1,head2);
        }
        return result;
    }

    public static int listLength(ListNode head)
    {
        int len=0;
        while(head.next != null)
        {
            len++;
            head = head.next;
        }
        return  len;

    }
}
