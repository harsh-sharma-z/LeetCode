class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int mid = s.length() / 2 , ans = 0;
        for(int i = 0 , j = mid ; i < mid ; i++ , j++){
            if(vowels.indexOf(s.charAt(i)) >= 0)
                ans++;
            if(vowels.indexOf(s.charAt(j)) >= 0)
                ans--;
        }
        return ans == 0;
    }
}