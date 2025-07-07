package algorithm_1_starter._06_class06;


// 测试链接：https://leetcode.com/problems/symmetric-tree

public class Code05_SymmetricTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }


    /*
               root
          left     right
     */


    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }


    /*
                              root
                (left1)                  (right1)
                  X                         X`
           (left3) (right2)       (left2)     (right3)
              Z       Y              Y`           Z`
     */
    public static boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null ^ tree2 == null) {
            return false;
        }
        if (tree1 == null && tree2 == null) {
            return true;
        }
        return tree1.val == tree2.val && isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
    }

}
