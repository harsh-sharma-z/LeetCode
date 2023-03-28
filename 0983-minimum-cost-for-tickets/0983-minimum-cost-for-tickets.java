class Solution {
    
    int t[]=new int[365];
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        Arrays.fill(t,-1);
        return solve(days,costs,n,0);
    }
    
    int solve (int[] days, int[] costs, int n, int i)
    {
        if(i>=n)
            return 0; //can't travel
        
        if(t[i]!=-1)
            return t[i];
        //1-day
        int cost1=costs[0]+solve(days,costs,n,i+1);
        
        
        //7-days
        int j=i;
        
        int max_day= days[i]+7;
        
        while(j<n && days[j]<max_day )
        {
            j++;
        }
        
        int cost7= costs[1]+solve(days,costs,n,j);
        
        
        //30-days
        
        j=i;
        
        max_day=days[i]+30;
        
        while(j<n && days[j]< max_day)
        {
            j++;
        }
        
        int cost30=costs[2]+solve(days,costs,n,j);
        
        return t[i]=Math.min(cost1, Math.min(cost7,cost30));
    }
}