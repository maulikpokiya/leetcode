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
class BinaryTreeDiameter {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) 
            return 0;

        findDiameter(root);
        return diameter;
    }

    private int findDiameter(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftDiameter=0, rightDiameter=0;
        if(node.left != null) {
            leftDiameter = findDiameter(node.left) + 1;
        }
        if(node.right != null) {
            rightDiameter = findDiameter(node.right) + 1;
        }

        diameter = Math.max(diameter, leftDiameter + rightDiameter);
        return Math.max(leftDiameter, rightDiameter);
    }
}
