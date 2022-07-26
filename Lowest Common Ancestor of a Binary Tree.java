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
    TreeNode p,q,LCA;
    int lcs_level=Integer.MAX_VALUE, c=0;//c is the count of nodes found
    
    void dfs(TreeNode node, int level) {
        if(node==null) return;
        dfs(node.left,level + 1);
        if(((node==p || node==q) && (c==0 || lcs_level>level)) || (c==1 && lcs_level>level)){
            lcs_level=level;
            LCA=node;            
        }
        if(node==p || node==q) c++;
        dfs(node.right, level + 1);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p=p;
        this.q=q;
        dfs(root,0);
        return LCA;
    }
}
