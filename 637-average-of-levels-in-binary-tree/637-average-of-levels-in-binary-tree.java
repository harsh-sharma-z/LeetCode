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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new ArrayList();
        Queue<TreeNode> queue = new LinkedList(); 
        queue.add(root);
                
        Double rowSum = 0.0;
        int rowLen = 0;
        
        while(!queue.isEmpty()){
            rowSum = 0.0;
            rowLen = queue.size();
            
            for(int i = 0; i < rowLen; i++){ 
                TreeNode curr = queue.poll();
                rowSum += curr.val;
                if(curr.left != null){ queue.add(curr.left); }
                if(curr.right != null){ queue.add(curr.right); }
            }
            output.add(rowSum / rowLen);
        }
        return output;
        
    }
}