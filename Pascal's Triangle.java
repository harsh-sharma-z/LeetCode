class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l1 = new ArrayList<List<Integer>>();
        if(numRows == 0){
            return l1;
        }
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l1.add(l3);
        for(int i = 1; i < numRows; i++){
            ArrayList<Integer> l2 = new ArrayList<>();
            l2.add(1);
            for(int j = 1; j < i ; j++){
                int ans = l1.get(i - 1).get(j -1) + l1.get(i-1).get(j);
                l2.add(ans);
            }
            l2.add(1);
            l1.add(l2);
        }
        return l1;
        
    }
}
