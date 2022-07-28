/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned.val==target.val){
            return cloned;
        }
        
        
        TreeNode rightNode = null;
        TreeNode leftNode = null;
        
        if(cloned.left!=null){
            rightNode = getTargetCopy(original, cloned.left, target);
            if(rightNode!=null) return rightNode;
        }
        
        if(cloned.right!=null){
            leftNode = getTargetCopy(original, cloned.right, target);
            if(leftNode!=null) return leftNode;
        }
        
        return null;
    }
}
