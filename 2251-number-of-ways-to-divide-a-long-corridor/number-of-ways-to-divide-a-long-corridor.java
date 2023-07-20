class Solution {
    public int numberOfWays(String s) {
        long totalSeats = 0 , seat = 0 , plant = 0 , mod = 1000_000_007;
        boolean firstCorridor = false;
        long ans = 1;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'S'){
                totalSeats++;
                seat++;
            }
            else if(seat == 0){
                plant++;
            }
            if(seat == 2){
                if(firstCorridor){
                    ans = ans * (plant + 1);
                    ans %= mod;
                }
                firstCorridor = true;
                seat = 0;
                plant = 0;
            }
        }

        if(totalSeats == 0 || (totalSeats & 1) != 0)
                return 0;
        return (int)ans;
    }
}