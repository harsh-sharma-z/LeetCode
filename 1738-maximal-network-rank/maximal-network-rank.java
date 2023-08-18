class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int adj[] = new int[n];
        boolean linked[][] = new boolean[n][n];
        for(int[] i : roads){
            int u = i[0];
            int v = i[1];
            adj[u]++;
            adj[v]++;
            linked[u][v] = linked[v][u] = true;
        }
        int ans = -1;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int rank = adj[i] + adj[j];
                if(linked[i][j])
                    rank -- ;
                ans = Math.max(rank , ans);
            }
        }
        return ans;
    }
}