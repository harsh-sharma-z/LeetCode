class Solution {
    public double average(int[] salary) {
        double avg=0;
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i:salary)
        {
            max=Math.max(i,max);
            min=Math.min(i,min);
        }
        for(int i:salary)
        {
            if(i!=max && i!=min)
            {
                avg+=i;
            }
        }
        return avg/(salary.length-2);
    }
}