package _07_class07;

// 测试链接：https://leetcode.com/problems/balanced-binary-tree
public class Code02_BalancedBinaryTree {

    // question 1: if it is balanced tree (every subtree is |height of left subtree - height of right subtree| <= 1)
    /*
                          n1
                n2                   n3
            n4      n5           n6      n7
                              n8
     */
    // question 2: if it is search tree
    // question 3: if it is balanced search tree

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // for a node, return info 1) if whole tree is balanced 2) what if the height of the tree
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public static Info process(TreeNode curTreeNode) {
        // empty tree
        if (curTreeNode == null) {
            return new Info(true, 0);
        }

        // root != null

        // get tree information at left subtree
        Info leftInfo = process(curTreeNode.left);
        // get tree information at right subtree
        // and we have 4 info now
        Info rightInfo = process(curTreeNode.right);

        // get the height of current node
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        // and we check/get the status/info of current node, if current node is balanced only when 3 condition meet, 1) left is balanced 2) right is balanced 3) on current node, difference of left,right subtree is < 2
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;

        // update the current node info
        return new Info(isBalanced, height);
    }

}
