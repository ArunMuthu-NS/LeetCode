package Trees;

import Utils.TreeNode;
import Utils.TreeUtil;

public class MaximumProductOfSplittedBinaryTree {
    static class Solution {
        long max, sum;
        int mod = (int) 1e9 + 7;
        public int maxProduct(TreeNode root) {
            max = sum = 0;
            findSum(root);
            findMaxProduct(root);
            return (int)(max % mod);
        }

        public long findMaxProduct(TreeNode root) {
            if(root != null){
                long left = findMaxProduct(root.left);
                long right = findMaxProduct(root.right);
                max = Math.max(max, Math.max(left * (sum - left), right * (sum - right)));
                return (root.val + left + right);
            }
            return 0;
        }

        public void findSum(TreeNode root) {
            if(root != null){
                sum += root.val;
                findSum(root.left);
                findSum(root.right);
            }
        }
    }

    public static void main(String args[]) {
        TreeNode root = TreeUtil.constructTree(new Integer[]{ 2,3,9,10,7,8,6,5,4,11,1 }, 0);
        System.out.println(new Solution().maxProduct(root));
    }
}
