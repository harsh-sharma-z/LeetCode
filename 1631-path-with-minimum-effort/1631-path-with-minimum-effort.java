class Solution {
    class Tuple{
        int distance;
        int row;
        int col;
        public Tuple(int a,int b,int c)
        {
            this.distance=a;
            this.row=b;
            this.col=c;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<Tuple> uwu=new PriorityQueue<>((x,y)->x.distance-y.distance);
        int dist[][]=new int[n][m];
        for(int i[]:dist)
        {
            Arrays.fill(i,(int)(1e9));
        }
        dist[0][0]=0;
        
        uwu.add(new Tuple(0,0,0));
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        
        while(!uwu.isEmpty())
        {
            Tuple temp=uwu.poll();
            int diff=temp.distance;
            int row=temp.row;
            int col=temp.col;
            if(diff>dist[row][col])
                continue;
            
            if(row==n-1 && col==m-1)
                return diff;
            for(int i=0;i<4;i++)
            {
                int newr=row+dr[i];
                int newc=col+dc[i];
                
                
                
                if(newr>=0 && newr<n && newc>=0 && newc<m)
                {
                    int newdiff= Math.max(Math.abs(heights[newr][newc]-heights[row][col]),diff);
                    if(newdiff<dist[newr][newc])
                    {
                        dist[newr][newc]=newdiff;
                        uwu.add(new Tuple(newdiff, newr,newc));
                    }
                }
            }
        }
        return 0;
    }
}