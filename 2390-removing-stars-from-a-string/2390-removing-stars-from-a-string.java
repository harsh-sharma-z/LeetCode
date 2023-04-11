class Solution {
    public String removeStars(String s) {
        StringBuilder ans=new StringBuilder("");
        int i=s.length()-1;
        int star=0;
        while(i>=0)
        {
            char a=s.charAt(i);
            if(star==0 && a!='*')
            {
                ans.append(a);
                i--;
            }
            else if(a=='*')
            {
                star++;
                i--;
            }
            else if(star>0 && a!='*')
            {
                i--;
                star--;
            }
            
        }
        
        return (ans.reverse()).toString();
    }
}