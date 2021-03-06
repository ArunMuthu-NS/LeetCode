package Trees;

import Utils.TreeNode;
import Utils.TreeUtil;

public class DeleteLeaves {
    static class Solution {
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if(root != null) {
                root.left = removeLeafNodes(root.left, target);
                root.right = removeLeafNodes(root.right, target);
                if(root.left == null && root.right == null && root.val == target)
                    return null;
                return root;
            }
            return null;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        System.out.println(new Solution().removeLeafNodes(root, 2));
    }
}
