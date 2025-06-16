package _06_class06;


// 测试链接：https://leetcode.com/problems/maximum-depth-of-binary-tree


public class Code06_MaximumDepthOfBinaryTree {


    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // start after root, max depth equals to maxDepth() + 1
    public static int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }





}
