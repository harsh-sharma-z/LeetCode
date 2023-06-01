class Solution {
    public int findCircleNum(int[][] grid) {
        int n=grid.length;
        int vis[]=new int[n+1];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                ans++;
                Queue<Integer> uwu=new LinkedList<>();
                uwu.add(i);
                vis[i]=1;
                while(!uwu.isEmpty())
                {
                    int v=uwu.poll();
                    for(int j=0;j<n;j++)
                    {
                        if(vis[j]==0 && grid[v][j]==1)
                        {
                            uwu.add(j);
                            vis[j]=1;
                        }
                    }
                }
            }
        }
        return ans;
    }
}