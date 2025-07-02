package _07_class07;

import java.util.ArrayList;
import java.util.List;

public class Code04_BalencedBinarySearchTree {

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

    // isBST method 2
    public static class InfoValidBST {
        public boolean isBST;
        public int minOfTree;
        public int maxOfTree;

        public InfoValidBST(boolean isBST, int minOfTree, int maxOfTree){
            this.isBST = isBST;
            this.minOfTree = minOfTree;
            this.maxOfTree = maxOfTree;
        }
    }

    public static InfoValidBST processValidBST(TreeNode currentNode)
    {
        if(currentNode == null)
        {
            return null;
        }

        InfoValidBST leftInfo = processValidBST(currentNode.left);
        InfoValidBST rightInfo = processValidBST(currentNode.right);

        int min = currentNode.val;
        int max = currentNode.val;

        if(leftInfo != null)
        {
            max = Math.max(leftInfo.maxOfTree, max);
            min = Math.min(leftInfo.minOfTree, min);
        }
        if(rightInfo != null)
        {
            max = Math.max(rightInfo.maxOfTree, max);
            min = Math.min(rightInfo.minOfTree, min);
        }

        boolean isBST = false;
        boolean leftIsBST =  leftInfo == null || leftInfo.isBST;
        boolean rightIsBST =  rightInfo == null || rightInfo.isBST;

        boolean leftMaxLessCur = leftInfo == null || leftInfo.maxOfTree < currentNode.val;
        boolean rightMinLargerX = rightInfo == null || rightInfo.minOfTree > currentNode.val;

        if(leftIsBST && rightIsBST && leftMaxLessCur && rightMinLargerX)
        {
            isBST = true;
        }

        return new InfoValidBST(isBST, min, max);
    }

    public boolean isValidBST(TreeNode root) {
        return processValidBST(root).isBST;
    }

    // isBST method 1
    public static void visitNode(List<Integer> res, TreeNode node)
    {
        res.add(node.val);
    }


    public static void inTravelTree(TreeNode currentNode, List<Integer> result)
    {

        if(currentNode == null)
        {
            return;
        }
        inTravelTree(currentNode.left, result);
        visitNode(result, currentNode);
        inTravelTree(currentNode.right, result);

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

    // method for balanced BST
    public static class InfoBalencedBST {
        public boolean isBalanced;
        public int height;

        public InfoBalencedBST(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public static InfoBalencedBST processBalencedBST(TreeNode curTreeNode) {

        if(curTreeNode == null)
        {
            return new InfoBalencedBST(true, 0);
        }

        InfoBalencedBST leftInfo = processBalencedBST(curTreeNode.left);
        InfoBalencedBST rightInfo = processBalencedBST(curTreeNode.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;

        return new InfoBalencedBST(isBalanced, height);
    }

    public boolean isBalancedBST(TreeNode root)
    {
        return processBalencedBST(root).isBalanced;
    }

    public static boolean processValidBalancedBST(TreeNode root)
    {
        return processValidBST(root).isBST && processBalencedBST(root).isBalanced;
    }

    public boolean isValidBalancedBST(TreeNode root)
    {
        return processValidBST(root).isBST && processBalencedBST(root).isBalanced;
    }


    public static void main (String [] args)
    {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

//        TreeNode head = new TreeNode(5);
//        head.left = new TreeNode(3);
//        head.right = new TreeNode(6);
//        head.left.left = new TreeNode(1);
//        head.left.right = new TreeNode(4);
////        head.right.left = new TreeNode();
//        head.right.right = new TreeNode(8);

        System.out.println("===========");
        List<Integer> result = new ArrayList<>();
        inTravelTree(head, result);
        int[] result1 = result.stream().mapToInt(i -> i).toArray();
        System.out.println(isBSTWithArray(result1));

        System.out.println("===========Valid BST:");
        System.out.println(processValidBST(head).isBST);
        System.out.println("===========Balanced BST:");
        System.out.println(processBalencedBST(head).isBalanced);
        System.out.println("=========== Valid Balenced BST:");
        System.out.println(processValidBalancedBST(head));
        System.out.println("===========");
    }



}
