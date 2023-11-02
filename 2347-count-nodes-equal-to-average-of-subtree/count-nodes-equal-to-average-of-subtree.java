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
    class Pair{
        int sum;
        int count;
        Pair(int sum , int count){
            this.sum = sum;
            this.count = count;
        }
    }
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return res;
    }
    private Pair solve(TreeNode root){
        if(root == null){
            return new Pair(0 , 0);
        }
        Pair p1 = solve(root.left);
        Pair p2 = solve(root.right);
        int totSum = p1.sum + p2.sum + root.val;
        int totCount = p1.count + p2.count + 1;

        int avg = (totSum / totCount);

        if(avg == root.val)
            res ++;
        
        return new Pair(totSum , totCount);
    }
}