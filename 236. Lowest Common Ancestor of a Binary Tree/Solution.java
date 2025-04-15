class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverseDFS(root, p, q);
    }

    private TreeNode traverseDFS(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return null;
        }

        if(node == p || node == q) {
            return node;
        }

        TreeNode left = traverseDFS(node.left, p, q);
        TreeNode right = traverseDFS(node.right, p, q);

        if(left != null && right != null) {
            return node;
        }

        return left != null ? left : right;
    }
}
