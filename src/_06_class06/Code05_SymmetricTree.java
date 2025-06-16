package _06_class06;


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
    public static boolean isMirror(TreeNode h1, TreeNode h2) {
        if (h1 == null ^ h2 == null) {
            return false;
        }
        if (h1 == null && h2 == null) {
            return true;
        }
        return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
    }

}
