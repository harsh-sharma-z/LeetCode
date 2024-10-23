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
    public TreeNode replaceValueInTree(TreeNode root) {
        dfs(new TreeNode[] {root});
        root.val = 0;
        return root;
    }
    private void dfs(TreeNode[] arr) {
        if(arr.length == 0) {
            return;
        }
        
        int sum = 0;

        for(TreeNode node : arr) {
            if(node == null) {
                continue;
            }
            if(node.left != null) {
                sum += node.left.val;
            }
            if(node.right != null) {
                sum += node.right.val;
            }
        }

        TreeNode[] childArr = new TreeNode[arr.length * 2];
        int idx = 0;

        for(TreeNode node : arr) {
            int currSum = 0;
            if(node.left != null) {
                currSum += node.left.val;
            }
            if(node.right != null) {
                currSum += node.right.val;
            }

            if(node.left != null) {
                node.left.val = sum - currSum;
                childArr[idx++] = node.left;
            }
            if(node.right != null) {
                node.right.val = sum - currSum;
                childArr[idx++] = node.right;
            }
        }
        
        dfs(java.util.Arrays.copyOf(childArr, idx));
    }
}