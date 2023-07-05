class Solution {
    public int minimizeXor(int num1, int num2) {
        int c = setBits(num2);
        int ans = 0;
        for(int i = 31 ; i >= 0 && c > 0; i--){
            if((num1 & (1 << i)) != 0){
                ans += (1<<i);
                c--;
            }
        }

        for(int i = 0 ; i < 32 && c > 0 ; i++){
            if((num1 & (1 << i)) == 0){
                ans += (1 << i);
                c--;
            }
       }
       return ans;
    }

    private int setBits(int n)
    {
        int c = 0;
        while( n > 0 ){
            c++;
            n = ( n & (n-1));
        }
        return c;
    }
}