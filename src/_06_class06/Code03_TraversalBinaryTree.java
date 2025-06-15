package _06_class06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code03_TraversalBinaryTree {

    /*
                   1
             2          3
          4    5      6   7
     */
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void visitBasic(Node cur)
    {
        System.out.println(cur.value);
    }

    public static List<Node> visitList(List<Node> res, Node cur)
    {
//        System.out.println(cur.value);
        res.add(cur);
        return res;
    }

    public static void printList(List<Node> res)
    {
        for (Node anNode: res)
        {
            System.out.println(anNode.value);
        }
    }


    public static void BFS(Node root)
    {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<Node> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();

//            visitBasic(current);
            visitList(res, current);


            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        printList(res);
    }

    // Iterative method to perform level order traversal

        public static List<List<Integer>> levelOrder(Node root) {
            if (root == null)
                return new ArrayList<>();

            // Create an empty queue for level order traversal
            Queue<Node> q = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();

            // Enqueue Root
            q.offer(root);
            int currLevel = 0;

            while (!q.isEmpty()) {
                int len = q.size();
                res.add(new ArrayList<>());

                for (int i = 0; i < len; i++) {
                    // Add front of queue and remove it from queue
                    Node node = q.poll();
                    res.get(currLevel).add(node.value);

                    // Enqueue left child
                    if (node.left != null)
                        q.offer(node.left);

                    // Enqueue right child
                    if (node.right != null)
                        q.offer(node.right);
                }
                currLevel++;
            }
            return res;
        }

        /*
                     1 2 4 4 4 2 5 5 5 2 1 3 6 6 6 3 7 7 7 3 1
             pre :   - - - x x x - x x x x - - x x x - x x x x
             in  :   x x x - x - x - x x - x x - x - x - x x x
             post:   x x x x - x x x - - x x x x - x x x - - -
         */
        public static void f(Node head) {
            if (head == null) {
                return;
            }
            // 1
            f(head.left);
            // 2
            f(head.right);
            // 3
        }


    /*
                   1
             2          3
          4    5      6   7
     */

    /*
            head, left, right (every node obey the rule);
            Preorder traversal is a tree traversal method that follows the Root-Left-Right order:
            Visit Root ➝ Traverse Left ➝ Traverse Right;
            DFS
     */

    /*
          1,   2, 4,5,            3, 6, 7
     */

    // 先序打印所有节点
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }


    /*
                   1
             2          3
          4    5      6   7
     */

    /*
            left, head, right (every node obey the rule);
            Inorder traversal is a depth-first traversal method that follows this sequence:
            Traverse Left ➝ Visit Root ➝ Traverse Right
            DFS

     */

    /*
          4,2,5,  1,    6,3,7
     */
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }



    /*
                   1
             2          3
          4    5      6   7
     */

    /*
            left, right, root (every node obey the rule);
            Postorder traversal is a tree traversal method that follows the Left-Right-Root order:
            Traverse Left ➝ Traverse Right ➝ Visit Root
            DFS

     */

    /*
          4,5,2  ,6,7,3    , 1
     */

    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos(head);
        System.out.println("========");
        BFS(head);
        System.out.println("========");

        // Perform level order traversal and get the result
        List<List<Integer>> res = levelOrder(head);

        // Print the result in the required format
        for (List<Integer> level : res) {
            System.out.print("[");
            for (int i = 0; i < level.size(); i++) {
                System.out.print(level.get(i));
                if (i < level.size() - 1) System.out.print(", ");
            }
            System.out.print("] ");
        }

    }


}
