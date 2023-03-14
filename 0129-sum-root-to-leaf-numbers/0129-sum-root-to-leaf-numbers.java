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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode root , int n)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return ((n*10)+root.val);
        int left=dfs(root.left,(n*10)+root.val);
        int right=dfs(root.right,(n*10)+root.val);
        return left+right;
    }   
}