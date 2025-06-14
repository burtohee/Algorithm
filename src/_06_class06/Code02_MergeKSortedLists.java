
package _06_class06;

import java.util.Comparator;
import java.util.PriorityQueue;

// 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
public class Code02_MergeKSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

//    public static class ListNodeComparator implements Comparator<ListNode>
//    {
//        @Override
//        public int compare(ListNode n1, ListNode n2)
//        {
//            return n1.val - n2.val;
//        }
//    }
    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }

    }

    /*
          1     ->  4   ->      6
          2     ->  3   ->      7
          5     ->  5   ->      9

          we first put first node of each linklist to a PriorityQueue(min heap)

        Step 1:
             minheap  -------------------
                0     | 1 -> 4 -> ....  |
                1     | 2 -> 3 -> ....  |
                2     | 5 -> 5 -> ....  |
                      -------------------
        Step 2:
             minheap poll(), we get linked list of node(1),
             minheap  -------------------
                0     |                 |
                1     | 2 -> 3 -> ....  |
                2     | 5 -> 5 -> ....  |
                      -------------------
             result = 1 -> , then we place node(1).next back into minheap
             minheap  -------------------
                0     | 2 -> 3 -> ....  |
                1     | 4 -> 6 -> ....  |
                2     | 5 -> 5 -> ....  |
                      -------------------
             minheap poll(), we get linked list of node(2),
             minheap  -------------------
                0     |                 |
                1     | 4 -> 6 -> ....  |
                2     | 5 -> 5 -> ....  |
                      -------------------
             result = 1 -> 2, then we place node(2).next back into minheap
             minheap  -------------------
                0     | 3 -> ....       |
                1     | 4 -> 6 -> ....  |
                2     | 5 -> 5 -> ....  |
                      -------------------

                      ............

     */

    public static ListNode mergeKLists(ListNode[] lists) {
        // nothing in lists of linked list
        if (lists == null) {
            return null;
        }
        // move first node of each list into PriorityQueue
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        // nothing in heap
        if (heap.isEmpty()) {
            return null;
        }

        // get the minimum node in the heap
        ListNode head = heap.poll();
        // keep track of current node with pre
        ListNode pre = head;

        // after setting head into pre, we check if pre.next == null, if pre.next still have nodes, then we add the next node into heap
        if (pre.next != null) {
            heap.add(pre.next);
        }

        // loop until heap is empty
        while (!heap.isEmpty()) {

            // get next minumum node in the heap
            ListNode cur = heap.poll();

            // update the pre, and point pre.next to selected node
            pre.next = cur;
            // update pre to the selected node
            pre = cur;

            // check if the selected node.next empty, if not, add the selected node.next back into heap
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }

        // return the head
        return head;
    }

}