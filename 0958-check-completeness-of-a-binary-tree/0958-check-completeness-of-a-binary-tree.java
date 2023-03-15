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
    public boolean isCompleteTree(TreeNode root) {        
        
        Queue<TreeNode> uwu=new LinkedList<>();
        uwu.offer(root);
        
        boolean past=false; // kya mene past mein null node dekha hai?
        
        while(!uwu.isEmpty())
        {
            TreeNode node=uwu.peek();
            
            uwu.poll();
            
            if(node==null)
                past=true;
            else
            {
                if(past==true)
                    return false;
                uwu.offer(node.left);
                uwu.offer(node.right);
            }
        }
        return true;
        
    }
}