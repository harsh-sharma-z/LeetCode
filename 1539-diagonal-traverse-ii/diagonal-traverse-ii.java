class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair<Integer , Integer>> q = new LinkedList<>();

        q.offer(new Pair(0 , 0));

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            Pair<Integer , Integer> p = q.poll();
            int row = p.getKey();
            int col = p.getValue();

            ans.add(nums.get(row).get(col));

            if(col == 0 && row + 1 < nums.size())
                q.offer(new Pair(row + 1 , col));
            
            if(col + 1 < nums.get(row).size())
                q.offer(new Pair(row , col + 1));
        }

        // int[] res = new int[ans.size()];

        // for(int i = 0 ; i < ans.size() ; i++)
        //     res[i] = ans.get(i);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}