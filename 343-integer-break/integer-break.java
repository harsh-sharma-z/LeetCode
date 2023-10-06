class Solution {
    public int integerBreak(int n) {
        if(n <= 3) return n - 1;

        int rev = n / 3 , rem = n % 3;

        return rem == 0 ? (int)Math.pow(3 , rev) : (rem == 1 ? (int)Math.pow(3 , rev - 1) * 4 : (int)Math.pow(3 , rev) * 2);
    }
}