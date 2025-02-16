class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        Arrays.fill(res , -1);

        solve(0 , n , res , used);

        return res;
    }
    public boolean solve(int i , int n , int[] res , boolean[] used) {
         if(i >= res.length) {
            return true;
            //garaunteed answer because we were filling lex largest number first
        }

        if(res[i] != -1) {
            return solve(i + 1 , n , res , used);
        }

        for(int num = n ; num >= 1 ; num--) {
            if(used[num]) {
                continue;
            }
            //number try karke dekhte hain
            used[num] = true;
            res[i] = num;

            //is number ke aage explore karke dekhte hain
            if(num == 1) {
                if(solve(i + 1 , n , res , used)) {
                    return true;
                }
            }
            else {
                int j = res[i] + i;
                if(j < res.length && res[j] == -1) {
                    res[j] = num;
                    if(solve(i + 1 , n , res , used)) {
                        return true;
                    }
                    res[j] = -1; 
                }
            }

            //undo karte hain ab
            used[num] = false;
            res[i] = -1;
        } 
        return false;
    }
}