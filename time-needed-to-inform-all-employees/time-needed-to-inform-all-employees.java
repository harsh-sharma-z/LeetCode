class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,Integer> adj=new HashMap<>();
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,dfs(i,manager,informTime,adj));
        }
        return max;
    }
    private int dfs(int eid, int[] manager, int[] informTime, HashMap<Integer,Integer> adj)
    {
        if(manager[eid]==-1)
        return 0;
        if(adj.containsKey(eid))
        return adj.get(eid);

        adj.put(eid,informTime[manager[eid]]+dfs(manager[eid],manager,informTime,adj));

        return adj.get(eid);
    }
}