class Solution {
    int count = 0 ;
    
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList< int[]> > adj = new ArrayList<ArrayList<int[]> >() ;
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<int[]>() );
        }
        
        for(int i = 0 ; i < connections.length ; i++){
            int u = connections[i][0] ;
            int v = connections[i][1] ;
            
            adj.get(u).add(new int[]{v , 1} );
            adj.get(v).add(new int[]{u , 0}) ;
        }
        
        int[] visited = new int[n] ;
        Arrays.fill(visited , -1) ;
        
        
        dfs(0 , adj , visited) ;
        
        
        return  count ;
    }
    
    private void dfs(int src , ArrayList<ArrayList<int[]>> adj , int[] visited){
        visited[src] = 1 ;
        
        for(int[] arr : adj.get(src) ){
            
            int num = arr[0] ;
            
            if(visited[num] == -1){
                count += arr[1]  ;
                dfs(num , adj , visited) ;
            }
        }
        
        
        
        return ;
    }

}