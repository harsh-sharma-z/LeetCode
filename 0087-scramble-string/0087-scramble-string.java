class Solution {
    private HashMap<String,Boolean> map;
    public boolean isScramble(String s1, String s2) {
         map=new HashMap<>();
         return help(s1,s2);
    }
    private boolean help(String s1,String s2)
    {
        int n=s1.length();
        if(s1.equals(s2))
        {
            map.put(s1+s2,true);
            return true;
        }
        
        if(map.containsKey(s1+s2))
        {
            return map.get(s1+s2);
        }
        
        for(int i=1;i<n;i++)
        {
            String a =s1.substring(0,i);
            String b =s2.substring(0,i);
            String c =s1.substring(i,n);
            String d =s2.substring(i,n);
            if(help(a,b) && help(c,d))
            {
                map.put(s1+s2,true);
                return true;
            }
            String e =s1.substring(0,i);
            String f =s2.substring(n-i,n);
            String g =s1.substring(i,n);
            String h =s2.substring(0,n-i);
            
            if(help(e,f) && help(g,h))
            {
                map.put(s1+s2,true);
                return true;
            }
        }
        map.put(s1+s2,false);
        return false;
        
    }
}