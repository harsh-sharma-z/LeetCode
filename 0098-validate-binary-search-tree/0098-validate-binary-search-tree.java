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
class Pair{
        boolean isBST=true;
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
    }
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return validBST(root).isBST;
    }
    public Pair validBST(TreeNode root)
    {
        if(root==null)
            return new Pair();
        Pair left=validBST(root.left);
        Pair right=validBST(root.right);
        Pair own=new Pair();
        
        own.max=Math.max(left.max,Math.max(right.max,root.val));
        own.min=Math.min(left.min,Math.min(right.min,root.val));
        if(left.isBST && right.isBST && left.max<root.val && right.min>root.val)
            own.isBST=true;
        else
            own.isBST=false;
        return own;
    }
}