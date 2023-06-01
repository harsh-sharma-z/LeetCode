class Solution {
    class Pair{
        int  row;
        int col;
        int time;
        Pair(int row,int col, int time)
        {
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    private int drow[]={-1,0,1,0};
    private int dcol[]={0,1,0,-1};
    public int orangesRotting(int[][] grid) {
        Queue<Pair> uwu=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    uwu.add(new Pair(i,j,0));
                    grid[i][j]=0;
                }
                if(grid[i][j]==1)
                fresh++;
            }
        }
        int maxTime=0;
        int c=0;
        while(!uwu.isEmpty())
        {
            Pair curr=uwu.poll();
            int row=curr.row;
            int col=curr.col;
            int time=curr.time;
            maxTime=Math.max(time,maxTime);
            for(int i=0;i<4;i++)
            {
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1)
                {
                    grid[nrow][ncol]=0;
                    uwu.add(new Pair(nrow,ncol,time+1));
                    c++;
                }
            }
        }
        if(c==fresh)
        return maxTime;
        return -1;
    }
}