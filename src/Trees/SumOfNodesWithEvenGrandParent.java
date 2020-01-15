package Trees;

import Utils.TreeNode;

public class SumOfNodesWithEvenGrandParent {
    static class Solution {
        int count = 0;
        public int sumEvenGrandparent(TreeNode root) {
            helper(root, 1, 1);
            return count;
        }

        private void helper(TreeNode root, int parent, int grandParent) {
            if(root != null){
                count += (grandParent % 2 == 0) ? root.val : 0;
                helper(root.left, root.val, parent);
                helper(root.right, root.val, parent);
            }
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right= new TreeNode(7);

        root.right.left = new TreeNode(1);
        root.right.right= new TreeNode(3);

        root.left.left.left = new TreeNode(9);

        System.out.println(new Solution().sumEvenGrandparent(root));
    }
}
