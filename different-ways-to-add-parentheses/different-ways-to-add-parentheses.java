class Solution {
    public List<Integer> diffWaysToCompute(String s) {

        if(s.indexOf('+')==-1 && s.indexOf('-')==-1 && s.indexOf('*')==-1) {
            List<Integer> res = new ArrayList<>();
            res.add(Integer.parseInt(s));
            return res;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)){
                List<Integer> left = diffWaysToCompute(s.substring(0 , i));
                List<Integer> right = diffWaysToCompute(s.substring(i + 1));
                for( int a : left){
                    for( int b : right){
                        int val = calc ( a , b , ch);
                        ans.add(val);
                    }
                }
            }
        }

        return ans;
    }

    public static int calc ( int a , int b , char ch ) { 
        if(ch == '+')
            return a+b;
        else if(ch == '-')
             return a-b;
        else
            return a*b;
    }
}