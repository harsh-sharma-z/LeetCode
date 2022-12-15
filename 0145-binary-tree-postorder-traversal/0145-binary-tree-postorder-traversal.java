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
    public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> uwu=new ArrayList<>();
        
        if(root==null)
            return uwu;
        
        
        
        uwu.addAll(postorderTraversal(root.left));
        uwu.addAll(postorderTraversal(root.right));
        
        uwu.add(root.val);
        
        return uwu;
    }
}