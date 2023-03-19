class Solution {
    public int findCircleNum(int[][] arr) {
        ArrayList<ArrayList<Integer>> uwu=new ArrayList<>();
        
        
        for(int i=0;i<arr.length;i++)
        {
            uwu.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(arr[i][j]==1 && i!=j)
                {
                    uwu.get(i).add(j);
                    uwu.get(j).add(i);
                }
            }
        }
        
        
        int vis[]=new int[arr.length];
        int ans=0;
        
        
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                ans++;
                dfs(i,uwu,vis);
            }
        }
        
        return ans;
    }
    
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> uwu, int[] vis)
    {
        vis[node]=1;
        
        for(Integer i: uwu.get(node))
        {
            if(vis[i]==0)
                dfs(i,uwu,vis);
        }
    }
}