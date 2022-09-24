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
    int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        return util(root, 0);
    }
    
    private boolean util(TreeNode root, int sum){
        if(root == null){
            return false;
        }
        
        sum += root.val;
        
        if(root.left == null && root.right == null && sum == targetSum){
            return true;
        }
        
        return (util(root.left, sum) || util(root.right, sum));
    }
}