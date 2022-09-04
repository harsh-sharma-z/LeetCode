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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int min = 0, max = 0;
        HashMap<Integer, List<Integer>> vertices = new HashMap<>();
        Queue<Pair<Integer, TreeNode>> cur = new LinkedList<>();
        Queue<Pair<Integer, TreeNode>> next = new LinkedList<>();
        HashMap<Integer, PriorityQueue<Integer>> buffer = new HashMap<>();
        cur.add(new Pair<>(0, root));
        while (!cur.isEmpty()) {
            Pair<Integer, TreeNode> node = cur.poll();
            if (!buffer.containsKey(node.getKey())) buffer.put(node.getKey(), new PriorityQueue<>());
            buffer.get(node.getKey()).add(node.getValue().val);
            if (node.getValue().left != null) {
                next.add(new Pair<>(node.getKey() - 1, node.getValue().left));
                min = Math.min(min, node.getKey() - 1);
            }
            if (node.getValue().right != null) {
                next.add(new Pair<>(node.getKey() + 1, node.getValue().right));
                max = Math.max(max, node.getKey() + 1);
            }
            if (cur.isEmpty()) {
                cur = next;
                next = new LinkedList<>();
                flushBuffer(vertices, buffer, min, max);
                buffer = new HashMap<>();
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ans.add(vertices.get(i));
        }
        return ans;
    }

    private void flushBuffer(HashMap<Integer, List<Integer>> vertices, HashMap<Integer, PriorityQueue<Integer>> buffer, int min, int max) {
        for (int i = min; i <= max; i++) {
            if (!buffer.containsKey(i)) continue;
            if (!vertices.containsKey(i)) vertices.put(i, new ArrayList<>());
            List<Integer> cur = vertices.get(i);
            PriorityQueue<Integer> pq = buffer.get(i);
            while (!pq.isEmpty()) cur.add(pq.poll());
        }
    }
}