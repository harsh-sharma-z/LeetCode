class Solution {
    public boolean isPowerOfFour(int n) {

        //loop vala logic
        if(n == 0)
            return false;
        while(n % 4 == 0)
            n /= 4;
        return n == 1;
    }
}