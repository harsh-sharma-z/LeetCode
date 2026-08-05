class Solution {

    void dfs(int node, HashMap<Integer, ArrayList<Integer>> invoke , int[] vis) {
        vis[node] = 1;
        
        if(!invoke.containsKey(node)) {
            return;
        }

        for(int i : invoke.get(node)){
            if(vis[i] == 0) {
                dfs(i, invoke, vis);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        HashMap<Integer, ArrayList<Integer>> invoke = new HashMap<>();
        for(int[] i : invocations) {
            int u = i[0];
            int v = i[1];

            invoke.computeIfAbsent(u , x -> new ArrayList<>()).add(v);
        }

        int[] vis = new int[n];

        dfs(k , invoke, vis);

        List<Integer> rem = new ArrayList<>();

        for(int []i : invocations) {
            int u = i[0];
            int v = i[1];

            if(vis[u] == 0 && vis[v] == 1) {
                for(int j = 0 ; j < n ; j++) {
                    rem.add(j);
                }
                return rem;
            }
        }

        for(int i = 0 ; i < n ; i++) {
            if(vis[i] == 0) {
                rem.add(i);
            }
        }

        return rem;
    }
}