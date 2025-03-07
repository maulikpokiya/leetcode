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
class BinaryTreeVertical {

    Map<Integer,List<Integer>> nodesByCol;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> list = new ArrayList<>();
        if(root.left == null && root.right == null) {
            List<Integer> sublist = new ArrayList<>();
            sublist.add(root.val);
            list.add(sublist);
            return list;
        }

        nodesByCol = new TreeMap<>();
        int colIdx = 0;
        Deque<Pair<TreeNode,Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair(root, 0));
        collectNodesByCol(deque);

        for(Map.Entry<Integer, List<Integer>> entry : nodesByCol.entrySet()) {
            List<Integer> sublist = new ArrayList<>();
            sublist.addAll(entry.getValue());
            list.add(sublist);
        }
        return list;
    }

    private void collectNodesByCol(Deque<Pair<TreeNode,Integer>> deque) {
        while(!deque.isEmpty()) {
            Pair<TreeNode,Integer> pair = deque.removeFirst();
            TreeNode node = pair.getKey();
            int colIdx = pair.getValue();
            nodesByCol.putIfAbsent(colIdx, new ArrayList<>());
            nodesByCol.get(colIdx).add(node.val);

            if(node.left != null) {
                deque.add(new Pair(node.left, colIdx-1));
            }
            if(node.right != null) {
                deque.add(new Pair(node.right, colIdx+1));
            }
        }
    }
}
