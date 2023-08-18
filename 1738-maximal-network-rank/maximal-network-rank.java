class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
            adj.add(new ArrayList<>());
        for(int[] i : roads){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans = -1;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int rank = adj.get(i).size() + adj.get(j).size();
                if(adj.get(i).contains(j))
                    rank -- ;
                ans = Math.max(rank , ans);
            }
        }
        return ans;
    }
}