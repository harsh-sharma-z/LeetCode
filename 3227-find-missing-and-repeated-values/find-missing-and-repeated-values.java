class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int l = grid.length;
        long n = l * l;

        long sn = (n * (n + 1)) / 2;
        long s2n = (long)(n * (n + 1) * (2*n + 1)) / 6;

        long s = 0 , s2 = 0;

        for(int[] i : grid) {
            for(int j : i) {
                s += j;
                s2 += (long)(j * j);
            }
        }


        long val1 = s - sn; // x - y
        long val2 = s2 - s2n; 
        val2 = val2 / val1; // x + y

        long x = (val1 + val2) / 2;

        long y = x - val1;

        return new int[]{(int)x , (int)y};




        
    }
}