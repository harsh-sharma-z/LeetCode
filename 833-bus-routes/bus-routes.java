class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)
            return 0;

        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int route = 0 ; route < routes.length ; route++){
            for(int stop : routes[route]){
                adj.computeIfAbsent(stop , k -> new ArrayList<>()).add(route);
            }
        }

        Queue<Integer> uwu = new LinkedList<>();

        boolean[] vis = new boolean[501];

        for(int route : adj.getOrDefault(source , Collections.emptyList())){
            uwu.offer(route);
            vis[route] = true;
        }

        int bus = 1;

        while(!uwu.isEmpty()){
            int size = uwu.size();

            while(size -- > 0){
                int route = uwu.poll();

                for(int stop : routes[route]){
                    if(stop == target)
                        return bus;

                    for(int nextStop : adj.getOrDefault(stop , Collections.emptyList())){
                        if(!vis[nextStop]){
                            vis[nextStop] = true;
                            uwu.offer(nextStop);
                        }
                    }
                }
            }
            bus++;
        }
        return -1;
    }
}