package algorithm_1_starter._06_class06;

import java.util.HashMap;

//测试链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

public class Code07_ConstructBinaryTreeFromPreorderAndInorderTraversal {



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    // initial function
    public static TreeNode buildTree1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
    // 请建出整棵树返回头节点
    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {

        // condition for valida range for Left to right in a tree, if not in a valid range, we return a null tree
        // e.g.
        /*
                          1
                  null            2
                             null    3

                pre: [1,2,3]
                in:  [1,2,3]
         */

        /*
                          1
                   2            null
             null    3

                pre: [1,2,3]
                in:  [2,3,1]

                head.left : f(pre, 1, 2, in, 0 ,1)
                head.right: f(pre, 3, 2, in, 3, 2 )
         */
        // purpose: return null when L1 is on the right of R1, out of valid range, nothing on the left/right
        if (L1 > R1) {
            return null;
        }

        // we need to set the root of the whole tree, which is the 0 index of pre
        TreeNode head = new TreeNode(pre[L1]);

        // condition for only 1 number in the tree e.g. pre only has [6], in only has [6], then we just return it as head
        if (L1 == R1) {
            return head;
//            return new TreeNode(pre[L1]);
        }

        /*
                pre: [head, ..........]
                      L1.............R1

                in: [left(....)  ,head?, (...)right]
                      L2..........find..........R2

         */
        int find = L2;

//        for(;in[find] != pre[L1];find++);
        while (in[find] != pre[L1]) {
            find++;
        }

        /*
                pre: [head, ..........]
                      L1.............R1

                in: [left(....)  ,head?, (...)right]
                      L2..........find..........R2

        =========================================================================

                pre: [head,                                           ..........]
                      L1, (L1+1)......(L1+find-L2),       (L1+find-L2+1).......R1

                in: [left(....)  ,         , head?,         (...)right]
                      L2......(find-1)     , find ,        (find+1)........R2

                head: L1
                find: find
                range: L1+find-L2

                pre_head.left : (L1+1)......(L1+find-L2)
                pre_head.right: (L1+find-L2)......(R1)

                in_head.left : L2...(find-1)
                in_head.right: (find+1)....R2
         */

        /*
                5      6 7 8                                   9           10
                L1                                                         R1
                    (  left: L1+1....L1+find-L2 )           (  right: L1+find-L2+1.....R1)

                13   14 15                  16                        17    18
                L2                         find                             R2
              ( left: L2....(find-1) )                      ( right: (find+1).....R2 )

         */

        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);


        return head;
    }







    // exchange spaces for time
    public static TreeNode buildTree2(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();

        // record every node in the "in" array
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }

        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
    // 请建出整棵树返回头节点

    // O(N) N nodes
    public static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2,
                             HashMap<Integer, Integer> valueIndexMap) {


        // O(1)
        if (L1 > R1) {
            return null;
        }
        // O(1)
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }




        // use map to find the find in the index map
        int find = valueIndexMap.get(pre[L1]);
//        int find = L2;
//
////        for(;in[find] != pre[L1];find++);
//        while (in[find] != pre[L1]) {
//            find++;
//        }



        // O(1)
        head.left = g(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueIndexMap);
        head.right = g(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueIndexMap);
        return head;
    }


}
