class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
            adj.add(new ArrayList<>());
        
        HashMap<Integer , Integer> childToParent = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int left = leftChild[i];
            int right = rightChild[i];

            if(left != -1){
                adj.get(i).add(left);
                if(childToParent.containsKey(left))
                    return false;
                childToParent.put(left , i);
            }

            if(right != -1){
                adj.get(i).add(right);
                if(childToParent.containsKey(right))
                    return false;
                childToParent.put(right , i);
            }
        }

        int root = -1;

        for(int i = 0 ; i < n ; i++){
            if(!childToParent.containsKey(i)){
                if(root != -1)
                    return false;
                root = i;
            }
        }

        if(root == -1)
            return false;

        //Let's do normal BFS

        int c = 0;

        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[n];

        q.offer(root);
        c = 1;
        vis[root] = true;

        while(!q.isEmpty()){

            int node = q.poll();

            for(int v : adj.get(node)){
                if(vis[v] == true)
                    return false;
                if(!vis[v]){
                    vis[v] = true;
                    c++;
                    q.offer(v);
                }
            }
        }

        return c == n;

    }
}