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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startToRoot = new StringBuilder();
        StringBuilder endToRoot = new StringBuilder();

        dfs(root, startToRoot, startValue);
        dfs(root, endToRoot, destValue);

        int i = startToRoot.length(), j = endToRoot.length();

        int count = 0;
        while(i > 0 && j > 0 && startToRoot.charAt(i - 1) == endToRoot.charAt(j - 1)){
            count++;
            i--;
            j--;
        }

        String sPath = "U".repeat(startToRoot.length() - count);
        String ePath = endToRoot.reverse().toString().substring(count, endToRoot.length());

        return sPath + ePath;


    }
    private boolean dfs(TreeNode curr, StringBuilder path, int destVal) {
        if(curr == null) {
            return false;
        }
        if(curr.val == destVal) {
            return true;
        }
        if(dfs(curr.left, path, destVal)) {
            path.append("L");
        }
        else if(dfs(curr.right, path, destVal)) {
            path.append("R");
        }
        return path.length() > 0;
    }
}