class Solution {
    public int numIslands(char[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int c=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    help(i,j,grid,visited);
                    c++;
                }
            }
        }
        return c;
        
    }
    
    public static void help(int i,int j,char[][] grid,boolean[][] visited)
    {
        if(i<0 || i>=grid.length)
            return;
        
        if(j<0 || j>=grid[0].length)
            return;
        
        if(grid[i][j] !='1' || visited[i][j])
            return;
        
        visited[i][j]=true;
        
        help(i-1,j,grid,visited);
        help(i+1,j,grid,visited);
        help(i,j+1,grid,visited);
        help(i,j-1,grid,visited);
    }
}