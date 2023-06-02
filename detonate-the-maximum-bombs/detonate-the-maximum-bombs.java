class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        List<List<Integer>> adj=new ArrayList<>(n);
        for(int i=0;i<n;i++) //i-th bomb foda hai
        {
            adj.add(new ArrayList<>());
            for(int j=0;j<n;j++) //kon-kon bomb fata hai
            {
                if(i==j) continue;
                long x1=bombs[i][0];
                long y1=bombs[i][1];
                long r1=bombs[i][2];

                long x2=bombs[j][0];
                long y2=bombs[j][1];

                long dist=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
                if(dist<= r1*r1)
                    adj.get(i).add(j);
            }
        }

        

        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {   
            int[] c=new int[1];
            boolean[] vis=new boolean[n];
            dfs(i,vis,adj,c);
            res=Math.max(c[0],res);
        }
        return res;
    }

    private void dfs(int src, boolean[] vis, List<List<Integer>> adj,int[] c)
    {
        vis[src]=true;
        c[0]++;
        for(int u:adj.get(src))
        {
            if(!vis[u])
            dfs(u,vis,adj,c);
        }
    }
}