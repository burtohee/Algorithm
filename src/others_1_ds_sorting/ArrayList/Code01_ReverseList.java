package others_1_ds_sorting.ArrayList;

public class Code01_ReverseList {

    public static class Node
    {
        public int value;
        public Node next;

        public Node(int data)
        {
            value = data;
        }
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data)
        {
            value = data;
        }
    }

    public static Node reverseLinkedList(Node head)
    {
        Node pre = null;
        Node next = null;

        /*
            a   ->      b   ->      c    ->  null
            -
           head
         */
        while(head != null)
        {
            // recording head.next to next
            /*
                a   ->      b   ->      c    ->  null
                -           -
               head        next

               - record the original head.next, since after we change head, we will lose the original head.next
            */
            next = head.next;

            // start reversing
            /*
                a   ->      b   ->      c    ->  null
                -           -
               head        next

               - update head, update head.next, point to prev; so now the list will become

                null(prev)  <-      a           b   ->      c    ->  null
                                    -           -
                                   head        next

               - update finished
            */
            head.next = pre;


            //  reset prev to the to old head location, reset head to the recorded next location
            /*
                null(prev)  <-      a           b   ->      c    ->  null
                                    -           -
                                   head        next

               - update finished, then we back to reset the pre pointer with head, and head pointer with next

                null  <-      a           b   ->      c    ->  null
                              -           -
                             prev        head
            */
            pre = head;
            head = next;
        }

        return pre;
    }


    public static DoubleNode reverseDoubleList(DoubleNode head)
    {

        DoubleNode pre = null;
        DoubleNode next = null;

        while(head != null)
        {
            // recording head.next to next
            /*
                null    <~   a   ->      b   ->      c    ->     null
                                 <~          <~
                                         -
                             -           -
                           head        next

               - record the original head.next, since after we change head, we will lose the original head.next
            */
            next = head.next;

            // start reversing
            /*
                null    <-    a           b   ->      c    ->     null
                                  ~>          <~
                  -                -
                              -           -
                 pre         head        next

               - head.next point to prev; head.last point to next; so now the list will become
            */

            head.next = pre;
            head.last = next;

            // reset locations
            /*
                null    <-    a           b   ->      c    ->     null
                                  ~>          <~

                              -           -
                             pre         head

               - update finished, then we back to reset the pre pointer with head, and head pointer with next
            */
            // reset prev the old head location, reset head to new head location/next

            pre = head;
            head = next;
        }

        return pre;
    }

    public static void printLinkedLike(Node head)
    {
//        Node temp = head;
//        only access next node, did not modify anything
        while(head != null)
        {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedLike(DoubleNode head) {

        int count = 0;

        while (head != null) {
//            System.out.print(head.value);
//            if (head.next != null) {
//                System.out.print(" <-> ");
//            }
            System.out.printf("%s%4s <~ %4d -> %4s","\t\t".repeat(count),(head.last == null ? "null" : head.last.value), head.value, (head.next == null ? "" : head.next.value));
//            System.out.println(
//                    "\t\t".repeat(count) + (head.last == null ? "null" : head.last.value) + "<~" + head.value + "->" + (head.next == null ? "" : head.next.value)
//            );
            if(head.next == null)
            {
                System.out.print("null");
            }
            System.out.println();
            head = head.next;
            count++;
        }

        System.out.println();
    }

//    public static void main(String [] args)
//    {
//        Node n1 = new Node(1);
//        n1.next = new Node(2);
//        n1.next.next = new Node(3);
//        printLinkedLike(n1);
//        n1 = reverseLinkedList(n1);
//        // ...
//        printLinkedLike(n1);
//        printLinkedLike(n1);
//
//        DoubleNode dn1 = new DoubleNode(1);
//        dn1.next = new DoubleNode(2);
//        dn1.next.next = new DoubleNode(3);
//        printDoubleLinkedLike(dn1);
//
//
//
//    }


    // for test
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        printLinkedLike(n1);
        n1 = reverseLinkedList(n1);
        // ...
        printLinkedLike(n1);
        printLinkedLike(n1);

        DoubleNode dn1 = new DoubleNode(1);
        DoubleNode dn2 = new DoubleNode(2);
        DoubleNode dn3 = new DoubleNode(3);

        dn1.next = dn2;
        dn2.next = dn3;
        dn2.last = dn1;
        dn3.last = dn2;
        printDoubleLinkedLike(dn1);
        dn1 = reverseDoubleList(dn1);
        printDoubleLinkedLike(dn1);


//        int len = 50;
//        int value = 100;
//        int testTime = 100000;
//        System.out.println("test begin!");
//        for (int i = 0; i < testTime; i++) {
//            Node node1 = generateRandomLinkedList(len, value);
//            List<Integer> list1 = getLinkedListOriginOrder(node1);
//            node1 = reverseLinkedList(node1);
//            if (!checkLinkedListReverse(list1, node1)) {
//                System.out.println("Oops1!");
//            }
//
//            Node node2 = generateRandomLinkedList(len, value);
//            List<Integer> list2 = getLinkedListOriginOrder(node2);
//            node2 = testReverseLinkedList(node2);
//            if (!checkLinkedListReverse(list2, node2)) {
//                System.out.println("Oops2!");
//            }
//
//            DoubleNode node3 = generateRandomDoubleList(len, value);
//            List<Integer> list3 = getDoubleListOriginOrder(node3);
//            node3 = reverseDoubleList(node3);
//            if (!checkDoubleListReverse(list3, node3)) {
//                System.out.println("Oops3!");
//            }
//
//            DoubleNode node4 = generateRandomDoubleList(len, value);
//            List<Integer> list4 = getDoubleListOriginOrder(node4);
//            node4 = reverseDoubleList(node4);
//            if (!checkDoubleListReverse(list4, node4)) {
//                System.out.println("Oops4!");
//            }
//
//        }
//        System.out.println("test finish!");
//
    }
}
