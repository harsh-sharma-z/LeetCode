class Solution {
    public int findCircleNum(int[][] arr) {
        int n=arr.length;
        int vis[]=new int[n];
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,n,arr,vis);
                c++;
            }
        }
        return c;
    }
    
    private void dfs(int src, int n , int[][] arr , int[] vis)
    {   
        
        for(int i=0;i<n;i++)
        {
            if(arr[src][i]==1&&vis[i]==0){
                vis[i]=1;
                dfs(i,n,arr,vis);
            }
        }
    }
}