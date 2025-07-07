package others_1_ds_sorting.ArrayList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code02_LinkedListToQueueAndStack {
    public static class Node<V>{
        public V value;
        public Node<V> next;

        public Node(V v)
        {
            value = v;
        }
    }

    public static class MyQueue<V>
    {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue()
        {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty()
        {
            return size ==0;
        }

        public int size()
        {
            return size;
        }

        public void offer (V value)
        {
            Node<V> cur = new Node<>(value);
            /*
                    null
                 head/tail
             */
            if(tail == null)
            {

                /*
                          a       ->  null
                      head/tail
                */
                head = cur;
                tail = cur;
            }
            else
            {
                /*
                       a     ->     b    -> null
                     head          tail
                */
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public V poll()
        {
            V ans = null;

            if(head != null)
            {
                /*
                       a     ->     b       -> null
                     head          tail

                     and = head.value: a
                */
                ans = head.value;
                /*
                       a     ->     b    ->     null
                                   head
                                   tail
                */
                head = head.next;
                size--;
                /*
                       b    ->      null
                      head
                      tail
                */
            }

            // if above peek, after dequeue the last node, the head will become null, then we reset the tail position
            /*
                       b    -\>      null
                                     head
                      tail
            */
            // check if queue is empty, after dequeue, if yes, reset tail to head/tail
            if(head == null)
            {
                // if above peek, after dequeue the last node, the head will become null, then we reset the tail position
                /*
                           b    -\>      null
                                         head
                          tail
                */
                tail = null;
                /*
                                         null
                                         head
                                         tail
                */
                // so it become empty set
            }
            return ans;
        }

        public V peek()
        {
            V ans = null;
            if(head != null)
            {
                return head.value;
            }
            return ans;
        }

    }

    public static class MyStack<V>
    {
        private Node<V> head;
        private int size;

        public MyStack()
        {
            head = null;
            size = 0;
        }

        public boolean isEmpty()
        {
            return size ==0;
        }

        public int size()
        {
            return size;
        }

        public void push (V value)
        {
            Node<V> cur = new Node<>(value);
            /*
                null
                head
             */
            if(head == null)
            {

                /*
                          a       ->  null
                        head
                */
                head = cur;
            }
            else
            {
                /*
                       b     ->     a    -> null
                                 ---------------(previous head)
                */
                cur.next = head;
                /*
                       b     ->     a    -> null
                     head         ---------------(previous head)
                */
                head = cur;
            }
            size++;
        }

        public V pop()
        {
            V ans = null;

            if(head != null)
            {
                /*
                       b     ->     a    -> null
                     head
                */
                ans = head.value;
                /*
                       a     ->     b    ->     null
                                   head
                */
                head = head.next;
                size--;
                /*
                       b    ->      null
                      head
                */
            }

            // if above peek, after pop the last node, the head will become null, then we do nothing, just return null value
            /*
                       b    -\>      null
                                     head
            */
//            if(head == null)
//            {
//                // if above peek, after pop the last node, the head will become null, then we do nothing, just return null value
//                /*
//                           b    -\>      null
//                                         head
//                */
//            }
            return ans;
        }

        public V peek()
        {
           return head != null? head.value: null;
        }

    }





    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myQueue.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.offer(num);
                test.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.poll();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myQueue.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myQueue.isEmpty()) {
            int num1 = myQueue.poll();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myStack.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myStack.push(num);
                test.push(num);
            } else if (decide < 0.66) {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.pop();
                    int num2 = test.pop();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myStack.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myStack.isEmpty()) {
            int num1 = myStack.pop();
            int num2 = test.pop();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        testQueue();
        testStack();
    }

}

