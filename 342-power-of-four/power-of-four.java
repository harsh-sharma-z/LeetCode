class Solution {
    public boolean isPowerOfFour(int n) {

        // //loop vala logic
        // if(n == 0)
        //     return false;
        // while(n % 4 == 0)
        //     n /= 4;
        // return n == 1;

        //log n vala logic
        if(n <= 0)
            return false;
        int x = (int)(Math.log(n) / Math.log(4));
        return Math.pow(4 , x) == n;
    }
}