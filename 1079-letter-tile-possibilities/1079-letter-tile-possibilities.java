class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq=new int[26];

        for(int i=0;i<tiles.length();i++)
        {
            freq[tiles.charAt(i)-'A']++;
        }
        return(subsPermutation("",freq));
    }
    
    
    private static int subsPermutation(String res,int[] freq)
    {
        int c=0;
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]>=1)
            {
                char ch=(char) ('A'+i);
                freq[i]--;
                c+=subsPermutation(res+ch,freq)+1;
                freq[i]++;
            }
        }
        return c;
    }
    
}