class Solution {
    public int findTheCity(int n, int[][] edges, int d) {
        
        int[][] dist=new int[n][n];
        for(int[] i: dist)
            Arrays.fill(i,Integer.MAX_VALUE);
        
        
        for(int[]i : edges)
        {
            int u=i[0];
            int v=i[1];
            int dis=i[2];
            dist[u][v]=dis;
            dist[v][u]=dis;
        }
        
        for(int i=0;i<n;i++)
        {
            dist[i][i]=0;
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE)
                        continue;
                    dist[i][j]=Math.min(dist[i][j] , dist[i][k]+dist[k][j]);
                }
            }
        }
        
        int maxsize=n;
        int ans=-1;;
        
        for(int i=0;i<n;i++)
        {
            int c=0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=d)
                    c++;
            }
            
            if(c<=maxsize)
            {
                ans=i;
                maxsize=c;
            }
        }
        return ans;
    }
}