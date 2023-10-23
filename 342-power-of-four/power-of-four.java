class Solution {
    public boolean isPowerOfFour(int n) {

        // //loop vala logic
        // if(n == 0)
        //     return false;
        // while(n % 4 == 0)
        //     n /= 4;
        // return n == 1;

        // //log n vala logic
        // if(n <= 0)
        //     return false;
        // int x = (int)(Math.log(n) / Math.log(4));
        // return Math.pow(4 , x) == n;

        //Bit magic vala logic
        if(n <= 0)
            return false;
        return (((n & (n - 1)) == 0) && ((n - 1) % 3 == 0));
    }
}