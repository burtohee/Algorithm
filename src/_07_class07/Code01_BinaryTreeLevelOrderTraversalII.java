package _07_class07;

import java.util.*;

// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii


public class Code01_BinaryTreeLevelOrderTraversalII {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void printList(List<List<Integer>> res)
    {
        for (List<Integer> re: res)
        {
            for (Integer anInt : re)
            {
                System.out.println(anInt + " ");
            }
            System.out.println(" ---- " + " ");
        }
    }

    public static void swapArrayList(List<List<Integer>> arr)
    {
        int left = 0, right = arr.size() - 1;
        while (left < right) {

            List<Integer> temp = arr.get(left);

            arr.set(left, arr.get(right));
            arr.set(right, temp);

            left++;
            right--;
        }
//        return arr;
    }


    public static  List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans2 = new ArrayList<>();
        List<List<Integer>> ans = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> curAns = new LinkedList<>();


            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curAns.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            ans.addFirst(curAns);
//            ans.add(0, curAns);

            ans2.add(curAns);

        }
//        Collections.swap(ans2, 0, ans2.size() - 1);
        swapArrayList(ans2);
        printList(ans2);
        return ans;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

//        pre(head);
//        System.out.println("========");
//        in(head);
//        System.out.println("========");
//        pos(head);
//        System.out.println("========");
//        BFS(head);
//        System.out.println("========");

        // Perform level order traversal and get the result
        List<List<Integer>> res = levelOrderBottom(head);

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