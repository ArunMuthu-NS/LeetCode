package Trees;

import Utils.TreeNode;

public class LeetCode1372 {
    class Solution {
        int max = 0;
        public int longestZigZag(TreeNode root) {
            visit(root);
            return max;
        }

        public int[] visit(TreeNode root) {
            if(root != null) {
                int[] left = visit(root.left);
                int[] right = visit(root.right);
                int[] curr = new int[2];

                curr[0] = 1 + left[1];
                curr[1] = 1 + right[0];

                max = Math.max(curr[0], max);
                max = Math.max(curr[1], max);

                return curr;
            }
            return new int[]{-1, -1};
        }
    }

    public static void main(String args[]) {

    }
}
