class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        int c=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i*j==0 || i==m-1 || j==n-1)
                    dfs(grid,i,j,m,n);
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                c+=grid[i][j];
        }
        return c;
        
    }
    
    private void dfs(int[][] grid,int row, int col, int m , int n)
    {
        if(row>=m || row<0 || col>= n || col<0)
        {
            return;
        }
        if(grid[row][col]==0)
            return ;
        grid[row][col]=0;
        dfs(grid,row-1,col,m,n);
        dfs(grid,row+1,col,m,n);
        dfs(grid,row,col-1,m,n);
        dfs(grid,row,col+1,m,n);
    }
}