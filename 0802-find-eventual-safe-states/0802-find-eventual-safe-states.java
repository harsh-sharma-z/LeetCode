class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int[] vis=new int[V];
        int[] path= new int[V];
        int[] check=new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,path,check,graph);
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++)
        if(check[i]==1)
        ans.add(i);
        return ans;
    }
    
    private boolean dfs(int src, int[] vis, int[] path, int[] check, int[][] adj)
    {
        vis[src]=1;
        path[src]=1;
        check[src]=0;
        for(int i: adj[src])
        {
            if(vis[i]==0)
            {
                if(dfs(i,vis,path,check,adj))
                    return true;
            }
            else if(path[i]==1)
                return true;
        }
        
        path[src]=0;
        check[src]=1;
        return false;
    }
}