package Trees;

/*
    Problem Link : https://leetcode.com/problems/deepest-leaves-sum/
    Solution Link : https://leetcode.com/submissions/detail/294745774/
*/

import Utils.TreeNode;

public class DeepestLeavesSum {
    static class Solution {
        int maxLevel = -1, sum = 0;
        public int deepestLeavesSum(TreeNode root) {
            helper(root, 0);
            return sum;
        }

        private void helper(TreeNode root, int level) {
            if(root == null) return;
            sum = (level == maxLevel) ? (sum + root.val) : (level > maxLevel) ? root.val : sum;
            maxLevel = (maxLevel < level) ? level : maxLevel;
            helper(root.left, level + 1);
            helper(root.right, level + 1);
        }
    }

    public static void main(String argsp[]) {

    }
}
