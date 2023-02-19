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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> uwu=new ArrayList<>();
        help(root,uwu,0);
        return uwu;
    }
    private void help(TreeNode root,List<List<Integer>> uwu,int level)
    {
        if(root==null)
            return;
        if(uwu.size()<=level)
        {
            List<Integer> ds=new ArrayList<>();
            uwu.add(ds);
        }
        List<Integer> ds=uwu.get(level);
        if(level%2==0)
            ds.add(root.val);
        else
            ds.add(0,root.val);
        
        help(root.left,uwu,level+1);
        help(root.right,uwu,level+1);
    }
}