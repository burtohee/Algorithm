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

    public static void printStack(Stack<Integer> res)
    {
        for(int i =0; i< res.size(); i++)
        {
            System.out.println(res.get(i) + " ");
        }
        System.out.println(" ---- " + " ");

//        for (Integer anInt : res)
//        {
//            System.out.println(anInt + " ");
//        }
//        System.out.println(" ---- " + " ");

    }

    public static void printLinkedList(List<Integer> res)
    {

            for (Integer anInt : res)
            {
                System.out.println(anInt + " ");
            }
            System.out.println(" ---- " + " ");

    }

    public static void printDoubleLinkedList(List<List<Integer>> res)
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
//        List<List<Integer>> ans2 = new ArrayList<>();
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

//            ans2.add(curAns);

        }
//        Collections.swap(ans2, 0, ans2.size() - 1);
//        swapArrayList(ans2);
//        printList(ans2);
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


        int testTime = 1000000;
//        testTime = 100000;
        long start;
        long end;

        ArrayList<Integer> arr1 = new ArrayList<>();
        start = System.currentTimeMillis();
        for(int i =0; i < testTime; i++)
        {
            arr1.add(0,i);
        }
        end = System.currentTimeMillis();
        System.out.println("\nTime used for arraylist: " + (end - start));

        LinkedList<Integer> arr2 = new LinkedList<>();
        start = System.currentTimeMillis();
        for(int i =0; i < testTime; i++)
        {
            arr2.add(0,i);
        }
        end = System.currentTimeMillis();
        System.out.println("Time used for LinkedList: " + (end - start));


        // slow in java, linked list is better.
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(1);
        stack.add(8);
        stack.add(9);
        printStack(stack);

        Integer stackresult = stack.pop();
        System.out.println("========");
        System.out.println(stackresult);
        System.out.println("========");

        start = System.currentTimeMillis();
        for(int i =0; i < testTime; i++)
        {
            stack.add(i);
        }
        while(!stack.isEmpty())
        {
            stack.pop();
        }
        end = System.currentTimeMillis();
        System.out.println("Time used for Stack: " + (end - start));


        int[] stack2WithArray = new int[testTime];
        start = System.currentTimeMillis();
        int stack2WithArrayIndex = 0;
        for(int i =0; i < testTime; i++)
        {
            stack2WithArray[stack2WithArrayIndex++] = i;
        }
        while(stack2WithArrayIndex != 0)
        {
           int a = stack2WithArray[--stack2WithArrayIndex];
        }
        end = System.currentTimeMillis();
        System.out.println("Time used for ArrayAsStack: " + (end - start));

        arr1 = new ArrayList<>();
        start = System.currentTimeMillis();
        for(int i =0; i < testTime; i++)
        {
            arr1.addLast(i);
        }
        while(!arr1.isEmpty())
        {
            int a = arr1.removeLast();
        }
        end = System.currentTimeMillis();
        System.out.println("Time used for ArrayListAsStack: " + (end - start));




        LinkedList<Integer> stackInLikedList = new LinkedList<>();
        stackInLikedList.add(1);
//        stackInLikedList.addLast(1);
        stackInLikedList.add(2);
        stackInLikedList.add(0);
        stackInLikedList.add(5);
        stackInLikedList.addLast(5);
        stackInLikedList.add(2);
        printLinkedList(stackInLikedList);
        Integer stackInLikedListresult1 = stackInLikedList.pollLast();
        System.out.println("========");
        System.out.println(stackInLikedListresult1);
        System.out.println("========");
        printLinkedList(stackInLikedList);
        while(!stackInLikedList.isEmpty())
        {
            System.out.println(stackInLikedList.pollLast());
        }


        // or we can use array, if we know the length of the inputs
        int stackArrayLength = 100;
        int index = 0;
        int[] stacksArray = new int[stackArrayLength];
        stacksArray[index++] = 1;
        stacksArray[index++] = 3;
        stacksArray[index++] = 8;
        stacksArray[index++] = 2;

        System.out.println("========");
        System.out.println(stacksArray[--index]);
        System.out.println("========");
        System.out.println("========");
        System.out.println(stacksArray[--index]);
        System.out.println("========");
        System.out.println("========");
        System.out.println(stacksArray[--index]);
        System.out.println("========");



    }


}