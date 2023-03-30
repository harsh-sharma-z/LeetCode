class Solution {
    class Node{
        int dist;
        int x;
        int y;
        public Node(int dist, int x, int y)
        {
            this.dist=dist;
            this.x=x;
            this.y=y;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
            
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;
        if(n==1)
            return 1;
        Queue<Node>  uwu=new LinkedList<>();
    
    
        int[][] doori=new int[n][n];
        
        for(int[] a:doori)
        Arrays.fill(a,(int)(1e9));
        
        doori[0][0]=1;
        
        
        uwu.add(new Node(1,0,0));
        
        int dr[]={-1,0,1,0,1,-1,1,-1};
        int dc[]={0,1,0,-1,1,-1,-1,1};
        
        while(!uwu.isEmpty())
        {
            Node temp=uwu.poll();
            int dis=temp.dist;
            int x=temp.x;
            int y=temp.y;
            
            for(int i=0;i<8;i++)
            {
                int newr=x+dr[i];
                int newc=y+dc[i];
                
                if(newr>=0 && newr<n && newc>=0 && newc<n && dis+1<doori[newr][newc] && grid[newr][newc]==0)
                {
                    doori[newr][newc]=dis+1;
                    if(newr==n-1 && newc==n-1)
                    return dis+1;
                    uwu.add(new Node(dis+1,newr,newc));
                }
            }
        }
        return -1;
    }
}