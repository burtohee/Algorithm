package algorithm_1_starter._06_class06;


// 测试链接：https://leetcode.com/problems/same-tree

public class Code04_SameTree {


    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSameTree(TreeNode tree1, TreeNode tree2)
    {
        if( (tree1 == null) ^ (tree2 == null))
        {
            return false;
        }

//        if((tree1 == null) && (tree2 == null))
        if(tree1 == null)
        {
            return true;
        }

        // tree1 and tree2 are not null
        return tree1.val == tree2.val && isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);

    }
}
