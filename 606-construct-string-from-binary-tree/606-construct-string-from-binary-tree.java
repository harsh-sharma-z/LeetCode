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
    public String tree2str(TreeNode root) {
        StringBuilder s=new StringBuilder();
        preOrder(root,s);
        return s.toString();
        
    }
    
    private void preOrder(TreeNode root, StringBuilder s)
    {
        if(root==null)
            return;
        
        s.append(root.val);
        if(root.left!=null)
        {
            s.append("(");
            preOrder(root.left,s);
            s.append(")");
                
        }
        
        if(root.right!=null)
        {
            if(root.left==null)
                s.append("()");
            s.append("(");
            preOrder(root.right,s);
            s.append(")");
            
        }
        
        
    }
}