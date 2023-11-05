class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = -1;
        for(int i : arr)
            max = Math.max(max , i);
        if(k >= n){ //max  element will come at zero atleast once, so winner is max
            return max;
        }

        int winner = arr[0];
        int win = 0;

        for(int i = 1 ; i < n ; i++){
            if(arr[i] > winner){
                winner = arr[i];
                win = 1;
            }
            else{
                win ++;
            }

            if(win == k || winner == max){
                return winner;
            }
        }
        return -1;
    }
}