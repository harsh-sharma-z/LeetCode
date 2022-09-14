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
    int []arr=new int[10];
     int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        help(root);
        return ans;
    }
    public void help(TreeNode root)
    {
       
        if(root==null)
            return;
        arr[root.val]++;
        if(root.left==null && root.right==null)
        {
            int c=0;
            for(int i:arr)
                c+=i%2;
            if(c==1 || c==0)
                ans++;
        }
        help(root.left);
        help(root.right);
        arr[root.val]--;
    }
}