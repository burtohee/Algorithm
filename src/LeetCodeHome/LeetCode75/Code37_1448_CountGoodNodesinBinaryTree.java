package LeetCodeHome.LeetCode75;

public class Code37_1448_CountGoodNodesinBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public int dfs(TreeNode root, int max, int count)
        {
            if(root.left != null) {
                count = dfs(root.left, Math.max(max, root.val), count);
            }
            if(root.right != null) {
                count = dfs(root.right, Math.max(max, root.val), count);
            }
            if(root.val >= max)
            {
                count++;
            }
            return count;

        }
        public int goodNodes(TreeNode root) {
            if(root == null)
            {
                return 0;
            }
            int max = root.val;
            int count = 1;
            count = dfs(root, max, count) - 1;
            return count;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    // 1. what we need? for each node, it need value and max_value,
    // 2. subproblem? for each subtree, the number should be left + right + 1?
    // time complexity is O(n), n is node number,
    class Solution1 {
        public int goodNodes(TreeNode root) {
            // 需要写一个别的函数
            return preorderDfs(root,Integer.MIN_VALUE);
        }
        public int preorderDfs(TreeNode root, int max){
            if(root == null) {return 0;}
            // if(root.val >= max) {max = root.val;}
            // if try preorder Dfs
            //int cur = (max > root.val)? 0:1;
            int left_num = preorderDfs(root.left,Math.max(max,root.val));
            int cur = (max > root.val)? 0:1;
            int right_num = preorderDfs(root.right,Math.max(max,root.val));

            return left_num +  right_num + cur;

        }

    }


    class solution2 {

        public int dfs(TreeNode root, int max)
        {
            if(root == null)
                return 0;

            int lCount = dfs(root.left, Math.max(max, root.val));
            int cur = (max > root.val)? 0:1;
            int rCount = dfs(root.left, Math.max(max, root.val));



            return lCount + rCount + cur;

        }
        public int goodNodes(TreeNode root) {
            return dfs(root, Integer.MIN_VALUE);
        }
    }





    static class SolutionMain {

        public int dfs(TreeNode root, int max, int count)
        {
            if(root.left != null) {
                count = dfs(root.left, Math.max(max, root.val), count);
            }
            if(root.right != null) {
                count = dfs(root.right, Math.max(max, root.val), count);
            }
            if(root.val >= max)
            {
                count++;
            }
            return count;

        }
        public int goodNodes(TreeNode root) {
            if(root == null)
            {
                return 0;
            }
            int max = root.val;
            int count = 1;
            count = dfs(root, max, count) - 1;
            return count;
        }
    }

    public static void main(String [] args)
    {
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(1);
        treeNode1.left.left = new TreeNode(3);


        treeNode1.right = new TreeNode(4);
        treeNode1.right.left = new TreeNode(1);
        treeNode1.right.right = new TreeNode(5);



        SolutionMain solutionMain = new SolutionMain();
        int result = solutionMain.goodNodes(treeNode1);
        System.out.println(result);
    }

    
}
