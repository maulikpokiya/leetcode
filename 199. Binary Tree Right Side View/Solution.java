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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        return bfs(root);
    }

    private List<Integer> bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty()) {
            int levelLen = deque.size();
            for(int i=0; i<levelLen; i++) {
                TreeNode node = deque.removeFirst();
                if(node.left != null) {
                    deque.add(node.left);
                }
                if(node.right != null) {
                    deque.add(node.right);
                }
                if(i == levelLen-1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
