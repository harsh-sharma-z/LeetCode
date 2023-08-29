class Solution {
    public int bestClosingTime(String c) {
        int n = c.length();
        int  minHour = 0;

        int penalty = 0;
        for(int i = 0 ; i < n ; i ++)
            if(c.charAt(i) == 'Y')
                penalty ++;
        int minPenalty = penalty;
        
        for(int i = 0 ; i < n ; i++){
            if(c.charAt(i) == 'Y')
                penalty --  ;
            else
                penalty ++;
            
            if(penalty < minPenalty){
                minPenalty = penalty;
                minHour = i + 1;
            }
        }

        return minHour;
    }
}