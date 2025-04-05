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
    private int total = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root.left == null && root.right == null) {
            if(low <= root.val && high >= root.val)
                return root.val;
        }

        inorder(root, low, high);
        return total;
    }

    private void inorder(TreeNode node, int low, int high) {
        if(node == null) {
            return;
        }

        if(node.val > low) {
            inorder(node.left, low, high);
        }
        if(node.val < high) {
            inorder(node.right, low, high);
        }
        if(node.val >= low && node.val <= high) {
            total += node.val;
        }
    }
}
