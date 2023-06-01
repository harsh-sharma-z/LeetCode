class Solution {
    class Node{
        int row;
        int col;
        int dist;
        Node(int row,int col,int dist)
        {
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }

    private int drow[]={-1,0,1,0,1,-1,1,-1};
    private int dcol[]={0,1,0,-1,1,-1,-1,1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1)
        return -1;

        if(n==1)
        return 1;

        int dist[][]=new int[n][n];

        for(int[] a:dist)
        Arrays.fill(a,(int)(1e9));

        dist[0][0]=1;

        Queue<Node> uwu=new LinkedList<>();                
        uwu.add(new Node(0,0,1));

        while(!uwu.isEmpty())
        {
            Node node=uwu.poll();
            int row=node.row;
            int col=node.col;
            int d=node.dist;
            for(int i=0;i<8;i++)
            {
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && d+1<dist[nrow][ncol] && grid[nrow][ncol]==0)
                {
                    dist[nrow][ncol]=d+1;
                    if(nrow==n-1 && ncol==n-1)
                    return d+1;
                    uwu.add(new Node(nrow,ncol,d+1));
                }
            }
        }
        return -1;
    }
}