class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] index = new int[26];
        Arrays.fill(index , -1);
        int ans = -1;

        for(int i = 0 ; i < s.length() ; i++){
            int temp = s.charAt(i) - 'a';
            if(index[temp] == -1){
                index[temp] = i;
            }
            else{
                ans = Math.max(ans , i - index[temp] - 1);
            }
        }
        return ans;
    }
}