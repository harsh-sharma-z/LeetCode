class Solution {
    public String pushDominoes(String dominos) {
        StringBuffer str = new StringBuffer(dominos);
        int i=0;
        while(i<str.length()){
            if(str.charAt(i)=='R'){
                while(i<str.length()&& str.charAt(i)=='R')i++;
                i--;
                int j=i+1;
                while( j<str.length() && str.charAt(j) == '.' ){
                    j++;
                }
                if( j==str.length() || str.charAt(j)=='R'){
                    while(i<j){
                        str.setCharAt(i,'R');
                        i++;
                    }
                    continue;
                }
                int t=j;
                while(i<j){
                    str.setCharAt(i,'R');
                    str.setCharAt(j,'L');
                    i++;
                    j--;
                }
                i=t;
            }else if(str.charAt(i)=='L'){
                int t=i-1;
                while(t>=0 && str.charAt(t)=='.'){
                    str.setCharAt(t,'L');
                    t--;
                }
            }        
            i++;
        }
        return str.toString();
    }
}