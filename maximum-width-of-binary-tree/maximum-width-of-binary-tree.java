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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        int ans=-1;
        while(q.size()>0){
           // Pair p = q.remove();
            int size=q.size();
            int mn=q.peek().getX();
            int left=0,right=0;
            for(int i=0;i<size;i++){
               Pair p = q.remove();
               int x=p.getX()-mn;
               if(i==0)
               left=p.getX();
               if(i==size-1)
               right=p.getX();
               if(p.getTn().left != null){
                  q.add(new Pair(2*x+1,p.getTn().left));
               }
                if(p.getTn().right!=null){
                   q.add(new Pair(2*x+2,p.getTn().right));
               }

            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
        
    }
}
class Pair{
    int x;
    TreeNode tn;
    Pair(int x,TreeNode tn){
        this.x=x;
        this.tn=tn;
    }
    int getX(){
        return x;
    }
    TreeNode getTn(){
        return tn;
    }
}