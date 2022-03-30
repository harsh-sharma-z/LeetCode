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
   
        public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inorderTraversal(result, root);
        return result;
    }
    
    private void inorderTraversal(List<Integer> result, TreeNode root) {
        if(root != null) {
            inorderTraversal(result, root.left);
            result.add(root.val);
            inorderTraversal(result, root.right);
        }
    }
        
    
}
