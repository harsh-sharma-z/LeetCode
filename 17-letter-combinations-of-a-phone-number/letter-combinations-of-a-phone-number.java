class Solution {
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<String>();

        if(digits.length() == 0)
            return ans;
        
        HashMap<Character , String> map = new HashMap<>();
        map.put('2' , "abc");
        map.put('3' , "def");
        map.put('4' , "ghi");
        map.put('5' , "jkl");
        map.put('6' , "mno");
        map.put('7' , "pqrs");
        map.put('8' , "tuv");
        map.put('9' , "wxyz");
        int n = digits.length();
        solve(0  , new StringBuilder() , map , n , digits);
    
        return ans;
    }

    private void solve(int idx , StringBuilder temp , HashMap<Character , String> map , int n , String digits){

        if(temp.length() == n){
            ans.add(temp.toString());
            return;
        }

        if(idx >= n)
            return;
        
        String curr = map.get(digits.charAt(idx));

        for(char c : curr.toCharArray()){
            temp.append(c);
            solve(idx + 1 , temp , map , n , digits);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}