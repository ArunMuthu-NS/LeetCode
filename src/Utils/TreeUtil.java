package Utils;

public class TreeUtil {
    public static TreeNode constructTree(int arr[], int index) {
        if(index >= arr.length) return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = constructTree(arr, (2 * index) + 1);
        root.right = constructTree(arr, (2 * index) + 2);
        return root;
    }
}
