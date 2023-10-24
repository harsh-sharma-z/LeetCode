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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> uwu = new LinkedList<>();
        uwu.offer(root);

        while(!uwu.isEmpty()){
            int n = uwu.size();
            int max = Integer.MIN_VALUE;
            for(int i = 1 ; i <= n ; i++){
                TreeNode temp = uwu.poll();
                max = Math.max(temp.val , max);
                if(temp.left != null)
                    uwu.offer(temp.left);
                if(temp.right != null)
                    uwu.offer(temp.right);
            }
            ans.add(max);
        }
        return ans;
    }
}