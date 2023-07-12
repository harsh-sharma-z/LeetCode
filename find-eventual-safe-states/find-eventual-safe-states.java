class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0 ; i < v ; i++)
            adjRev.add(new ArrayList<>());
        
        int indegree[] = new int[v];

        for(int i = 0 ; i < v ; i++){
            for(int node : graph[i]){
                adjRev.get(node).add(i);
                indegree[i]++ ;
            }
        }
        Queue<Integer> uwu = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < v ; i++)
            if(indegree[i]==0)
                uwu.add(i);
        
        while(!uwu.isEmpty()){
            int node = uwu.poll();
            ans.add(node);
            for(int i : adjRev.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    uwu.add(i);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}