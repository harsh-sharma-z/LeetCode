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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> uwu=new HashMap<>();
        
        for(int i=0;i<inorder.length;i++)
            uwu.put(inorder[i],i);
        return construct(postorder,0,postorder.length-1,inorder,0,inorder.length-1,uwu);
    }
    
    private TreeNode  construct(int[] postorder, int ps,int pe,int[] inorder,int is,int ie,HashMap<Integer,Integer> uwu)
    {
        if(ps>pe || is>ie)
            return null;
        TreeNode root=new TreeNode(postorder[pe]);
        int ri=uwu.get(postorder[pe]);
        TreeNode lc=construct(postorder,ps,ps+ri-is-1,inorder,is,ri-1,uwu);
        TreeNode rc=construct(postorder,ps+ri-is,pe-1,inorder,ri+1,ie,uwu);
        
        root.left=lc;
        root.right=rc;
        
        return root;
    }
}