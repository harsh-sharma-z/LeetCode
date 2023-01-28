class SummaryRanges {
 private TreeSet<Integer> set;
    public SummaryRanges() {
        set=new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        ArrayList<int []>list=new ArrayList<>();
        int []a=new int[2];
        int flag=0,left=0,right=0;
        for(int values:set){
            
            if(!set.contains(values+1)){
                if(flag==0)left=values;
                right=values;
                list.add(new int[]{left,right});
                flag=0;
            }
            else if(set.contains(values+1)){
                if(flag==0){
                    left=values;
                    flag=1;
                }
            }
                
        }
        return list.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */