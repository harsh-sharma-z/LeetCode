class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int n=arr.length;
        HashSet<Integer> vis=new HashSet<>();
        for(int i:arr)
        {
            min=Math.min(i,min);
            max=Math.max(i,max);
            vis.add(i);
        }
        int d=max-min;
        if(d%(n-1)!=0)
        return false;
        d/=n-1;
        while(--n>0)
        {
            if(!vis.contains(min))
            return false;
            min+=d;
        }
        return true;
    }
}