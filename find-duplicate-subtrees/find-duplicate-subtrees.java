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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String , Integer> uwu = new HashMap<>();
        List<TreeNode> res =  new LinkedList<>();
        helper(root , uwu , res);
        return res;
    }

    private String helper(TreeNode root , HashMap<String  , Integer> uwu , List<TreeNode> res){
        if(root == null)
            return "";
        
        String left = helper(root.left , uwu , res);
        String right = helper(root.right , uwu , res);
        String curr = root.val + "#" + left + "#" + right;
        if(uwu.getOrDefault(curr , 0) == 1)
            res.add(root);
        uwu.put(curr , uwu.getOrDefault(curr , 0)+1);

        return curr;
    }
}