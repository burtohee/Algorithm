package _07_class07;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code06_PathSumII {

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




    public static List<Integer> listCopy(LinkedList<Integer> path)
    {
        List<Integer> ans = new ArrayList<>(path);

//        List<Integer> ans = new ArrayList<>();
//        ans.addAll(path);

//        for (Integer anInt: path)
//        {
//            ans.add(anInt);
//        }
        return ans;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        LinkedList<Integer> path = new LinkedList<>();
        processPathSum(root, targetSum, path, result);
        return result;
    }

    public static void processPathSum(TreeNode root, int rest, LinkedList<Integer> path, List<List<Integer>> ans)
    {
        if(root.left == null && root.right == null){
            if(root.val == rest)
            {
                path.add(root.val);
//                ans.add(listCopy(path));

                ans.add(new ArrayList<>(path));


//                ans.add(path);
//                path.remove(path.size() - 1);
                path.removeLast();
            }
            return;
        }


        path.add(root.val);
        if(root.left != null)
        {
            processPathSum(root.left, rest - root.val, path, ans);
        }
        if(root.right != null)
        {
            processPathSum(root.right, rest - root.val, path, ans);
        }
        path.removeLast();



    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);


        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        {
            return;
        }
        LinkedList<Integer> path = new LinkedList<>();
        int targetSum = 6;
        processPathSum(root, targetSum, path, result);
        System.out.println("===");
        Solution1.pathSum(root, targetSum);

    }


    static class Solution1 {
        static List<List<Integer>> result = new ArrayList();
        static int [] arr= new int[1000];
        public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result.clear();
            pathsumhelper( root, 0, targetSum);
            return result;
        }
        static void pathsumhelper(TreeNode root, int  i , int sum){
            if(root==null) return ;
            arr[i]=root.val;
            if(root.left==null && root.right==null){
                int sum2 =0;
                for(int j=0; j<=i; j++) sum2= sum2+arr[j];
                List<Integer> list = new ArrayList();
                if(sum2==sum){
                    for(int j=0; j<=i;j++) list.add(arr[j]);
                    result.add(list);
                }
            }
            pathsumhelper(root.left,i+1,sum);
            pathsumhelper(root.right,i+1,sum);
        }
    }

    class Solution2 {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            pathSum(root, targetSum, new ArrayList<Integer>(), res);
            return res;
        }

        public void pathSum(TreeNode root, int sum,List<Integer> sol, List<List<Integer>> res)
        {
            if(root == null) return;

            sol.add(root.val);

            if(root.left == null && root.right == null && root.val == sum)
            {
                res.add(new ArrayList<Integer>(sol));
            }
            else
            {
                pathSum(root.left, sum - root.val, sol, res);
                pathSum(root.right, sum - root.val, sol, res);
            }

            sol.remove(sol.size() - 1);
        }
    }


    class solution3{
        public static List<List<Integer>> pathSum(TreeNode root, int target)
        {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null)
            {
                return ans;
            }
            LinkedList<Integer> path = new LinkedList<>();
            process(root, target, path, ans);
            return ans;
        }
        public static List<Integer> listCopy(LinkedList<Integer> path)
        {
            List<Integer> ans = new ArrayList<>(path);

//        List<Integer> ans = new ArrayList<>();
//        ans.addAll(path);

//        for (Integer anInt: path)
//        {
//            ans.add(anInt);
//        }
            return ans;
        }

        public static void process(TreeNode root, int rest, LinkedList<Integer> path, List<List<Integer>> ans)
        {
            path.addLast(root.val);

            if(root.left == null && root.right == null)
            {
                if(root.val == rest)
                {
                    ans.add(listCopy(path));
                }
            }

            path.add(root.val);
            if(root.left != null)
            {
                processPathSum(root.left, rest - root.val, path, ans);
            }
            if(root.right != null)
            {
                processPathSum(root.right, rest - root.val, path, ans);
            }
            path.removeLast();



        }
    }


}


