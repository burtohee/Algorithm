package ArrayList;


// 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
public class Code07_MergeTwoSortedLinkedList {



    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // condtion 1: one of the linked like is null, return the other one
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        // first: find the smallest first position value
        /*
             1 -> 5 -> 7

             2 -> 6 -> 9

             1    5---->    7-----        (smaller first position value become the head of result)
             |    ^    |    ^    |
             |    |    V    |    V
             ---->2    6-----    9
         */
        ListNode head = head1.val <= head2.val ? head1 : head2;

        // curFirstSmaller: head of smaller first position, but before we do anything, we point the curFirstSmaller to the next node, because we know the first curFirstSmaller is the smallest
        /*
            head
             1      -> 5        -> 7     (smaller first position value become the head of result)
                   cursmaller

             2      -> 6        -> 9
         curlarger

         */
        ListNode curFirstSmaller = head.next;
        // curFirstLarger: head of larger first position
        ListNode curFirstLarger = head == head1 ? head2 : head1;

        // store a pre pointer
        ListNode pre = head;
        /*
           head
             1      -> 5        -> 7     (smaller first position value become the head of result)
            pre     cursmaller

             2      -> 6        -> 9
         curlarger

         */
        while (curFirstSmaller != null && curFirstLarger != null) {

            // check which linked list have smaller value, and then let pre.next point to that node, and move that linked list to next node,
            // and update the pre
            if (curFirstSmaller.val <= curFirstLarger.val) {
                /*
                   head
                     1         5        -> 7     (smaller first position value become the head of result)
                           cursmaller
                     |
                     V
                     2      -> 6        -> 9
                    pre     curlarger

                 */
                /*
                   head
                     1         5        -> 7     (smaller first position value become the head of result)
                           cursmaller
                     |         ^
                     V         |
                     2---------|        6        -> 9
                    pre              curlarger

                 */
                pre.next = curFirstSmaller;
                /*
                   head
                     1         5        -> 7     (smaller first position value become the head of result)
                                       cursmaller
                     |         ^
                     V         |
                     2---------|        6        -> 9
                    pre              curlarger

                 */
                curFirstSmaller = curFirstSmaller.next;
            } else {
                /*
                   head
                     1       5        -> 7     (smaller first position value become the head of result)
                    pre     cursmaller
                     |
                     V
                     2      -> 6        -> 9
                 curlarger

                 */
                pre.next = curFirstLarger;
                /*
                   head
                     1       5        -> 7     (smaller first position value become the head of result)
                    pre     cursmaller
                     |
                     V
                     2      -> 6        -> 9
                            curlarger

                 */
                curFirstLarger = curFirstLarger.next;
            }
            /*
                   head
                     1         5        -> 7     (smaller first position value become the head of result)
                           cursmaller
                     |
                     V
                     2      -> 6        -> 9
                    pre     curlarger

                 */
            pre = pre.next;
            /*
                   head       pre
                     1         5        -> 7     (smaller first position value become the head of result)
                                       cursmaller
                     |         ^
                     V         |
                     2---------|        6        -> 9
                                    curlarger

                 */
        }

        // at the end there will be one sorted linked list left behind, we need to pick it up, prev.next = rest of the nodes in that non-empty linked list
        pre.next = curFirstSmaller != null ? curFirstSmaller : curFirstLarger;
        return head;
    }


}
