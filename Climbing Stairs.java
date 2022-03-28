class Solution {
    public int climbStairs(int n) {
         int first=0, second=1;
        
        while(n!=0){
            int temp = first+second;
            first = second;
            second = temp;
            n--;
        }
        
        return second;
    }
}
