class Pair{
    int first;
    int second;
    int third;
    public Pair(int first, int second, int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair> uwu=new LinkedList<>();
        int vis[][]=new int[n][m];
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    uwu.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else
                    vis[i][j]=0;
            }
        }
        
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        
        while(!uwu.isEmpty())
        {
            int row=uwu.peek().first;
            int col=uwu.peek().second;
            int steps=uwu.peek().third;
            uwu.remove();
            dist[row][col]=steps;
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    uwu.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        
        return dist;
    }
}