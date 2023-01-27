class Solution {
     public boolean func(String s, Set<String> set){
        int n=s.length();
        if(n==0) return false;
        for(int i=1; i<n ;i++){
            String s1=s.substring(0,i);
            String s2=s.substring(i,n);
            if(set.contains(s1) && (set.contains(s2) || func(s2,set))){
                return true;
            }
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans=new ArrayList<>();
        Set<String> set=new HashSet<>();
        for(String w: words) set.add(w);
        for(String w: words){
            if(func(w,set)) ans.add(w);
        }
        return ans;
    }
}