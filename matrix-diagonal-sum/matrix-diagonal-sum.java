class Solution {
    public int diagonalSum(int[][] mat) {
        int ans=0;
        for(int i=0;i<mat.length;i++)
            ans+=(mat[i][i]+mat[mat.length-i-1][i]);
        if(mat.length%2!=0)
            ans-=mat[mat.length/2][mat.length/2];
        return ans;
    }
}