package _06_class06;


// 测试链接：https://leetcode.com/problems/same-tree

public class Code04_SameTree {


    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q)
    {
        if( (p == null) ^ (q == null))
        {
            return false;
        }

//        if((p == null) && (q == null))
        if(p == null)
        {
            return true;
        }

        // p and q are not null
        return p.val == q.val && isSameTree(p.left, p.left) && isSameTree(p.right, p.right);

    }
}
