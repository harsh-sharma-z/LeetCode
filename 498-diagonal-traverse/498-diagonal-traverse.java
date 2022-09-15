import java.util.ArrayList;

/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int k=0;
        int[]ans=new int[m*n];
        for(int d=0;d<m+n-1;d++)
        {
            int r,c=0;
            if(d<m){
                r=0;
                c=d;
            }
            else{
                c=m-1;
                r=d-m+1;
            }
            ArrayList<Integer> list=new ArrayList<>();
            while(r<n&& c>=0)
            {
                list.add(mat[r][c]);
                r++;
                c--;
            }
            if(d%2==0)
            {
                for (int i = list.size()-1; i>=0; i--) {
                    ans[k]=list.get(i);
                    k++;
                }
            }
            else{
                for (int i = 0; i<list.size(); i++) {
                    ans[k]=list.get(i);
                    k++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

