class Tuple {
    int x, y, h; 
    Tuple(int i, int j, int h) {
        this.x = i; 
        this.y = j; 
        this.h = h; 
    }
}

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.h - a.h); 

        pq.offer(new Tuple(0, 0, health - grid.get(0).get(0))); 

        int[][] dirs = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        }; 
        int m = grid.size(); 
        int n = grid.get(0).size(); 
        int rh[][] = new int[m][n]; // running health 
        rh[0][0] = health - grid.get(0).get(0); 

        // for(int i = 0; i < m; i++) Arrays.fill(rh[i], -1); 

        while(pq.size() > 0) {
            Tuple cur = pq.remove(); // returns andn remove top elemenet  
            if(cur.x == m - 1 && cur.y == n - 1 ) return rh[m -1][n -1] > 0; 

            for(int d[]: dirs) {
                int nx = cur.x + d[0], ny = cur.y + d[1], nh = rh[cur.x][cur.y]; 
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && rh[nx][ny] < nh - grid.get(nx).get(ny)) {
                    pq.offer(new Tuple(nx, ny, nh - grid.get(nx).get(ny)));
                    rh[nx][ny] = nh - grid.get(nx).get(ny); 
                }
            }
        }

        return false; 
    }
}