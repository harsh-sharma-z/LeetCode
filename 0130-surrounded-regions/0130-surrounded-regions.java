class Solution {
    private void dfs(int row, int col,int n,int m, int[][] vis, char a[][], int[] delrow,int[] delcol)
    {
        vis[row][col]=1;
        
        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && a[nrow][ncol]=='O')
            dfs(nrow,ncol,n,m,vis,a,delrow,delcol);
        }
    }
    
    
    public void solve(char[][] a) {
        int n=a.length;
        int m=a[0].length;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        int[][] vis=new int[n][m];
        
        for(int j=0;j<m;j++)
        {
            if(vis[0][j]==0 && a[0][j]=='O')
            dfs(0,j,n,m,vis,a,delrow,delcol);
            
            if(vis[n-1][j]==0 && a[n-1][j]=='O')
            dfs(n-1,j,n,m,vis,a,delrow,delcol);
        }
        
        for(int i=0;i<n;i++)
        {
            if(vis[i][0]==0 && a[i][0]=='O')
            dfs(i,0,n,m,vis,a,delrow,delcol);
            
            if(vis[i][m-1]==0 && a[i][m-1]=='O')
            dfs(i,m-1,n,m,vis,a,delrow,delcol);
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && a[i][j]=='O')
                a[i][j]='X';
            }
        }
        
    }
}