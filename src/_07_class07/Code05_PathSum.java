package _07_class07;

import com.sun.source.tree.Tree;

public class Code05_PathSum {

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

    public static boolean hasPathSum(TreeNode root, int sum)
    {
        if(root == null)
        {
            return false;
        }
        return processPathSumRecursive(root, sum);
    }

    public static boolean processPathSumRecursive(TreeNode root, int rest)
    {
        if(root.left == null && root.right == null)
        {
            return root.val == rest;
        }


//        boolean ans = false;
//        if (root.left != null) {
//            ans = ans || processPathSumRecursive(root.left, rest - root.val);
//        }
//        if (root.right != null) {
//            ans = ans || processPathSumRecursive(root.right, rest - root.val);
//        }
//
//        return ans;


        return (root.left != null && processPathSumRecursive(root.left, rest - root.val)) ||
                (root.right != null && processPathSumRecursive(root.right, rest - root.val));
    }
    //        ans = root.left != null? processPathSumRecursive(root.left, rest - root.val) : false;
    //        ans = root.left != null && processPathSumRecursive(root.left, rest - root.val);
    //
    //        ans = root.right != null? processPathSumRecursive(root.right, rest - root.val): false;
    //
    //        return ans;
    //    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22)); // Output: true
    }

}