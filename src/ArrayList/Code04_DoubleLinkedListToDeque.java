package ArrayList;

import java.util.Deque;
import java.util.LinkedList;

public class Code04_DoubleLinkedListToDeque {

    public static class DoubleLinkedListNode<V> {
        public V value;
        public DoubleLinkedListNode<V> last;
        public DoubleLinkedListNode<V> next;

        public DoubleLinkedListNode(V v) {
            value = v;
            last = null;
            next = null;
        }
    }

    public static class MyDequeWithDoubleLinkedListNode<V> {
        private DoubleLinkedListNode<V> head;
        private DoubleLinkedListNode<V> tail;
        private int size;

        public MyDequeWithDoubleLinkedListNode() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void addFirst(V value) {
            DoubleLinkedListNode<V> cur = new DoubleLinkedListNode<>(value);
            if (head == null) {
                /*
                    null    <~   a      ->     null
                                 -
                              head/tail
                */
                head = cur;
                tail = cur;
            } else {

                // add the new node to the front, by, new node.next to head; head.prev to new node
                /*

                null    <~   b   ->
                                 null <~   a      ->     null
                                           -
                                        head/tail
                */
                cur.next = head;
                 /*

                null    <~   b   ->
                                 <~   a      ->     null
                                      -
                                   head/tail
                */
                head.last = cur;

                // reset location, put head to the new node
                /*

                null    <~   b   ->
                                 <~   a      ->     null
                             -        -
                            head     tail
                */
                head = cur;
            }
            size++;
        }

        public void addLast(V value) {
            DoubleLinkedListNode<V> cur = new DoubleLinkedListNode<>(value);
            if (head == null) {
                /*
                    null    <~   a      ->     null
                                 -
                              head/tail
                */
                head = cur;
                tail = cur;
            } else {
                // add the new node to the last, by, new node.next to head; cur.prev to new node
                /*


                        null <~     a      ->
                                                 null    <~   b   -> null
                                            -
                                  -
                                head/tail
                */
                tail.next = cur;
                // add the new node to the last, by, new node.next to head; cur.prev to new node
                /*


                        null <~     a      ->
                                           <~   b   -> null
                                            -
                                  -
                                head/tail
                */
                cur.last = tail;

                // reset tail location
                /*


                        null <~     a      ->
                                           <~   b   -> null
                                                -
                                    -           -
                                  head         tail
                */
                tail = cur;
            }
            size++;
        }

        public V pollFirst() {

            /*

                null    <~   b   ->
                                 <~   a      ->     null
                             -        -
                            head     tail
             */
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.value;

            /*
                    null    <~   a      ->     null
                                 -
                              head/tail
             */
            if (head == tail) {
                head = null;
                tail = null;

            }
            /*

                null    <~   b   ->
                                 <~   a      ->     null
                             -        -
                            head     tail
             */
            else {
                /*

                    null    <~   b   ->
                                     <~   a      ->     null
                                          -
                                      head/tail
                 */
                head = head.next;
                /*


                    null    <~   a      ->     null
                                 -
                              head/tail
                 */
                head.last = null;
            }
            return ans;
        }

        public V pollTail() {
            /*

                null    <~   b   ->
                                 <~   a      ->     null
                             -        -
                            head     tail
             */
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = tail.value;
             /*
                    null    <~   b   ->  null
                                - -
                             head tail
              */
            if (head == tail) {
                 /*
                          null
                           -
                        head/tail
                  */
                head = null;
                tail = null;
            } else {
                /*

                    null    <~   b   ->
                                     <~   a      ->     null
                                 - -
                              head tail
                */
                tail = tail.last;
                /*
                    null    <~   b   ->  null
                                - -
                             head tail
                */
                tail.next = null;
            }
            return ans;
        }

        public V peekFirst() {
            V ans = null;
            /*

                null    <~   b   ->
                                 <~   a      ->     null
                             -        -
                            head     tail
                */
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

        public V peekLast() {
            V ans = null;
            /*

                null    <~   b   ->
                                 <~   a      ->     null
                             -        -
                            head     tail
                */
            if (tail != null) {
                ans = tail.value;
            }
            return ans;
        }

    }

    public static void testDeque() {
        MyDequeWithDoubleLinkedListNode<Integer> myDeque = new MyDequeWithDoubleLinkedListNode<>();
        Deque<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myDeque.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myDeque.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                if (Math.random() < 0.5) {
                    myDeque.addFirst(num);
                    test.addFirst(num);
                } else {
                    myDeque.addLast(num);
                    test.addLast(num);
                }
            } else if (decide < 0.66) {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.pollFirst();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDeque.pollTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.peekFirst();
                        num2 = test.peekFirst();
                    } else {
                        num1 = myDeque.peekLast();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myDeque.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myDeque.isEmpty()) {
            int num1 = myDeque.pollFirst();
            int num2 = test.pollFirst();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        testDeque();
    }

}
