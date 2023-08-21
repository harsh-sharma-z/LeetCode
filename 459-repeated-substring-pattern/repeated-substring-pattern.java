class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int l = n/2 ; l > 0 ; l--){
            if(n % l == 0){
                int times = n / l;
                String pattern = s.substring(0 , l);
                String str = "";
                while(times-->0){
                    str = str + pattern;
                }
                if(str.equals(s))
                    return true;
            }
        }
        return false;
    }
}