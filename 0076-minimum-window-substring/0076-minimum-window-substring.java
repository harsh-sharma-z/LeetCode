class Solution {
    public String minWindow(String s, String t) {
          if(s=="" || t=="")
            return "";
        if(s==null || t==null)
            return "";
        String ans="";
        HashMap<Character,Integer> uwu=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            uwu.put(t.charAt(i),uwu.getOrDefault(t.charAt(i),0)+1);
        }
        int match=0;
        int dmatch=t.length();
        HashMap<Character,Integer> oni=new HashMap<>();
        
        int i=-1;
        int j=-1;
        
        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            while(i<s.length()-1 && match<dmatch)
            {
                i++;
                char ch=s.charAt(i);
                oni.put(ch,oni.getOrDefault(ch,0)+1);
                
                if(oni.getOrDefault(ch,0)<=uwu.getOrDefault(ch,0))
                {
                    match++;
                }
                f1=true;
                
            }
            
            while(j<i && match==dmatch )
            {
                String po=s.substring(j+1,i+1);
                if(ans.length()==0 || ans.length()>po.length())
                    ans=po;
            
            
            j++;
            char ch=s.charAt(j);
            if(oni.get(ch)==1)
                oni.remove(ch);
            else
            {
                oni.put(ch,oni.get(ch)-1);
            }
            
            if(oni.getOrDefault(ch,0)<uwu.getOrDefault(ch,0))
            {
                match--;
                
            }
            f2=true;
            
        }
            
            if(f1==false && f2==false)
                break;
        }
            
            
        return ans;
    }
}