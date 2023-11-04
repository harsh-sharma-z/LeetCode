class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        // <---------
        for(int x : left){
            res = Math.max(x , res);
        }
        // --------->
        for(int x : right){
            res = Math.max(n - x , res);
        }

        return res;
    }
}