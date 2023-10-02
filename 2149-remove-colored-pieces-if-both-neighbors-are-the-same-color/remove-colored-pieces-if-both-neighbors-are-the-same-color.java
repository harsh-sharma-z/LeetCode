class Solution {
    public boolean winnerOfGame(String s) {
        int alice =  0 , bob = 0;
        for(int i = 1 ; i < s.length() - 1 ; i++){
            if(s.charAt(i) == 'A' && s.charAt(i - 1) == 'A' && s.charAt(i + 1) == 'A') alice ++;
            if(s.charAt(i) == 'B' && s.charAt(i - 1) == 'B' && s.charAt(i + 1) == 'B') bob ++;
        }
        return alice > bob;
    }
}