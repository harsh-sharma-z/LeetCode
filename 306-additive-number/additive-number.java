import java.math.*;

class Solution {
    public boolean isAdditiveNumber(String num) {
        List<BigInteger> uwu = new LinkedList<>();
        return isAdditive(num , uwu);
    }

    private boolean isAdditive ( String ques , List<BigInteger> uwu){
        if(ques.length() == 0) {
            if(uwu.size() >= 3)
                return true;
            return false;
        }

        for(int i = 1 ; i <= ques.length() ; i++){
            String s1 = ques.substring(0 , i);
            if(nonLeading(s1) && validAdditive(uwu , s1)){
                uwu.add(new BigInteger(s1));
                boolean ans = isAdditive(ques.substring(i) ,  uwu);
                if(ans) return ans;
                uwu.remove(uwu.size() - 1);
            }
        }

        return false;
    }

    private boolean nonLeading(String s){
        if(s.length() == 1) return true;
        return s.charAt(0) != '0';
    }

    private boolean validAdditive(List<BigInteger> uwu , String s){
        if(uwu.size() <= 1) return true;

        BigInteger fi = uwu.get(uwu.size() - 1);
        BigInteger sec = uwu.get(uwu.size() - 2);
        BigInteger ans = new BigInteger(s);

        return fi.add(sec).equals(ans);
    }
}