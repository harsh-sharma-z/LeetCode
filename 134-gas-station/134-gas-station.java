class Solution {
    
        public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0;
        int ans=0;
            int tank=0;
        for (int i = 0; i < cost.length; i++) {
            total+=(gas[i]-cost[i]);
            tank+=gas[i]-cost[i];
            if(tank<0)
            {
                tank=0;
                ans=i+1;
            }
            
        }

        if(total<0)
        {
            return -1;
        }
        
        return ans;
        
    }
}