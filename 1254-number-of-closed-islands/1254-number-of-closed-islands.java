class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    if(dfs(grid,i,j,m,n))
                        count++;
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid, int i, int j,int m, int n)
    {
        if(i>=m || i<0 || j>=n || j<0)
        {
            return false;
        }
        if(grid[i][j]==1)
            return true;
        
        
        grid[i][j]=1;
        
        boolean down=dfs(grid,i+1,j,m,n);
        boolean up=dfs(grid,i-1,j,m,n);
        boolean right=dfs(grid,i,j+1,m,n);
        boolean left=dfs(grid,i,j-1,m,n);
        
        
        return (down && up && left && right);
    }
}