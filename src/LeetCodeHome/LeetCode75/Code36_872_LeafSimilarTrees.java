package LeetCodeHome.LeetCode75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Code36_872_LeafSimilarTrees {

    public class TreeNode {
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
    class Solution {
        public void collectLeaves(TreeNode root, List<Integer> list)
        {
            if(root == null)
            {
                return;
            }
            if(root.left == null && root.right == null)
            {
                 list.add(root.val);
            }
            if(root.left != null)
            {
                collectLeaves(root.left, list);
            }
            if(root.right != null)
            {
                collectLeaves(root.right, list);
            }
        }
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            // Collect leaf values from the first tree
            List<Integer> leafValues1 = new ArrayList<>();
            // Collect leaf values from the second tree
            List<Integer> leafValues2 = new ArrayList<>();

            // Perform depth-first search to collect leaves from both trees
            collectLeaves(root1, leafValues1);
            collectLeaves(root2, leafValues2);

            // Compare the two leaf value sequences
            return leafValues1.equals(leafValues2);
        }
    }


}
