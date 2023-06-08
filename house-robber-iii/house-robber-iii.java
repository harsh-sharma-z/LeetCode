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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> dp=new HashMap<>();
        return help(root,dp);
    }
    private int help(TreeNode root,HashMap<TreeNode,Integer> dp)
    {
        if(root==null)
        return 0;
        if(dp.containsKey(root))
        return dp.get(root);
        int rob=root.val;
        if(root.left!=null)
        rob+=help(root.left.left,dp)+help(root.left.right,dp);
        if(root.right!=null)
        rob+=help(root.right.left,dp)+help(root.right.right,dp);

        int dontrob=help(root.left,dp)+help(root.right,dp);
        dp.put(root,Math.max(rob,dontrob));
        return Math.max(rob,dontrob);
    }
}