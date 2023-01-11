class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int time = 0;
        Set<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> childToParent = new HashMap<>();
        for(int[] edge : edges){
            if(childToParent.containsKey(edge[1])){
                childToParent.put(edge[0], edge[1]);
            }else{
                childToParent.put(edge[1], edge[0]);
            }
        }
        for(int i = 0; i < n; i++){
            if(hasApple.get(i)){
                time += 2*findPathLength(childToParent, visited, i);
            }
        }
        return time;
    }
    private int findPathLength(HashMap<Integer, Integer> goUp, Set<Integer> visited, int node){
        int length = 0;
        while(node != 0 && !visited.contains(node)){
            visited.add(node);
            node = goUp.get(node);
            length += 1;
        }
        return length;
    }
}

