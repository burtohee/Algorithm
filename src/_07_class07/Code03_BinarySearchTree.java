package _07_class07;


// https://leetcode.com/problems/validate-binary-search-tree/description/

import java.util.ArrayList;
import java.util.List;

public class Code03_BinarySearchTree {

    public static class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
            left = null;
            right = null;
        }

    }

    // method 1: retrieve in order through tree, and if the result is ASEC sort, then the tree is binary search tree
    /*
                                   5
                       3                         6
                1             4           null         8
           null    2    null    null                7      9

           in: 1 2 3 4 5 6 7 8 9
     */
    public static void visitNode(List<Integer> res, TreeNode node)
    {
//        ArrayList<Integer> result = new ArrayList<>();
        res.add(node.val);
//        return res;
    }


    public static void inTravelTree(TreeNode currentNode, List<Integer> result)
    {
//        List<Integer> result = new ArrayList<>();
        if(currentNode == null)
        {
            return;
        }
        inTravelTree(currentNode.left, result);
        visitNode(result, currentNode);
        inTravelTree(currentNode.right, result);

//        return result.toArray();
//        return result.stream().mapToInt(i -> i).toArray();
    }

    public static boolean isBSTWithArray(int[] res)
    {
        if(res == null)
        {
            return true;
        }

        int max = res[0];

        for(Integer anInt: res)
        {
            if(max > anInt)
            {
                return false;
            }
            max = anInt;
        }

        return true;
    }




    // method 2: given a tree node, we check if  1) left and 2) right subtree is binary search tree, and 3) left node(max of left tree) is < current node; 4) right node(min of right tree) > current node
    /*
                                   5
                       3                         6
                1             4           null         8
           null    2    null    null                7      9

     */
    public static class Info {
        public boolean isBST;
        public int minOfTree;
        public int maxOfTree;

        public Info(boolean isBST, int minOfTree, int maxOfTree){
            this.isBST = isBST;
            this.minOfTree = minOfTree;
            this.maxOfTree = maxOfTree;
        }
    }


//    public static Info process1(TreeNode x) {
//		if (x == null) {
//			return null;
//		}
//		Info leftInfo = process1(x.left);
//		Info rightInfo = process1(x.right);
//		int max = x.val;
//		int min = x.val;
//		if (leftInfo != null) {
//			max = Math.max(leftInfo.maxOfTree, max);
//			min = Math.min(leftInfo.minOfTree, min);
//		}
//		if (rightInfo != null) {
//			max = Math.max(rightInfo.maxOfTree, max);
//			min = Math.min(rightInfo.minOfTree, min);
//		}
//		boolean isBST = true;
//		if (leftInfo != null && !leftInfo.isBST) {
//			isBST = false;
//		}
//		if (rightInfo != null && !rightInfo.isBST) {
//			isBST = false;
//		}
//        // left max < x ; right min > x
//		boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.maxOfTree < x.val);
//		boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.minOfTree > x.val);
//		if (!(leftMaxLessX && rightMinMoreX)) {
//			isBST = false;
//		}
//		return new Info(isBST, max, min);
//	}


    public static Info process(TreeNode currentNode)
    {
        if(currentNode == null)
        {
//            return new Info(true, 0,0); // wrong way to do it, even Integer.MIN_VALUE, we should use null
            return null;
        }

        // currentNode is not empty
        Info leftInfo = process(currentNode.left);
        Info rightInfo = process(currentNode.right);

        // right now, we think we have the most max, min value
        int min = currentNode.val;
        int max = currentNode.val;

        // if left right tree info is not null(empty), we need to figure out if
        /*
                                       6
                           7                         2
                    6             4             9          3

               , AT currentNode(6, the top one); left tree has min:4 max: 7; right tree has,
               , max->7, min -> 4 on the left, max->9, min -> 2 on the right, then we will have min:2,max:9 for currentNode(6, the top one)
               after two if statement, we will for sure get the correct min,max value for currentNode(6, the top one)

         */
        if (leftInfo != null) {
            // if the left tree have smaller max, then we use it
            min = Math.min(leftInfo.minOfTree, min);
            // if the left tree have larger max, then we use it
            max = Math.max(leftInfo.maxOfTree, max);
        }
        if (rightInfo != null) {
            min = Math.min(rightInfo.minOfTree, min);
            max = Math.max(rightInfo.maxOfTree, max);
        }
        // after two if, we for sure have the correct min, and max, these two steps does not relate to later check if BST

        // isBST status
        boolean isBST = false;
        // isBST status check
//        boolean leftIsBst = leftInfo == null ? true : leftInfo.isBST;
        boolean leftIsBST = leftInfo == null || leftInfo.isBST;
        boolean rightIsBST = rightInfo == null || rightInfo.isBST;

        boolean leftMaxLessX = leftInfo == null || (leftInfo.maxOfTree < currentNode.val);
//        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.maxOfTree < currentNode.val);
        boolean rightMinLargerX = rightInfo == null || (rightInfo.minOfTree > currentNode.val);

        if (leftIsBST && rightIsBST && leftMaxLessX && rightMinLargerX) {
            isBST = true;
        }


        return new Info(isBST, max, min);
    }

    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }


    public static void main (String [] args)
    {
//        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
//        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);

        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(4);
//        head.right.left = new TreeNode();
        head.right.right = new TreeNode(8);

        List<Integer> result = new ArrayList<>();
        inTravelTree(head, result);
        int[] result1 = result.stream().mapToInt(i -> i).toArray();
        System.out.println(isBSTWithArray(result1));
    }

}
