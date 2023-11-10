class Solution {
    Map<Integer , List<Integer>> adj = new HashMap<>();
    public int[] restoreArray(int[][] adjPairs) {
        for(int[] edge : adjPairs){
            int x = edge[0];
            int y = edge[1];

            adj.computeIfAbsent(x , k -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y , k -> new ArrayList<>()).add(x);
        }

        int root = 0;

        for(int num : adj.keySet()){
            if(adj.get(num).size() == 1){
                root = num;
                break;
            }
        }

        int[] res = new int[adj.size()];
        dfs(root , Integer.MAX_VALUE , res , 0);
        return res;
    }

    private void dfs(int node , int prev , int[] res , int i){
        res[i] = node;
        for(int neighbour : adj.get(node)){
            if(neighbour != prev){
                dfs(neighbour , node , res , i + 1);
            }
        }
    }
}