class Pair{
    int x;
    int y;
    public Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair> uwu =new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || j==0 || i==n-1 || j==m-1)
                {
                    if(grid[i][j]==1)
                    {
                        uwu.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        
        while(!uwu.isEmpty())
        {
            int row=uwu.peek().x;
            int col=uwu.peek().y;
            uwu.remove();
            
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                
                if(nrow>=0 && nrow<n &&ncol>=0 && ncol<m&& grid[nrow][ncol]==1 && vis[nrow][ncol]==0)
                {
                    uwu.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                    ans++;
            }
        }
        return ans;
    }
}