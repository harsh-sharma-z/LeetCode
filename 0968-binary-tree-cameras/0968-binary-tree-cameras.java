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
    int c=0;
    public int minCameraCover(TreeNode root) {
        int ans=dfs(root);
        if(ans==-1)
        c++;
        return c;
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
            return 1;
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(left==-1 || right==-1){
            c++;
            return 2;
        }

        if(left==1 && right==1){
            return -1;
        }
        else
        {
            return 1;
        }
        
    }
    }

