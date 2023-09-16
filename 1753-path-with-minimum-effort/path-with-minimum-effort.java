class Solution {
    class Node{
            int distance;
            int row;
            int col;
            public Node(int distance , int row , int col){
                this.distance = distance;
                this.row = row;
                this.col = col;
            }
        }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Node> uwu = new PriorityQueue<>((x , y) -> x.distance - y.distance);
        int[][] dist = new int[n][m];
        for(int[] i : dist)
            Arrays.fill(i , Integer.MAX_VALUE);
        dist[0][0] = 0;
        uwu.add(new Node(0 , 0 , 0));
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};

        while(!uwu.isEmpty()){
            Node temp = uwu.poll();
            int distance = temp.distance;
            int row = temp.row;
            int col = temp.col;

            if(distance > dist[row][col])
                continue;
            if(row == n - 1 && col == m - 1)
                return distance;
            for(int i = 0 ; i < 4 ; i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m){
                    int newDistance = Math.max(Math.abs(heights[nrow][ncol] - heights[row][col]) , distance);

                    if(newDistance < dist[nrow][ncol]){
                        dist[nrow][ncol] = newDistance;
                        uwu.add(new Node(newDistance , nrow , ncol));
                    }
                }
            }
        }
        return 0;
    }
}