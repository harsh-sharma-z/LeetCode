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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> uwu=new ArrayList<>();
        if(root==null)
            return uwu;
        
        uwu.add(root.val);
        
        uwu.addAll(preorderTraversal(root.left));
        
        uwu.addAll(preorderTraversal(root.right));
        
        return uwu;
    }
}